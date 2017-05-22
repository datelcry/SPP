package by.bsuir.project.command.impl.staff;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Staff;
import by.bsuir.project.service.impl.StaffServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class CreateStaff implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String staff_full_name = Charset.change(request.getParameter("staff_full_name"));
        String staff_post = Charset.change(request.getParameter("staff_post"));
        float staff_salary = Float.parseFloat(request.getParameter("staff_salary"));
        String page = Configuration.getProperty("path.page.staff");
        Staff staff = new Staff();
        staff.setStaff_full_name(staff_full_name);
        staff.setStaff_post(staff_post);
        staff.setStaff_salary(staff_salary);
        StaffServiceImpl staffService = new StaffServiceImpl();
        try {
            staffService.addEntity(staff);
            request.setAttribute("staff", staffService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
