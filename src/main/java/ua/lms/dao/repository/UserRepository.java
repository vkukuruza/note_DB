package ua.lms.dao.repository;

import ua.lms.dao.entity.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserRepository {

    public User getUserByEmailByPassword(String email, String password) {
        User user = null;
        DataSource dataSource = new DataSource();
        String query = "SELECT id, email, password, name, created_at, deleted_at FROM users " +
                "WHERE email='" + email + "' AND password='" + password + "'";
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("created_at"),
                        resultSet.getString("deleted_at")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void newUser(String name, String email, String password) {
        DataSource dataSource = new DataSource();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String createdAt = dateFormat.format(date);
        String query = "INSERT INTO note.users(email, password, name, created_at, deleted_at)" +
                "VALUES ('" + email + "', '" + password + "', '" + name + "', '" + createdAt + "', " + null + ");";
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Created new user.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
