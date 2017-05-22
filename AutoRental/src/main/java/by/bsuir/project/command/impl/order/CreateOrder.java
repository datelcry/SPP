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
public class CreateOrder implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int order_client = Integer.parseInt(request.getParameter("order_client"));
        int order_car = Integer.parseInt(request.getParameter("order_car"));
        Date order_date_begin = Date.valueOf(request.getParameter("order_date_begin"));
        Date order_date_expir = Date.valueOf(request.getParameter("order_date_expir"));
        String page = Configuration.getProperty("path.page.orders");
        Order order = new Order();
        order.setOrder_client(order_client);
        order.setOrder_car(order_car);
        order.setOrder_date_begin(order_date_begin);
        order.setOrder_date_expir(order_date_expir);
        OrderServiceImpl orderService = new OrderServiceImpl();
        try {
            orderService.addEntity(order);
            request.setAttribute("orders", orderService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
