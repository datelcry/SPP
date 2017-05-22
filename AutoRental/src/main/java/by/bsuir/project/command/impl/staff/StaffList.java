package by.bsuir.project.command.impl.staff;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Service;
import by.bsuir.project.model.Staff;
import by.bsuir.project.service.impl.ServiceServiceImpl;
import by.bsuir.project.service.impl.StaffServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by User on 14.05.2017.
 */
public class StaffList implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.staff");
        StaffServiceImpl staffService = new StaffServiceImpl();
        try {
            ArrayList<Staff> staff = staffService.getAllEntities();
            request.setAttribute("staff", staff);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
