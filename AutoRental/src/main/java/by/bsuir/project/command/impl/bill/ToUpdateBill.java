package by.bsuir.project.command.impl.bill;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Bill;
import by.bsuir.project.service.impl.BillServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ToUpdateBill implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_bill");
        int bill_id = Integer.parseInt(request.getParameter("bill_id"));
        BillServiceImpl billService = new BillServiceImpl();
        try {
            Bill bill = billService.getEntityById(bill_id);
            request.setAttribute("bill", bill);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
