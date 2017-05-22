package by.bsuir.project.command.impl.service;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class ToCreateService implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return Configuration.getProperty("path.page.add_service");
    }
}
