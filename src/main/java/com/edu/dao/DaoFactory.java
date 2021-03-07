package com.edu.dao;

import com.edu.connection.ConnectionFactory;

import com.edu.dao.impl.CheckDaoImpl;
import com.edu.dao.impl.CheckItemDaoImpl;
import com.edu.dao.impl.EmployeeDaoImpl;
import com.edu.dao.impl.ItemDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {

    public static ItemDao createItemDao() throws SQLException {
        return new ItemDaoImpl(getConnection());
    }
    public static CheckItemDao createCheckItemDao() throws SQLException {
        return new CheckItemDaoImpl(getConnection());
    }
    public static CheckDao createCheckDao() throws SQLException {
        return new CheckDaoImpl(getConnection());
    }
    public static EmployeeDao createEmployeeDao() throws SQLException {
        return new EmployeeDaoImpl(getConnection());
    }

    private static Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
}