package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.ClientDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.Client;
import by.bsuir.project.model.Client;
import by.bsuir.project.service.Service;

import java.util.ArrayList;

/**
 * Created by User on 20.05.2017.
 */
public class ClientServiceImpl implements Service<Client> {
    private ClientDAOImpl clientDAO = new ClientDAOImpl();

    @Override
    public ArrayList<Client> getAllEntities() throws ServiceException {
        try {
            return clientDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Client entity) throws ServiceException {
        try {
            clientDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            clientDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Client entity) throws ServiceException {
        try {
            clientDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Client getEntityById(int entity_id) throws ServiceException {
        try {
            return clientDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
