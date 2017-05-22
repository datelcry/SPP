package by.bsuir.project.command.impl.order;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Order;
import by.bsuir.project.service.impl.OrderServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by User on 14.05.2017.
 */
public class UpdateOrder implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.orders");
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        OrderServiceImpl orderService = new OrderServiceImpl();
        try {
            Order order = orderService.getEntityById(order_id);
            order.setOrder_client(Integer.parseInt(request.getParameter("order_client")));
            order.setOrder_car(Integer.parseInt(request.getParameter("order_car")));
            order.setOrder_date_begin(Date.valueOf(request.getParameter("order_date_begin")));
            order.setOrder_date_expir(Date.valueOf(request.getParameter("order_date_expir")));
            orderService.updateEntity(order);
            request.setAttribute("orders", orderService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
