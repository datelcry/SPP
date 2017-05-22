package by.bsuir.project.command.impl.car;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Car;
import by.bsuir.project.service.impl.CarServiceImpl;
import by.bsuir.project.util.Charset;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * Created by User on 14.05.2017.
 */
public class CreateCar implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String car_number = Charset.change(request.getParameter("car_number"));
        String car_category = Charset.change(request.getParameter("car_category"));
        int car_brand = Integer.parseInt(request.getParameter("car_brand"));
        int car_staff = Integer.parseInt(request.getParameter("car_staff"));
        int car_available = Integer.parseInt(request.getParameter("car_available"));
        String page = Configuration.getProperty("path.page.cars");
        Car car = new Car();
        car.setCar_number(car_number);
        car.setCar_category(car_category);
        car.setCar_brand(car_brand);
        car.setCar_staff(car_staff);
        car.setCar_available(car_available);
        CarServiceImpl carService = new CarServiceImpl();
        try {
            carService.addEntity(car);
            request.setAttribute("cars", carService.getAllEntities());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
