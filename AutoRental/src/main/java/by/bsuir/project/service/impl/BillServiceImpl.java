package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.BillDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Bill;
import by.bsuir.project.service.Service;

import java.util.ArrayList;

/**
 * Created by User on 20.05.2017.
 */
public class BillServiceImpl implements Service<Bill> {
    private BillDAOImpl billDAO = new BillDAOImpl();

    @Override
    public ArrayList<Bill> getAllEntities() throws ServiceException {
        try {
            return billDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Bill entity) throws ServiceException {
        try {
            billDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            billDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Bill entity) throws ServiceException {
        try {
            billDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Bill getEntityById(int entity_id) throws ServiceException {
        try {
            return billDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
