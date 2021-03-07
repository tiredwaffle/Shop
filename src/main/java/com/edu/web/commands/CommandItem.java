package com.edu.web.commands;

import com.edu.entities.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommandItem implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //ServiceBill serviceBill = new ServiceBill();
        Employee employee = (Employee) request.getSession().getAttribute("user");
        //List<Basket> listBasket = serviceBill.getOrder(user);
        //request.getSession().setAttribute("order", listBasket);
        return "bill.jsp";
    }
}