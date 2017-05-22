package by.bsuir.project.command.impl.service;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Order;
import by.bsuir.project.model.Service;
import by.bsuir.project.service.impl.OrderServiceImpl;
import by.bsuir.project.service.impl.ServiceServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ToUpdateService implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_service");
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        ServiceServiceImpl serviceService = new ServiceServiceImpl();
        try {
            Service service = serviceService.getEntityById(service_id);
            request.setAttribute("service", service);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
