package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.CarDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Car;
import by.bsuir.project.service.Service;

import java.util.ArrayList;

/**
 * Created by User on 20.05.2017.
 */
public class CarServiceImpl implements Service<Car> {
    private CarDAOImpl carDAO = new CarDAOImpl();

    @Override
    public ArrayList<Car> getAllEntities() throws ServiceException {
        try {
            return carDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Car entity) throws ServiceException {
        try {
            carDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            carDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Car entity) throws ServiceException {
        try {
            carDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Car getEntityById(int entity_id) throws ServiceException {
        try {
            return carDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
