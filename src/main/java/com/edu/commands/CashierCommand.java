package com.edu.commands;

import com.edu.entities.Check;
import com.edu.services.CheckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.LinkedList;

public class CashierCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        CheckService checkService = new CheckService();
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("user_id");
        boolean isSenior = (boolean) session.getAttribute("isSenior");
        System.out.println("IsSenior: " + isSenior);
        LinkedList<Check> checks;
        if(isSenior){
            checks = checkService.getAllCheks();
        }else{
            checks = checkService.getChecksById(id);
        }
        request.setAttribute("checks", checks);
        return Pages.CHOOSE_CHECK_PAGE;
    }
}
