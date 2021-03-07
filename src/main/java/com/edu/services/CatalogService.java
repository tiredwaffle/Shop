package com.edu.services;

import com.edu.dao.DaoFactory;
import com.edu.dao.ItemDao;
import com.edu.entities.Item;

import java.sql.SQLException;
import java.util.LinkedList;

public class CatalogService {

    public LinkedList<Item> GetItems() throws SQLException {
        ItemDao itemDao = DaoFactory.createItemDao();
        return itemDao.findAll();
    }
}
