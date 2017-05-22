package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.BrandDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Brand;
import by.bsuir.project.service.Service;

import java.util.ArrayList;

/**
 * Created by User on 17.05.2017.
 */
public class BrandServiceImpl implements Service<Brand> {
    private BrandDAOImpl brandDAO = new BrandDAOImpl();

    @Override
    public ArrayList<Brand> getAllEntities() throws ServiceException {
        try {
            return brandDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Brand entity) throws ServiceException {
        try {
            brandDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            brandDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Brand entity) throws ServiceException {
        try {
            brandDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Brand getEntityById(int entity_id) throws ServiceException {
        try {
            return brandDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
