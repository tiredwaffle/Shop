package com.edu;

import com.edu.dao.*;
import com.edu.entities.Check;
import com.edu.entities.CheckItem;
import com.edu.entities.Employee;
import com.edu.entities.Item;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Item apples = new Item(3, 5, 0.5f, 10.0f, "Red Apples");
        Employee cashier1 = new Employee(5, "Jane", "Doe", "Cashier", 1, true);
        int checkId = 2;
        CheckItem boxOfApples = new CheckItem(1, checkId, 3, 1f, 1f, 10f, true);
        Check check1 = new Check(checkId, 1, 10, true);

        EmployeeDao employeeDao = DaoFactory.createEmployeeDao();
        System.out.println("All employees: ");
        employeeDao.findAll();
        employeeDao.create(cashier1);
        System.out.println("Added employees: ");
        employeeDao.findAll();
        System.out.println();

        ItemDao itemDao = DaoFactory.createItemDao();
        itemDao.create(apples);
        itemDao.findAll();
        System.out.println();

        CheckDao checkDao = DaoFactory.createCheckDao();
        checkDao.create(check1);
        checkDao.findAll();
        System.out.println();

        CheckItemDao checkItemDao = DaoFactory.createCheckItemDao();
        checkItemDao.create(boxOfApples);
        System.out.println("Items in check 1:");
        checkItemDao.findByCheckId(checkId);
        System.out.println();
//
//        checkItemDao.delete(0);
//        checkItemDao.delete(1);
//        checkDao.delete(checkId);
//        itemDao.delete(3);
//
//        employeeDao.delete(4);
//        employeeDao.findAll();
    }
}
