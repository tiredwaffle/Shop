package com.edu.services;

import com.edu.dao.DaoFactory;
import com.edu.dao.ItemDao;
import com.edu.entities.Item;

import java.sql.SQLException;

public class ItemService {
    private ItemDao itemDao = DaoFactory.createItemDao();

    public ItemService() throws SQLException {
    }

    public void deleteItem(int id){
        itemDao.delete(id);
    }

    public void addItem(Item item){
        itemDao.create(item);
    }

    public Item getItemByName(String name){
        return itemDao.findByName(name);
    }

    public Item getItemById(int id){
        return itemDao.findById(id);
    }
}
