package com.edu.commands;

import com.edu.services.CheckService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class DeleteCheckCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        CheckService checkService = new CheckService();
        HttpSession session = request.getSession();
        int check_id = (int) session.getAttribute("check_id");
        checkService.cancelCheck(check_id);
        return "/controller?command=submit_selectedcheck";
    }
}
