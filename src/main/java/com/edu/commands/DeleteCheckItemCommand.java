package com.edu.commands;

import com.edu.entities.CheckItem;
import com.edu.entities.Item;
import com.edu.services.CheckItemService;
import com.edu.services.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class DeleteCheckItemCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        CheckItemService checkItemService = new CheckItemService();
        HttpSession session = request.getSession();
        int check_id = (int) session.getAttribute("check_id");
        request.setAttribute("check_id", check_id);
        try{
            int id = Integer.parseInt(request.getParameter("delete_item"));
            checkItemService.cancelCheckItem(check_id, id);
        } catch (Exception exception){
            String name = request.getParameter("delete_item");
            ItemService itemService = new ItemService();
            Item item = itemService.getItemByName(name);
            checkItemService.cancelCheckItem(check_id, item.getId());
        }
        return "/controller?command=submit_selectedcheck";
    }
}
