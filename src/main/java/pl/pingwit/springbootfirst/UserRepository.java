package pl.pingwit.springbootfirst;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private final DataSource dataSource;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<UserRecord> findAllUsers() {
        List<UserRecord> userRecordList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from users");
            while (resultSet.next()) {
                UserRecord userRecord = new UserRecord(resultSet.getString(2), resultSet.getString(3));
                userRecordList.add(userRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRecordList;
    }
}
