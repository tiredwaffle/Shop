package com.edu.web.commands;

import java.util.HashMap;

public class Helper {
    private static HashMap<String, ICommand> commands = null;
    // параметри для command. command передається через запит
    static {
        commands = new HashMap<>();
        /*commands.put("login", new CommandLogIn());
        commands.put("registration", new CommandRegistration());
        commands.put("basket", new CommandBasket());
        commands.put("bill", new CommandBill());
        commands.put("order", new CommandOrder());
        commands.put("confirm", new CommandConfirm());
        commands.put("pay", new CommandPay());
        commands.put("cook", new CommandCook());
        commands.put("ordercook", new CommandGetByCook());
        commands.put("logout", new CommandLogOut());*/
    }

    private Helper(){
    }

    public static ICommand getCommand(String key){
        return commands.get(key);
    }
}
