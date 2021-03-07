package com.edu.dao;

import com.edu.entities.Item;

public interface ItemDao extends Dao<Item>{
    void changeAmount(int id, float newAmount);
    Item findByName(String partOfName);
}
