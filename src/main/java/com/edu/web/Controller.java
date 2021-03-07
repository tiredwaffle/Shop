package com.edu.web;

import com.edu.web.commands.Helper;
import com.edu.web.commands.ICommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "controllerServlet", value = "/main")
public class Controller extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        ICommand command = Helper.getCommand(request.getParameter("command"));
        String path = command.execute(request, response);
        response.sendRedirect(path);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ICommand command = Helper.getCommand(request.getParameter("command"));
        String path = command.execute(request, response);
        response.sendRedirect(path);
    }
}