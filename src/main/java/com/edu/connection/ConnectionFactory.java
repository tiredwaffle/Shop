package com.edu.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    /*private static final String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=UTC";
    private static final String dbUser = "root";
    private static final String dbPwd = "questerapp";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }*/

    private static final String driverClassName = "com.postgresql.cj.jdbc.Driver";
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String dbUser = "postgres";
    private static final String dbPwd = "1111";

    private static ConnectionFactory connectionFactory = null;


    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

}
