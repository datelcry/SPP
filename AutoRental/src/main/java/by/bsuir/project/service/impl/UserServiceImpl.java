package by.bsuir.project.service.impl;

import by.bsuir.project.dao.impl.UserDAOImpl;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.User;
import by.bsuir.project.model.User;
import by.bsuir.project.service.Service;
import by.bsuir.project.service.UserService;

import java.util.ArrayList;

/**
 * Created by User on 20.05.2017.
 */
public class UserServiceImpl implements UserService{
    private UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public ArrayList<User> getAllEntities() throws ServiceException {
        try {
            return userDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(User entity) throws ServiceException {
        try {
            userDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            userDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(User entity) throws ServiceException {
        try {
            userDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public User getEntityById(int entity_id) throws ServiceException {
        try {
            return userDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findUser(String login, String password) throws ServiceException {
        try {
            return userDAO.findUser(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getUserIdByLogin(String login) throws ServiceException {
        try {
            return userDAO.getUserIdByLogin(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
