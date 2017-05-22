package by.bsuir.project.command.factory;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.command.CommandEnum;
import by.bsuir.project.command.impl.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand command = new EmptyCommand();

        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return command;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
            command = commandEnum.getCommand();

        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action);
        }
        return command;
    }
}
