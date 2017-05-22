package by.bsuir.project.dao;

import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.User;

import java.io.Serializable;

/**
 * Created by User on 14.05.2017.
 */
public interface UserDAO extends CrudDAO<User>, Serializable {
    User findUser(String login, String password);
    int getUserIdByLogin(String login);
}
