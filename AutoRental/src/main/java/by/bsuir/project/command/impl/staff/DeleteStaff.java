package by.bsuir.project.command.impl.staff;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.service.impl.ServiceServiceImpl;
import by.bsuir.project.service.impl.StaffServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class DeleteStaff implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.staff");
        StaffServiceImpl staffService = new StaffServiceImpl();
        int staff_id = Integer.parseInt(request.getParameter("staff_id"));
        try {
            staffService.deleteEntity(staff_id);
            request.setAttribute("staff", staffService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
