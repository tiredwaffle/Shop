package com.edu.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandLogOut implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // вихід, але думаю, що не працює так, як треба
        request.getSession().setAttribute("login", Boolean.FALSE);
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("basket", null);
        request.getSession().setAttribute("order", null);
        return "index.jsp";
    }
}
