package com.edu.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AddCheckItemCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        return Pages.ADD_CHECKITEM_PAGE;
    }
}
