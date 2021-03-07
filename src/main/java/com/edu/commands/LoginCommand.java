package com.edu.commands;

import com.edu.services.ServiceLogIn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Locale;

public class LoginCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ServiceLogIn serviceLogIn = new ServiceLogIn();
        if(serviceLogIn.logIn(request.getParameter("surname"))){
            String position = serviceLogIn.getPosition().toLowerCase(Locale.ROOT);
            int user_id = serviceLogIn.getUserId();
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user_id);
            session.setAttribute("isSenior", serviceLogIn.isSenior());
            return Pages.CONTROLLER + "?command=" + position;
        }else{
            return Pages.LOGIN_PAGE;
        }
    }
}
