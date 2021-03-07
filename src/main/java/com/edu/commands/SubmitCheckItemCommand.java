package com.edu.commands;

import com.edu.entities.CheckItem;
import com.edu.entities.Item;
import com.edu.services.CheckItemService;
import com.edu.services.CheckService;
import com.edu.services.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class SubmitCheckItemCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        CheckItem checkItem = new CheckItem();
        int check_id = (int) session.getAttribute("check_id");
        request.setAttribute("check_id", check_id);
        System.out.println("CHECK_ID: " + check_id);
        checkItem.setCheckId(check_id);
        checkItem.setActive(true);

        float amount = 0.0F, weight = 0.0F;
        if(!request.getParameter("amount").equals(""))
            amount = Float.parseFloat(request.getParameter("amount"));
        if(!request.getParameter("weight").equals(""))
            weight = Float.parseFloat(request.getParameter("weight"));
        checkItem.setItemAmount(amount);
        checkItem.setItemWeight(weight);

        ItemService itemService = new ItemService();
        try{
            int id = Integer.parseInt(request.getParameter("name_id"));
            Item item = itemService.getItemById(id);
            checkItem.setItemId(id);
            checkItem.setItemPrice(item.getPrice());
        } catch (Exception exception){
            String name = request.getParameter("name_id");
            Item item = itemService.getItemByName(name);
            checkItem.setItemId(item.getId());
            checkItem.setItemPrice(item.getPrice());
        }
        CheckItemService checkItemService = new CheckItemService();
        checkItemService.addCheckItem(checkItem);

        //return Pages.ADD_CHECKITEM_PAGE;
        return "/controller?command=submit_selectedcheck";
    }
}
