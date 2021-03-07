package com.edu.services;

import com.edu.dao.DaoFactory;
import com.edu.dao.EmployeeDao;
import com.edu.entities.Employee;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class ServiceLogIn {
    private String position = null;
    private int user_id;
    private boolean isSenior = false;

    public Boolean logIn (String surname)  {
        EmployeeDao employeeDao = null;
        try {
            employeeDao = DaoFactory.createEmployeeDao();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assert employeeDao != null;
        Employee employee = employeeDao.findBySurname(surname);
        if (employee == null) {
            System.out.println("User with surname: " + surname + " NOT FOUND");
            return Boolean.FALSE;
        }else{
            user_id = employee.getId();
            position = employee.getTitle();
            isSenior = employee.getLevel() > 5;
            System.out.println("Logged in successfully!");
            return Boolean.TRUE;
        }
    }

    public int getUserId(){
        return user_id;
    }

    public String getPosition(){
        return position;
    }

    public boolean isSenior(){
        return isSenior;
    }

}
