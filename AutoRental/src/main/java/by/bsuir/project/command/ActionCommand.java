package by.bsuir.project.command;
import by.bsuir.project.exception.ActionException;
import by.bsuir.project.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws ActionException, CommandException;
}
