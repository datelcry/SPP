package by.bsuir.project.command.impl.maintenance;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Maintenance;
import by.bsuir.project.service.impl.MaintenanceServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by User on 14.05.2017.
 */
public class MaintenanceList implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.maintenances");
        MaintenanceServiceImpl maintenanceService = new MaintenanceServiceImpl();
        try {
            ArrayList<Maintenance> maintenances = maintenanceService.getAllEntities();
            request.setAttribute("maintenances", maintenances);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
