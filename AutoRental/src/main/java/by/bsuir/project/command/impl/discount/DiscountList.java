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
import java.util.ArrayList;

/**
 * Created by User on 14.05.2017.
 */
public class DiscountList implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.discounts");
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        try {
            ArrayList<Discount> discounts = discountService.getAllEntities();
            request.setAttribute("discounts", discounts);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
