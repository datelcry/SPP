package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.DiscountDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Discount;
import by.bsuir.project.service.Service;

import java.util.ArrayList;

/**
 * Created by User on 17.05.2017.
 */
public class DiscountServiceImpl implements Service<Discount>{
    private DiscountDAOImpl discountDAO = new DiscountDAOImpl();

    @Override
    public ArrayList<Discount> getAllEntities() throws ServiceException {
        try {
            return discountDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Discount entity) throws ServiceException {
        try {
            discountDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            discountDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Discount entity) throws ServiceException {
        try {
            discountDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Discount getEntityById(int entity_id) throws ServiceException {
        try {
            return discountDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
