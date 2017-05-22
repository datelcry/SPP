package by.bsuir.project.command.impl.client;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Client;
import by.bsuir.project.service.impl.ClientServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ToUpdateClient implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_client");
        int client_id = Integer.parseInt(request.getParameter("client_id"));
        ClientServiceImpl clientService = new ClientServiceImpl();
        try {
            Client client = clientService.getEntityById(client_id);
            request.setAttribute("client", client);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
