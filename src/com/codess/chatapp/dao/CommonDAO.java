package com.codess.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.codess.chatapp.utils.ConfigReader.getValue;

public class CommonDAO {

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        // Load JDBC driver
        Class.forName(getValue("DRIVER"));

        // Get DB configuration values
        final String CONNECTION_STRING = getValue("CONNECTION_URL");
        final String USER_ID = getValue("USERID");
        final String PASSWORD = getValue("PASSWORD");

        // Establish and return the database connection
        Connection con = DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);

       
        System.out.println(" Connection Established...");

        return con;
    }
}
