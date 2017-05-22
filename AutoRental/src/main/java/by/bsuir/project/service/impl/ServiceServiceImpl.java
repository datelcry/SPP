package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.ServiceDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.service.Service;
import java.util.ArrayList;

/**
 * Created by User on 16.05.2017.
 */
public class ServiceServiceImpl implements Service<by.bsuir.project.model.Service> {
    private ServiceDAOImpl serviceDAO = new ServiceDAOImpl();

    @Override
    public ArrayList<by.bsuir.project.model.Service> getAllEntities() throws ServiceException {
        try {
            return serviceDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(by.bsuir.project.model.Service entity) throws ServiceException {
        try {
            serviceDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            serviceDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(by.bsuir.project.model.Service entity) throws ServiceException {
        try {
            serviceDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public by.bsuir.project.model.Service getEntityById(int entity_id) throws ServiceException {
        try {
            return serviceDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
