package by.bsuir.project.command.impl.bill;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Bill;
import by.bsuir.project.service.impl.BillServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class UpdateBill implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.bills");
        int bill_id = Integer.parseInt(request.getParameter("bill_id"));
        BillServiceImpl billService = new BillServiceImpl();
        try {
            billService.getEntityById(bill_id);
            Bill bill = billService.getEntityById(bill_id);
            String bill_code = Charset.change(request.getParameter("bill_code"));
            float bill_cost = Float.parseFloat(request.getParameter("bill_cost"));
            int bill_discount = Integer.parseInt(request.getParameter("bill_discount"));
            int bill_order = Integer.parseInt(request.getParameter("bill_order"));
            bill.setBill_cost(bill_cost);
            bill.setBill_code(bill_code);
            bill.setBill_discount(bill_discount);
            bill.setBill_order(bill_order);
            billService.updateEntity(bill);
            request.setAttribute("bills", billService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
