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





}
