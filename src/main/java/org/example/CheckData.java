package org.example;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("SqlDialectInspection")
public class CheckData {

    public String dataLocation;

    /**
     * Constructs a CheckData object with the specified data location.
     *
     * @param dataLocation The location where the data is stored.
     */
    public CheckData(String dataLocation) {
        this.dataLocation = dataLocation;
    }

    /**
     * Checks if a description exists for a given book title in the database.
     *
     * @param bookTitle The title of the book to check for the existence of description.
     * @return true if a description exists for the book title, false otherwise.
     */
    public boolean checkIfDescriptionExists(String bookTitle) {
        boolean exists = false;

        try (Connection connection = DriverManager.getConnection(this.dataLocation);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book_description WHERE book_title = ?")) {

            preparedStatement.setString(1, bookTitle);
            ResultSet resultSet = preparedStatement.executeQuery();

            // If any rows are returned by the query, it means the description exists
            exists = resultSet.next();

        } catch (SQLException exception) {
            System.err.println("Error: " + exception.getMessage());
        }
        return exists;
    }

    /**
     * Checks if a username already exists in the database.
     *
     * @param username The username to check for existence.
     * @return true if the username already exists, false otherwise.
     * This method executes a SQL query to count the number of occurrences of the given username in the "users" table.
     * It returns true if the count is greater than 0, indicating that the username already exists in the database,
     * otherwise, it returns false.
     */
    public boolean CheckIfUserNameAlreadyExist(String username) {
        Logger logger = Logger.getLogger("InsertDataLogger");
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(this.dataLocation);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Username checker error", e);
        }
        return false;
    }

    public boolean CheckIfEmailAlreadyExist(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (Connection connection = DriverManager.getConnection(this.dataLocation);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
