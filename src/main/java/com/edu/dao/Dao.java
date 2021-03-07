package com.edu.dao;

import java.util.LinkedList;
import java.util.List;

public interface Dao<T>{
    void create(T entity);
    T findById(int id);
    LinkedList<T> findAll();
    void update(T entity);
    void delete(int id);
}
