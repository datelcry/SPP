package by.bsuir.project.command.impl.brand;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.service.impl.BrandServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.05.2017.
 */
public class DeleteBrand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.brands");
        BrandServiceImpl brandService = new BrandServiceImpl();
        int brand_id = Integer.parseInt(request.getParameter("brand_id"));
        try {
            brandService.deleteEntity(brand_id);
            request.setAttribute("brands", brandService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
