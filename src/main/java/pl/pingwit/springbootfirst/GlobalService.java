package pl.pingwit.springbootfirst;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

//@Component
public class GlobalService {
    private final UserService userService;
    private static final String URL = "jdbc:postgresql://localhost:5432/home_work_from_backup";
    private static final String NAME = "pingwit";
    private static final String PASSWORD = "pingwit_password";

    public GlobalService(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.printUser();
    }

    @Bean
    private static DataSource createDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(NAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    public static void main(String[] args) {
        DataSource dataSource = createDataSource();

        UserRepository userRepository = new UserRepository(dataSource);

        UserService userService = new UserService(userRepository);

        userService.printUser();
    }
}




