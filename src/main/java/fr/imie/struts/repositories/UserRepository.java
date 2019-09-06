package fr.imie.struts.repositories;

import fr.imie.struts.database.DatabaseConnection;
import fr.imie.struts.javaBeans.User;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private User user;
    private Connection connection;

    public UserRepository() throws Exception {
        this.connection = DatabaseConnection.connection();
    }

    public void create(User user) throws SQLException {
        if (this.user != null) {
            try {
                String sql = String.format("INSERT INTO user (firstname, lastname, password, address, email, isAdmin) VALUES (%s, %s, %s, %s, %s, %s)",
                        this.user.getFirstname(),
                        this.user.getLastname(),
                        this.user.getPassword(),
                        this.user.getAddress(),
                        this.user.getEmail(),
                        this.user.isAdmin());
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

    public void update(User user) throws SQLException {
        if (user != null) {
            try {
                String sql = String.format("UPDATE user SET  firstname = %s, lastname = %s, password = %s, address = %s, email = %s, isAdmin = %s WHERE user.id = %s",
                        this.user.getFirstname(),
                        this.user.getLastname(),
                        this.user.getPassword(),
                        this.user.getAddress(),
                        this.user.getEmail(),
                        this.user.getId(),
                        this.user.isAdmin());
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

    public User get(int id) throws SQLException {
        User result = null;
        if (id != 0) {
            try {
                String sql = String.format("SELECT * FROM user WHERE user.id = %s",
                        this.user.getId());
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

    public User getWithEmail(String email, String password) throws SQLException {
        User result = null;
        if (email != null && password != null) {
            try {
                String sql = String.format("SELECT * FROM user WHERE user.email = %s AND user.password = %s",
                        email, password);
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

    public List<User> getAll() throws SQLException {
        List<User> result = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM client";
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

    public void delete(User user) throws SQLException {
        if (this.user != null) {
            try {
                String sql = String.format("DELETE user WHERE user.id = %s",
                        this.user.getId());
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

    private User resultToItem(@NotNull ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            user.setPassword(resultSet.getString("password"));
            user.setAddress(resultSet.getString("address"));
            user.setEmail(resultSet.getString("email"));
            user.setAdmin(resultSet.getBoolean("isAdmin"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private List<User> resultToItems(@NotNull ResultSet resultSet) throws SQLException {
        List<User> clientsList = new ArrayList<User>();
        while (resultSet.next()) {
            clientsList.add(this.resultToItem(resultSet));
        }
        return clientsList;
    }
}
