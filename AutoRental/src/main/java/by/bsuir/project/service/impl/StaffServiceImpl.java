package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.ServiceDAOImpl;
import by.bsuir.project.dao.impl.StaffDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Staff;
import by.bsuir.project.service.Service;

import java.util.ArrayList;

/**
 * Created by User on 20.05.2017.
 */
public class StaffServiceImpl implements Service<Staff> {
    private StaffDAOImpl staffDAO = new StaffDAOImpl();
    @Override
    public ArrayList<Staff> getAllEntities() throws ServiceException {
        try {
            return staffDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Staff entity) throws ServiceException {
        try {
            staffDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            staffDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Staff entity) throws ServiceException {
        try {
            staffDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Staff getEntityById(int entity_id) throws ServiceException {
        try {
            return staffDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
