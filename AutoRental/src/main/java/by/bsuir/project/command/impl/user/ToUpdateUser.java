package by.bsuir.project.command.impl.user;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.User;
import by.bsuir.project.service.impl.UserServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;


public class ToUpdateUser implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_user");
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        UserServiceImpl userService = new UserServiceImpl();
        try {
            User user = userService.getEntityById(user_id);
            request.setAttribute("user", user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}