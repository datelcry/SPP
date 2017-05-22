package by.bsuir.project.command.impl.brand;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Brand;
import by.bsuir.project.model.Discount;
import by.bsuir.project.service.impl.BrandServiceImpl;
import by.bsuir.project.service.impl.DiscountServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * Created by User on 14.05.2017.
 */
public class CreateBrand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String brand_name = Charset.change(request.getParameter("brand_name"));
        String brand_class = Charset.change(request.getParameter("brand_class"));
        String brand_engine = Charset.change(request.getParameter("brand_engine"));
        float brand_tariff = Float.parseFloat(request.getParameter("brand_tariff"));
        int brand_numbers_of_seats = Integer.parseInt(request.getParameter("brand_numbers_of_seats"));
        int brand_issue_year = Integer.parseInt(request.getParameter("brand_issue_year"));
        String page = Configuration.getProperty("path.page.brands");
        Brand brand = new Brand();
        brand.setBrand_name(brand_name);
        brand.setBrand_tariff(brand_tariff);
        brand.setBrand_class(brand_class);
        brand.setBrand_numbers_of_seats(brand_numbers_of_seats);
        brand.setBrand_issue_year(brand_issue_year);
        brand.setBrand_engine(brand_engine);
        BrandServiceImpl brandService = new BrandServiceImpl();
        try {
            brandService.addEntity(brand);
            request.setAttribute("brands", brandService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
