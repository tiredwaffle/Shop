package com.edu.commands;

import com.edu.entities.Check;
import com.edu.services.CheckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CreateCheckCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        Check check = new Check();
        check.setCreatedBy((int) session.getAttribute("user_id"));
        check.setAmount(0);
        check.setActive(true);
        CheckService checkService = new CheckService();
        checkService.createCheck(check);
        return Pages.CONTROLLER + "?command=cashier";
    }
}
