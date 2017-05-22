package by.bsuir.project.command.impl.car;

import by.bsuir.project.command.ActionCommand;
import by.bsuir.project.exception.CommandException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Car;
import by.bsuir.project.service.impl.CarServiceImpl;
import by.bsuir.project.util.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ToUpdateCar implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = Configuration.getProperty("path.page.edit_car");
        int car_id = Integer.parseInt(request.getParameter("car_id"));
        CarServiceImpl carService = new CarServiceImpl();
        try {
            Car car = carService.getEntityById(car_id);
            request.setAttribute("car", car);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
