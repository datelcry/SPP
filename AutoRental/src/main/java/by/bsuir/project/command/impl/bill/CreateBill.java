package by.bsuir.project.command.impl.bill;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Bill;
import by.bsuir.project.model.Brand;
import by.bsuir.project.service.impl.BillServiceImpl;
import by.bsuir.project.service.impl.BrandServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class CreateBill implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String bill_code = Charset.change(request.getParameter("bill_code"));
        float bill_cost = Float.parseFloat(request.getParameter("bill_cost"));
        int bill_discount = Integer.parseInt(request.getParameter("bill_discount"));
        int bill_order = Integer.parseInt(request.getParameter("bill_order"));
        String page = Configuration.getProperty("path.page.bills");
        Bill bill = new Bill();
        bill.setBill_cost(bill_cost);
        bill.setBill_code(bill_code);
        bill.setBill_discount(bill_discount);
        bill.setBill_order(bill_order);
        BillServiceImpl billService = new BillServiceImpl();
        try {
            billService.addEntity(bill);
            request.setAttribute("bills", billService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
