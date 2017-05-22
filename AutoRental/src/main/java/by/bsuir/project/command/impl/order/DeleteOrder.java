package by.bsuir.project.command.impl.order;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.service.impl.OrderServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class DeleteOrder implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.orders");
        OrderServiceImpl orderService = new OrderServiceImpl();
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        try {
            orderService.deleteEntity(order_id);
            request.setAttribute("orders", orderService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
