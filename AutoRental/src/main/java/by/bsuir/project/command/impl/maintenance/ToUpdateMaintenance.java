package by.bsuir.project.command.impl.maintenance;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Maintenance;
import by.bsuir.project.service.impl.MaintenanceServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ToUpdateMaintenance implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_maintenance");
        int maintenance_id = Integer.parseInt(request.getParameter("maintenance_id"));
        MaintenanceServiceImpl maintenanceService = new MaintenanceServiceImpl();
        try {
            Maintenance maintenance = maintenanceService.getEntityById(maintenance_id);
            request.setAttribute("maintenance", maintenance);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
