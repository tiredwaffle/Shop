package com.edu.servlet;

import com.edu.commands.CommandHelper;
import com.edu.commands.ICommand;
import com.edu.dao.DaoFactory;
import com.edu.dao.ItemDao;
import com.edu.entities.Item;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/controller")
public class Controller extends HttpServlet {
    CommandHelper commandHelper = CommandHelper.getInstance();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String page = null;
        System.out.println("CONTROLLER");
        ICommand command = commandHelper.getCommand(request);
        page = command.execute(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}