package by.bsuir.project.command.impl.brand;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Brand;
import by.bsuir.project.service.impl.BrandServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ToUpdateBrand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_brand");
        int brand_id = Integer.parseInt(request.getParameter("brand_id"));
        BrandServiceImpl brandService = new BrandServiceImpl();
        try {
            Brand brand = brandService.getEntityById(brand_id);
            request.setAttribute("brand", brand);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
