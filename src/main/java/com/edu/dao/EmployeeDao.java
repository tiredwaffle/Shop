package com.edu.dao;

import com.edu.entities.Check;
import com.edu.entities.Employee;

import java.util.LinkedList;
import java.util.List;

public interface EmployeeDao extends Dao<Employee>{
    void fireEmployee(int id);
    void promoteEmployee(int id, int level);
    Employee findBySurname(String surname);
}

