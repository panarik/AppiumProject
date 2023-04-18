package com.github.panarik.appiumProject.tools.testData;

import java.sql.*;

/**
 * Here test database methods for extract data from data and use it for tests.
 */
public class TestDatabase {

    private Connection connection;
    private Statement statement;

    public String getUserLogin(String userName) {
        connection();
        String result = "";
        try {
            ResultSet set = statement.executeQuery("" +
                    "SELECT user_login " +
                    "FROM users " +
                    "WHERE user_name = '" + userName + "'");
            result = set.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        disconnect();
        return result;
    }

    public String getCardFull(String userName, String cardName) {
        connection();
        String result = "";
        try {
            ResultSet set = statement.executeQuery("" +
                    "SELECT card.number_full " +
                    "FROM account, card " +
                    "WHERE account.user_name = '" + userName + "' AND card.name = '" + cardName + "'");
            result = set.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        disconnect();
        return result;
    }

    private void connection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/test/resources/test_database.db");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void disconnect() {
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
