package com.edu.commands;

import com.edu.services.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DeleteItemCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ItemService itemService = new ItemService();
        itemService.deleteItem(Integer.parseInt(request.getParameter("item_id")));
        return Pages.CONTROLLER + "?command=commodity_expert";
    }
}
