package by.bsuir.project.command.impl.service;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Order;
import by.bsuir.project.model.Service;
import by.bsuir.project.service.impl.OrderServiceImpl;
import by.bsuir.project.service.impl.ServiceServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.sql.Date;

/**
 * Created by User on 14.05.2017.
 */
public class CreateService implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String service_name = Charset.change(request.getParameter("service_name"));
        float service_cost = Float.parseFloat(request.getParameter("service_cost"));
        String page = Configuration.getProperty("path.page.services");
        Service service = new Service();
        service.setService_name(service_name);
        service.setService_cost(service_cost);
        ServiceServiceImpl serviceService = new ServiceServiceImpl();
        try {
            serviceService.addEntity(service);
            request.setAttribute("services", serviceService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
