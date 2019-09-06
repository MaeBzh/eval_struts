package fr.imie.struts.repositories;

import fr.imie.struts.database.DatabaseConnection;
import fr.imie.struts.javaBeans.Product;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private Product product;
    private Connection connection;

    public ProductRepository() throws Exception {
        this.connection = DatabaseConnection.connection();
    }

    public void create(Product product) throws SQLException {
        if (this.product != null) {
            try {
                String sql = String.format("INSERT INTO product (name, price) VALUES (%s, %s)",
                        this.product.getName(),
                        this.product.getPrice());
                PreparedStatement ps = this.connection.prepareStatement(sql);
                ps.executeQuery();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (this.connection != null) {
                    this.connection.close();
                }
            }
        }
    }

    public void update(Product product) throws SQLException {
        if (this.product != null) {
            try {
                String sql = String.format("UPDATE product SET  name = %s, price = %s WHERE product.id = %s",
                        this.product.getName(),
                        this.product.getPrice());
                PreparedStatement ps = this.connection.prepareStatement(sql);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (this.connection != null) {
                    this.connection.close();
                }
            }
        }
    }

    public Product get(int id) throws SQLException {
        Product result = null;
        if (id != 0) {
            try {
                String sql = String.format("SELECT * FROM product WHERE product.id = %s",
                        this.product.getId());
                PreparedStatement ps = this.connection.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery();
                result = this.resultToItem(resultSet);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (this.connection != null) {
                    this.connection.close();
                }
            }
        }
        return result;
    }

    public List<Product> getAll() throws SQLException {
        List<Product> result = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            result = this.resultToItems(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (this.connection != null) {
                this.connection.close();
            }
        }
        return result;
    }

    public void delete(Product product) throws SQLException {
        if (this.product != null) {
            try {
                String sql = String.format("DELETE product WHERE product.id = %s",
                        this.product.getId());
                PreparedStatement ps = this.connection.prepareStatement(sql);
                ps.executeQuery();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (this.connection != null) {
                    this.connection.close();
                }
            }
        }
    }

    private Product resultToItem(@NotNull ResultSet resultSet) {
        Product product = new Product();
        try {
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getFloat("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    private List<Product> resultToItems(@NotNull ResultSet resultSet) throws SQLException {
        List<Product> productsList = new ArrayList<Product>();
        while(resultSet.next()) {
            productsList.add(this.resultToItem(resultSet));
        }
        return productsList;
    }
}
