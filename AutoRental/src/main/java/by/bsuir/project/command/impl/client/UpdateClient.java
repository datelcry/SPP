package by.bsuir.project.command.impl.client;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Client;
import by.bsuir.project.service.impl.ClientServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class UpdateClient implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.clients");
        int client_id = Integer.parseInt(request.getParameter("client_id"));
        ClientServiceImpl clientService = new ClientServiceImpl();
        try {
            clientService.getEntityById(client_id);
            Client client = clientService.getEntityById(client_id);
            String client_full_name = Charset.change(request.getParameter("client_full_name"));
            String client_number_passport = Charset.change(request.getParameter("client_number_passport"));
            String client_number_license = Charset.change(request.getParameter("client_number_license"));
            String client_location = Charset.change(request.getParameter("client_location"));
            String client_number_phone = Charset.change(request.getParameter("client_number_phone"));
            int client_account = Integer.parseInt(request.getParameter("client_account"));
            client.setClient_full_name(client_full_name);
            client.setClient_number_passport(client_number_passport);
            client.setClient_number_license(client_number_license);
            client.setClient_location(client_location);
            client.setClient_number_phone(client_number_phone);
            client.setClient_account(client_account);
            clientService.updateEntity(client);
            request.setAttribute("clients", clientService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
