package com.edu.services;

import com.edu.dao.DaoFactory;
import com.edu.dao.EmployeeDao;
import com.edu.entities.Employee;

import java.sql.SQLException;

public class ServiceUser {
    public Employee getUser (String surname){
        EmployeeDao employeeDao = null;
        try {
            employeeDao = DaoFactory.createEmployeeDao();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDao.findBySurname(surname);
    }
}
