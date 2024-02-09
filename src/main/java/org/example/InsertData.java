package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertData{

    public String dataLocation;

    /**
     * Constructs a DatabaseManager object with the specified data location.
     *
     * @param dataLocation The location where the data is stored.
     */
    public InsertData(String dataLocation) {
        this.dataLocation = dataLocation;

    }

    /**
     * Inserts a new user into the database.
     *
     * @param email The email of the new user.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @param isAdmin A boolean indicating whether the new user is an admin or not.
     * @param balance The balance of the new user.
     *
     * This method inserts a new user with the provided information into the "users" table of the database.
     */
    public void InsertNewUser(String email, String username, String password, Boolean isAdmin, double balance) {
        Logger logger = Logger.getLogger("InsertDataLogger");
        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            // SQL statement to insert data into the "user_data" table
            String insertUserDataSQL = "INSERT INTO users (email, username, password, is_admin, balance) VALUES (?, ?, ?, ?, ?);";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserDataSQL)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);
                preparedStatement.setBoolean(4, isAdmin);
                preparedStatement.setDouble(5, balance);

                // Execute the SQL statement to insert data
                preparedStatement.executeUpdate();

                System.out.println("Data inserted into user_data table successfully");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error inserting data into user_data table", e);
        }
    }

    public void InsertNewBook(String title, String imageLink, String[] genre, int authorId, boolean availability, double bookPrice, int bookSold, String description){
        Logger logger = Logger.getLogger("InsertDataLogger");
        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            // SQL statement to insert data into the "book_details" table
            String insertBookDetailsSQL = "INSERT INTO book_details (title, image_link, author_id, is_available, price, copies_sold) VALUES (?, ?, ?, ?, ?, ?);";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertBookDetailsSQL)) {
                // Set values for the parameters in the prepared statement
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, imageLink);
                preparedStatement.setInt(3, authorId);
                preparedStatement.setBoolean(4, availability);
                preparedStatement.setDouble(5, bookPrice);
                preparedStatement.setInt(6, bookSold);

                // Execute the SQL statement to insert data
                preparedStatement.executeUpdate();

                System.out.println("Data inserted into book_details table successfully");

                // Insert description to the description table

                // TODO INSERT GENRE AND DESCRIPTION
                //InsertNewDescription(description);

            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error inserting data into user_data table", e);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error inserting data into user_data table", e);
        }
    }


}
