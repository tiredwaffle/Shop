package com.edu.dao;

import com.edu.entities.Check;
import com.edu.entities.CheckItem;

import java.util.LinkedList;

public interface CheckItemDao extends Dao<CheckItem>{
    void refundItem(int checkId, int itemId);
    LinkedList<CheckItem> findByCheckId(int checkId);
}

