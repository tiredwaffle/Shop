package com.edu.services;

import com.edu.dao.CheckItemDao;
import com.edu.dao.DaoFactory;
import com.edu.entities.Check;
import com.edu.entities.CheckItem;
import com.edu.entities.Employee;

import java.sql.SQLException;
import java.util.LinkedList;

public class CheckItemService {
    private CheckItemDao checkItemDao = DaoFactory.createCheckItemDao();

    public CheckItemService() throws SQLException {
    }

    public LinkedList<CheckItem> getCheckItemsByCheckId(int check_id){
        return checkItemDao.findByCheckId(check_id);
    }

    public void addCheckItem(CheckItem item){
        checkItemDao.create(item);
    }

    public void cancelCheckItem(int check_id, int item_id) {
        checkItemDao.refundItem(check_id, item_id);
    }
}
