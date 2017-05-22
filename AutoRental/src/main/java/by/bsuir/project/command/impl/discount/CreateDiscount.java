package by.bsuir.project.command.impl.discount;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Discount;
import by.bsuir.project.model.Service;
import by.bsuir.project.service.impl.DiscountServiceImpl;
import by.bsuir.project.service.impl.ServiceServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * Created by User on 14.05.2017.
 */
public class CreateDiscount implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String discount_name = Charset.change(request.getParameter("discount_name"));
        float discount_value = Float.parseFloat(request.getParameter("discount_value"));
        String page = Configuration.getProperty("path.page.discounts");
        Discount discount = new Discount();
        discount.setDiscount_name(discount_name);
        discount.setDiscount_value(discount_value);
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        try {
            discountService.addEntity(discount);
            request.setAttribute("discounts", discountService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
