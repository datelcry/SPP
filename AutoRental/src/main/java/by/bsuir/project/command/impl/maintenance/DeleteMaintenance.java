package by.bsuir.project.command.impl.maintenance;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.service.impl.MaintenanceServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class DeleteMaintenance implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.maintenances");
        MaintenanceServiceImpl maintenanceService = new MaintenanceServiceImpl();
        int maintenance_id = Integer.parseInt(request.getParameter("maintenance_id"));
        try {
            maintenanceService.deleteEntity(maintenance_id);
            request.setAttribute("maintenances", maintenanceService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
