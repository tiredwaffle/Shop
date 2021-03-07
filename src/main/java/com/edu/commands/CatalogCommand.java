package com.edu.commands;

import com.edu.entities.Item;
import com.edu.services.CatalogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.LinkedList;

public class CatalogCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        CatalogService catalogService = new CatalogService();
        LinkedList<Item> items = catalogService.GetItems();
        for (Item item : items) {
            System.out.println(item.toString());
        }
        request.setAttribute("list_items", items);
        return Pages.CATALOGUE_PAGE;
    }
}
