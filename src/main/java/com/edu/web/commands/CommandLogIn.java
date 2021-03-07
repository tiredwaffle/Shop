package com.edu.web.commands;

import com.edu.entities.Employee;
import com.edu.services.ServiceLogIn;
import com.edu.services.ServiceUser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name="commandLogIn", value="/CommandLogIn")
public class CommandLogIn implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String path = null;
        String surname = request.getParameter("surname");
        ServiceLogIn serviceLogIn = new ServiceLogIn();
        ServiceUser serviceUser = new ServiceUser();
        System.out.println("Here!");
        HttpSession session = request.getSession();
        Boolean statusLogIn = serviceLogIn.logIn(surname);

        if ( statusLogIn ){
            session.setAttribute("login", statusLogIn);
            Employee employee = serviceUser.getUser(surname);
            session.setAttribute("user", employee);
            path = "home.jsp";
        }
        else {
            session.setAttribute("login", statusLogIn);
            path = "index.jsp";
        }
        return path;
    }
}
