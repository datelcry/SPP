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
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;

public class UpdateService implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.services");
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        ServiceServiceImpl serviceService = new ServiceServiceImpl();
        try {
            request.setCharacterEncoding("UTF-8");
            serviceService.getEntityById(service_id);
            Service service = serviceService.getEntityById(service_id);
            String service_name = Charset.change(request.getParameter("service_name"));
            service.setService_name(service_name);
            float service_cost = Float.parseFloat(request.getParameter("service_cost"));
            service.setService_cost(service_cost);
            serviceService.updateEntity(service);
            request.setAttribute("services", serviceService.getAllEntities());
        } catch (ServiceException| UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return page;
    }
}
