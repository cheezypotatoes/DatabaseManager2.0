package org.example;

import java.sql.*;

@SuppressWarnings("ALL")

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




}
