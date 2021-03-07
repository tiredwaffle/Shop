package com.edu.commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandHelper {
    private static CommandHelper instance = null;

    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    private CommandHelper() {
        commands.put("catalogue", new CatalogCommand());
        commands.put("login", new LoginCommand());
        commands.put("cashier", new CashierCommand());
        commands.put("add_checkitem", new AddCheckItemCommand());
        commands.put("submit_checkitem", new SubmitCheckItemCommand());
        commands.put("submit_selectedcheck", new SubmitSelectedCheckCommand());
        commands.put("delete_checkitem", new DeleteCheckItemCommand());
        commands.put("delete_check", new DeleteCheckCommand());
        commands.put("create_check", new CreateCheckCommand());
        commands.put("commodity_expert", new CommodityExpertCommand());
        commands.put("submit_item", new SubmitItemCommand());
        commands.put("delete_item", new DeleteItemCommand());
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        System.out.println("command: " + action);
        ICommand command = commands.get(action);
        return command;
    }

    public static CommandHelper getInstance() {

        if (instance == null) {
            instance = new CommandHelper();
        }
        return instance;
    }
}