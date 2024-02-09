package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
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

}
