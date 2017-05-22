package by.bsuir.project.command.impl;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Client;
import by.bsuir.project.model.User;
import by.bsuir.project.service.impl.ClientServiceImpl;
import by.bsuir.project.service.impl.UserServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;
import by.bsuir.project.validation.Validation;

import javax.servlet.http.HttpServletRequest;


public class RegisterCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        UserServiceImpl userService = new UserServiceImpl();
        ClientServiceImpl clientService = new ClientServiceImpl();
        String user_login = Charset.change(request.getParameter("user_login"));
        String user_password = Charset.change(request.getParameter("user_password"));
        String user_email = Charset.change(request.getParameter("user_email"));
        int user_role = 0;
        String client_full_name = Charset.change(request.getParameter("client_full_name"));
        Validation validation = new Validation();
        boolean valid=true;
        if (!validation.isValidLogin(user_login) || user_login.isEmpty())
        {
            request.setAttribute("error_login", "Invalid login!");
            valid=false;
        }
        if (!validation.isValidPassword(user_password) || user_password.isEmpty()){
            request.setAttribute("error_password", "Invalid password!");
            valid=false;
        }
        if (!validation.isValidEmail(user_email) || user_email.isEmpty())
        {
            request.setAttribute("error_email", "Invalid email!");
            valid=false;
        }
        if (valid) {
            try {
                if (userService.getUserIdByLogin(user_login) == -1) {
                    User user = new User();
                    user.setUser_login(user_login);
                    user.setUser_password(user_password);
                    user.setUser_email(user_email);
                    user.setUser_role(user_role);
                    userService.addEntity(user);
                    int user_id = userService.getUserIdByLogin(user_login);
                    Client client = new Client();
                    client.setClient_account(user_id);
                    client.setClient_full_name(client_full_name);
                    clientService.addEntity(client);
                    return Configuration.getProperty("path.page.cars");
                }
                else
                {
                    request.setAttribute("error_message", "This login is exist!");
                    return Configuration.getProperty("path.page.register");
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return Configuration.getProperty("path.page.register");
    }
}
