package Product.repository.model;

import Product.model.Product;
import Product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
public class DBProductRepositoryImp implements ProductRepository {
    private final DataSource dataSource;

    public DBProductRepositoryImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public Collection<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from products");

            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void delete(Integer productId) {

    }
    @Override
    public void deleteProductId(Integer id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> createProduct(Product productToCreate) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (id, name, description, price) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, productToCreate.id());
            preparedStatement.setString(2, productToCreate.name());
            preparedStatement.setString(3, productToCreate.description());
            preparedStatement.setDouble(4, productToCreate.price());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Product> searchById(Integer id) {
        return null;
    }

    @Override
    public List<Product> searchProductById(Integer id) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from products WHERE id=?");

            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> searchByDescription(String description) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {

            String condition = "%" + description + "%";
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE description LIKE ? ");
            preparedStatement.setString(1, condition);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

}
