package by.bsuir.project.command.impl;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.User;
import by.bsuir.project.service.impl.UserServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by User on 20.05.2017.
 */
public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.index");
        UserServiceImpl userService = new UserServiceImpl();
        String user_login = Charset.change(request.getParameter("user_login"));
        String user_password = Charset.change(request.getParameter("user_password"));
        if (!user_login.isEmpty() && !user_password.isEmpty()) {
            try {
                User user = userService.findUser(user_login, user_password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user_login", user.getUser_login());
                    session.setAttribute("user_role", user.getUser_role());
                } else{
                    request.setAttribute("error", "Check your login or password!");
                    page = Configuration.getProperty("path.page.login");
                }
                return page;
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        else {
            request.setAttribute("error", "Input your login or password!");
            page = Configuration.getProperty("path.page.login");
            return page;
        }
        return page;
    }
}
