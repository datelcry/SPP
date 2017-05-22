package by.bsuir.project.service;

import by.bsuir.project.exception.ServiceException;

import java.util.ArrayList;

/**
 * Created by User on 14.05.2017.
 */
public interface Service<T> {
    ArrayList<T> getAllEntities() throws ServiceException;

    void addEntity(T entity) throws ServiceException;

    boolean deleteEntity(int entity_id) throws ServiceException;

    boolean updateEntity(T entity) throws ServiceException;

    T getEntityById(int entity_id) throws ServiceException;
}
