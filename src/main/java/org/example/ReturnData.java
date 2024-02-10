package org.example;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

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

    /**
     * Returns the genres of a book based on its title.
     *
     * @param title The title of the book.
     * @return An array containing the genres of the book, or an empty array if the book is not found or an error occurs.
     * This method executes a SQL query to retrieve the genres of the book with the given title
     * from the "book_genre" table. It returns an array containing the genres of the book if found,
     * otherwise, it returns an empty array.
     * Any SQL exceptions encountered are logged using a logger named "InsertDataLogger".
     */
    public String[] returnBookGenreByTitle(String title){
        Logger logger = Logger.getLogger("InsertDataLogger");
        List<String> genres = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            String sql = "SELECT genre FROM book_genre WHERE title = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, title);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        genres.add(resultSet.getString("genre"));
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Returning Book Genre By Title", e);
        }
        return genres.toArray(new String[0]); // Converts arraylist to array
    }

    /**
     * Returns all user data from the database.
     *
     * @return A 2D array containing all user data, or an empty array if no users are found or an error occurs.
     * This method executes a SQL query to retrieve all user data from the "users" table.
     * It returns a 2D array containing all user data if users are found, otherwise, it returns an empty array.
     * Any SQL exceptions encountered are logged using a logger named "InsertDataLogger".
     */
    public String[][] returnAllUsers() {
        Logger logger = Logger.getLogger("InsertDataLogger");
        List<String[]> userDataList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            String sql = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Create an array to hold user data
                        String[] userData = new String[6]; // Assuming 6 columns in the "users" table
                        // Populate the array with user data from the result set
                        userData[0] = Integer.toString(resultSet.getInt("id"));
                        userData[1] = resultSet.getString("email");
                        userData[2] = resultSet.getString("username");
                        userData[3] = resultSet.getString("password");
                        userData[4] = resultSet.getBoolean("is_admin") ? "true" : "false";
                        userData[5] = Double.toString(resultSet.getDouble("balance"));
                        // Add the array to the list
                        userDataList.add(userData);
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Returning Users", e);
        }

        // Convert the list to a 2D array
        String[][] userDataArray = new String[userDataList.size()][];
        userDataList.toArray(userDataArray);

        return userDataArray;
    }

    /**
     * Returns all book data from the database.
     *
     * @return A 2D array containing all book data, or an empty array if no books are found or an error occurs.
     * This method executes a SQL query to retrieve all book data from the "book_details" table.
     * It returns a 2D array containing all book data if books are found, otherwise, it returns an empty array.
     * Any SQL exceptions encountered are logged using a logger named "InsertDataLogger".
     */
    public String[][] returnAllBooks() {
        Logger logger = Logger.getLogger("InsertDataLogger");
        List<String[]> bookData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            String sql = "SELECT * FROM book_details";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Create an array to hold book data
                        String[] bookRow = new String[8]; // Assuming 7 columns in the "book_details" table
                        // Populate the array with book data from the result set
                        bookRow[0] = Integer.toString(resultSet.getInt("id"));
                        bookRow[1] = resultSet.getString("title");
                        bookRow[2] = resultSet.getString("image_link");
                        bookRow[3] = Integer.toString(resultSet.getInt("author_id"));
                        bookRow[4] = resultSet.getBoolean("is_available") ? "true" : "false";
                        bookRow[5] = Double.toString(resultSet.getDouble("price"));
                        bookRow[6] = Integer.toString(resultSet.getInt("copies_sold"));
                        String[] genres = returnBookGenreByTitle(bookRow[1]);
                        if (genres != null && genres.length > 0) {
                            // Join genres into a single string
                            StringBuilder genreStringBuilder = new StringBuilder();
                            for (String genre : genres) {
                                genreStringBuilder.append(genre).append(", ");
                            }
                            // Remove the last comma and space
                            String genreString = genreStringBuilder.substring(0, genreStringBuilder.length() - 2);
                            bookRow[7] = genreString;
                        } else {
                            bookRow[7] = ""; // No genres found
                        }
                        // Add the array to the list
                        bookData.add(bookRow);
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Returning Books", e);
        }

        // Convert the list to a 2D array
        String[][] bookDataArray = new String[bookData.size()][];
        bookData.toArray(bookDataArray);

        return bookDataArray;
    }


    /**
     * Returns the user ID based on the username.
     *
     * @param username The username of the user.
     * @return The user ID corresponding to the username, or null if the username is not found or an error occurs.
     * This method executes a SQL query to retrieve the user ID from the "users" table based on the provided username.
     * It returns the user ID if the username is found, otherwise, it returns null.
     * Any SQL exceptions encountered are logged using a logger named "InsertDataLogger".
     */
    public String userUserIdByUsername(String username){
        Logger logger = Logger.getLogger("InsertDataLogger");

        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            String sql = "SELECT id FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return String.valueOf(resultSet.getInt("id"));
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Returning id", e);
        }

        return null;
    }




    //TODO RETURN ALL BOOK BOUGHT BY USER, MAKE BUY BOOK FIRST
    //TODO RETURN USER SPECIFIC DETAILS, MAKE BUY BOOK FIRST TO RETURN BOOK BOUGHT


}