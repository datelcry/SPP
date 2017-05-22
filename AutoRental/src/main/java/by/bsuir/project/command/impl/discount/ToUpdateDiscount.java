package by.bsuir.project.command.impl.discount;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Discount;
import by.bsuir.project.model.Service;
import by.bsuir.project.service.impl.DiscountServiceImpl;
import by.bsuir.project.service.impl.ServiceServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ToUpdateDiscount implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_discount");
        int discount_id = Integer.parseInt(request.getParameter("discount_id"));
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        try {
            Discount discount = discountService.getEntityById(discount_id);
            request.setAttribute("discount", discount);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
