package com.edu.commands;

import com.edu.entities.Item;
import com.edu.services.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class SubmitItemCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Item item = new Item();
        item.setName(request.getParameter("item_name"));
        item.setAmountAvailable(Float.parseFloat(request.getParameter("item_amount")));
        item.setPrice(Float.parseFloat(request.getParameter("item_price")));
        item.setWeight(Float.parseFloat(request.getParameter("item_weight")));
        ItemService itemService = new ItemService();
        itemService.addItem(item);
        return Pages.CONTROLLER + "?command=commodity_expert";
    }
}
