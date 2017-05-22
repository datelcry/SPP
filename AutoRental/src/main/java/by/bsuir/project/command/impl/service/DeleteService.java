package by.bsuir.project.command.impl.service;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.service.impl.OrderServiceImpl;
import by.bsuir.project.service.impl.ServiceServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class DeleteService implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.services");
        ServiceServiceImpl serviceService = new ServiceServiceImpl();
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        try {
            serviceService.deleteEntity(service_id);
            request.setAttribute("services", serviceService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
