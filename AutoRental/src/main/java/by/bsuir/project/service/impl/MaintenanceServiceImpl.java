package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.MaintenanceDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Maintenance;
import by.bsuir.project.service.Service;

import java.util.ArrayList;

/**
 * Created by User on 20.05.2017.
 */
public class MaintenanceServiceImpl implements Service<Maintenance> {
    private MaintenanceDAOImpl maintenanceDAO = new MaintenanceDAOImpl();

    @Override
    public ArrayList<Maintenance> getAllEntities() throws ServiceException {
        try {
            return maintenanceDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Maintenance entity) throws ServiceException {
        try {
            maintenanceDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            maintenanceDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Maintenance entity) throws ServiceException {
        try {
            maintenanceDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Maintenance getEntityById(int entity_id) throws ServiceException {
        try {
            return maintenanceDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
