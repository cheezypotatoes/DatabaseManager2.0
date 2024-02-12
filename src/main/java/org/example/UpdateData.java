package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("SqlDialectInspection")
public class UpdateData {

    public String dataLocation;

    /**
     * Constructs a UpdateData object with the specified data location.
     *
     * @param dataLocation The location where the data is stored.
     */
    public UpdateData(String dataLocation) {
        this.dataLocation = dataLocation;
    }

    /**
     * Updates the balance for a user with the specified user ID.
     *
     * @param user_id The ID of the user whose balance is to be updated.
     * @param updated_balance The updated balance for the user.
     *
     * This method updates the balance for a user with the provided user ID in the "users" table of the database.
     */
    public void UpdateUserCash(int user_id, double updated_balance){
        Logger logger = Logger.getLogger("UpdateUserCashLogger");
        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            // SQL statement to update the balance for a user with a specific user_id
            String updateBalanceSQL = "UPDATE users SET balance = ? WHERE id = ?;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateBalanceSQL)) {
                // Set values for the parameters in the prepared statement
                preparedStatement.setDouble(1, updated_balance);
                preparedStatement.setInt(2, user_id);

                // Execute the SQL statement to update the balance
                int rowsAffected = preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            // Log the SQLException
            logger.log(Level.SEVERE, "Error updating user balance", e);
        }
    }

    /**
     * Increases the number of copies sold for a book by one.
     *
     * @param bookId The ID of the book for which copies sold are to be increased.
     * This method updates the "copies_sold" field in the "book_details" table by incrementing it by one
     * for the book with the specified ID.
     * Any SQL exceptions encountered are logged using a logger named "UpdateDataLogger".
     */
    public void increaseBookSoldByOne(int bookId){
        Logger logger = Logger.getLogger("UpdateDataLogger");
        try (Connection connection = DriverManager.getConnection(this.dataLocation)) {
            String updateCopiesSoldSQL = "UPDATE book_details SET copies_sold = copies_sold + 1 WHERE id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateCopiesSoldSQL)) {
                preparedStatement.setInt(1, bookId);

                // Execute the SQL statement to update copies_sold
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Copies sold updated successfully");
                } else {
                    System.out.println("No book found with the given ID");
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating copies sold in book_details table", e);
        }
    }



}
