package by.bsuir.project.command.impl.bill;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Bill;
import by.bsuir.project.service.impl.BillServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by User on 14.05.2017.
 */
public class BillList implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.bills");
        BillServiceImpl billService = new BillServiceImpl();
        try {
            ArrayList<Bill> bills = billService.getAllEntities();
            request.setAttribute("bills", bills);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
