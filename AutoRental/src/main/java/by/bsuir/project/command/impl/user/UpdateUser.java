package by.bsuir.project.command.impl.user;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.User;
import by.bsuir.project.service.impl.UserServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;
import by.bsuir.project.validation.Validation;

import javax.servlet.http.HttpServletRequest;


public class UpdateUser implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_user");
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        UserServiceImpl userService = new UserServiceImpl();
        try {
            userService.getEntityById(user_id);
            String user_login = Charset.change(request.getParameter("user_login"));
            String user_password = Charset.change(request.getParameter("user_password"));
            String user_email = Charset.change(request.getParameter("user_email"));
            int user_role = Integer.parseInt(request.getParameter("user_role"));
            Validation validation = new Validation();
            boolean valid = true;
            if (!validation.isValidLogin(user_login) || user_login.isEmpty()) {
                request.setAttribute("error_login", "Invalid login!");
                valid=false;
            }
            if (!validation.isValidPassword(user_password) || user_password.isEmpty()) {
                request.setAttribute("error_password", "Invalid password!");
                valid = false;
            }
            if (!validation.isValidEmail(user_email) || user_email.isEmpty())
            {
                request.setAttribute("error_email", "Invalid email!");
                valid=false;
            };
            if (valid) {
                User user = userService.getEntityById(user_id);
                user.setUser_login(user_login);
                user.setUser_password(user_password);
                user.setUser_email(user_email);
                user.setUser_role(user_role);
                userService.updateEntity(user);
                request.setAttribute("user", user);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
