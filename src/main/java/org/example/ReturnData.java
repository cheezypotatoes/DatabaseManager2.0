package org.example;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("SqlDialectInspection")
public class ReturnData {

    public String dataLocation;

    /**
     * Constructs a ReturnData object with the specified data location.
     *
     * @param dataLocation The location where the data is stored.
     */
    public ReturnData(String dataLocation) {
        this.dataLocation = dataLocation;
    }

    /**
     * Returns the latest user ID from the database.
     *
     * @return The latest user ID, or -1 if an error occurs or no user ID is found.
     * This method executes a SQL query to retrieve the latest user ID from the "users" table.
     * It returns the latest user ID if found, otherwise, it returns -1.
     * Any SQL exceptions encountered are logged using a logger named "InsertDataLogger".
     */
    public int ReturnLatestId(){
        Logger logger = Logger.getLogger("InsertDataLogger");
        int userId;
        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            String sql = "SELECT id FROM users ORDER BY id DESC LIMIT 1";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        userId = resultSet.getInt("id");
                        return userId;
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Returning Latest Id", e);
        }

        return -1;

    }

    /**
     * Returns the titles of the top three books based on copies sold.
     *
     * @return An array containing the titles of the top three books, or null if an error occurs.
     * This method executes a SQL query to retrieve the titles of the top three books based on the number of copies sold.
     * It returns an array containing the titles of the top three books if found, otherwise, it returns null.
     * Any SQL exceptions encountered are logged using a logger named "InsertDataLogger".
     */
    public String[] ReturnTopThreeBookTitle() {
        Logger logger = Logger.getLogger("InsertDataLogger");
        String[] topBookIds = new String[3];

        try (Connection connection = DriverManager.getConnection(this.dataLocation);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT title FROM book_details ORDER BY copies_sold DESC LIMIT 3");
             ResultSet resultSet = statement.executeQuery()) {

            for (int i = 0; i < 3; i++){
                if (resultSet.next()){
                    topBookIds[i] = resultSet.getString("title");
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error ReturnTopThreeBooks", e);
        }

        return topBookIds;
    }


    /**
     * Returns the ID of a book based on its title.
     *
     * @param title The title of the book.
     * @return The ID of the book, or -1 if the book is not found or an error occurs.
     * This method executes a SQL query to retrieve the ID of the book with the given title from the "book_details" table.
     * It returns the ID of the book if found, otherwise, it returns -1.
     * Any SQL exceptions encountered are logged using a logger named "InsertDataLogger".
     */
    public int returnBookIdByTitle(String title) {
        Logger logger = Logger.getLogger("InsertDataLogger");

        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            String sql = "SELECT id FROM book_details WHERE title = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, title);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("id");
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Returning Latest Id", e);
        }

        return -1;
    }

    /**
     * Returns the description of a book based on its title.
     *
     * @param title The title of the book.
     * @return The description of the book, or null if the book is not found or an error occurs.
     * This method executes a SQL query to retrieve the description of the book with the given title
     * from the "book_description" table. It returns the description of the book if found, otherwise, it returns null.
     * Any SQL exceptions encountered are logged using a logger named "InsertDataLogger".
     */
    public String returnBookDescriptionByTitle(String title){
        Logger logger = Logger.getLogger("InsertDataLogger");

        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            String sql = "SELECT description FROM book_description WHERE book_title = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, title);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("description");
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Returning Latest Id", e);
        }

        return null;
    }

    //TODO RETURN ALL BOOKS
    //TODO RETURN ALL USERS
    //TODO RETURN ALL GENRE OF SPECIFIC BOOK
    //TODO RETURN ALL BOOK BOUGHT BY USER
    //TODO RETURN USER SPECIFIC DETAILS
    //TODO RETURN USER ID BY USERNAME


}