package by.bsuir.project.command.impl.order;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Order;
import by.bsuir.project.service.impl.OrderServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ToUpdateOrder implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_order");
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        OrderServiceImpl orderService = new OrderServiceImpl();
        try {
            Order order = orderService.getEntityById(order_id);
            request.setAttribute("order", order);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
