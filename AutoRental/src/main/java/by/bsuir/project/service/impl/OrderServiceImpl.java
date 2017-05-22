package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.OrderDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Order;
import by.bsuir.project.service.Service;

import java.util.ArrayList;


public class OrderServiceImpl implements Service<Order>{
    private OrderDAOImpl orderDAO = new OrderDAOImpl();

    @Override
    public ArrayList<Order> getAllEntities() throws ServiceException {
        try {
            return orderDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Order entity) throws ServiceException {
        try {
            orderDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            orderDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Order entity) throws ServiceException {
        try {
            orderDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Order getEntityById(int entity_id) throws ServiceException {
        try {
            return orderDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
