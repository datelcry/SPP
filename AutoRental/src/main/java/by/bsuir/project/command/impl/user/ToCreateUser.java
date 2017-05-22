package by.bsuir.project.command.impl.user;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;


public class ToCreateUser implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return Configuration.getProperty("path.page.add_user");
    }
}

