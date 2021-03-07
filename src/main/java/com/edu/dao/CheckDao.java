package com.edu.dao;

import com.edu.entities.Check;

import java.util.LinkedList;

public interface CheckDao extends Dao<Check>{
    void cancelCheck(int id);
    LinkedList<Check> findChecksByCreatedBy(int createdBy);
}
