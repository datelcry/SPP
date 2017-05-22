package by.bsuir.project.command.impl.order;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Order;
import by.bsuir.project.service.impl.OrderServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by User on 14.05.2017.
 */
public class OrderList implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.orders");
        OrderServiceImpl orderService = new OrderServiceImpl();
        try {
            ArrayList<Order> orders = orderService.getAllEntities();
            request.setAttribute("orders", orders);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
