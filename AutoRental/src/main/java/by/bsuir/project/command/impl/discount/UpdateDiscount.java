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
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class UpdateDiscount implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.discounts");
        int discount_id = Integer.parseInt(request.getParameter("discount_id"));
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        try {
            discountService.getEntityById(discount_id);
            Discount discount = discountService.getEntityById(discount_id);
            String discount_name = Charset.change(request.getParameter("discount_name"));
            float discount_value = Float.parseFloat(request.getParameter("discount_value"));
            discount.setDiscount_name(discount_name);
            discount.setDiscount_value(discount_value);
            discountService.updateEntity(discount);
            request.setAttribute("discounts", discountService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
