package by.bsuir.project.command.impl.user;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.User;
import by.bsuir.project.service.impl.UserServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


public class UserList implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.users");
        UserServiceImpl userService = new UserServiceImpl();
        try {
            ArrayList<User> users = userService.getAllEntities();
            request.setAttribute("users", users);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
