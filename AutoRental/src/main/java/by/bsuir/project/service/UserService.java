package by.bsuir.project.service;

import by.bsuir.project.exception.ServiceException;
import by.bsuir.project.model.User;

/**
 * Created by User on 14.05.2017.
 */
public interface UserService extends Service<User>{
    User findUser(String login, String password) throws ServiceException;
    int getUserIdByLogin(String login) throws ServiceException;
}