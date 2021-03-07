package com.edu.services;

import com.edu.dao.CheckDao;
import com.edu.dao.DaoFactory;
import com.edu.entities.Check;
import com.edu.entities.Employee;

import java.sql.SQLException;
import java.util.LinkedList;

public class CheckService {
    private CheckDao checkDao = DaoFactory.createCheckDao();

    public CheckService() throws SQLException {
    }

    public void cancelCheck(int check_id) {
        checkDao.cancelCheck(check_id);
    }

    public void createCheck(Check check){
        checkDao.create(check);
    }

    public Check getCheck(int check_id){
        return checkDao.findById(check_id);
    }

    public LinkedList<Check> getAllCheks(){
        return checkDao.findAll();
    }

    public LinkedList<Check> getChecksById(int createdBy){
        return checkDao.findChecksByCreatedBy(createdBy);
    }
}
