package by.bsuir.project.command.impl.brand;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Brand;
import by.bsuir.project.service.impl.BrandServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by User on 14.05.2017.
 */
public class BrandList implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.brands");
        BrandServiceImpl brandService = new BrandServiceImpl();
        try {
            ArrayList<Brand> brands = brandService.getAllEntities();
            request.setAttribute("brands", brands);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
