package com.edu.commands;

import com.edu.dao.CheckItemDao;
import com.edu.entities.Check;
import com.edu.entities.CheckItem;
import com.edu.services.CheckItemService;
import com.edu.services.CheckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.LinkedList;

public class SubmitSelectedCheckCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        int check_id = 1;
        if(request.getParameter("check_id") == null){
            check_id = (int) session.getAttribute("check_id");
        }else{
            check_id = Integer.parseInt(request.getParameter("check_id"));
        }
        session.setAttribute("check_id", check_id);
        CheckService checkService = new CheckService();
        Check check = checkService.getCheck(check_id);
        boolean isActive = check.getActive();
        request.setAttribute("isActive", isActive);

        CheckItemService checkItemService = new CheckItemService();
        LinkedList<CheckItem> items = checkItemService.getCheckItemsByCheckId(check_id);
        request.setAttribute("list_items", items);
        request.setAttribute("check_id", check_id);
        request.setAttribute("isSenior", session.getAttribute("isSenior"));

        return "/controller?command=add_checkitem";
    }
}
