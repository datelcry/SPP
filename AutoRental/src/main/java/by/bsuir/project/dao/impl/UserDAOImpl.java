package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.UserDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.User;
import by.bsuir.project.util.Configuration;
import by.bsuir.project.util.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by User on 20.05.2017.
 */
public class UserDAOImpl extends DAO implements UserDAO {
    private final String ADD_USER = "insert into users (user_login, user_password, user_email, user_role) values (?,?,?,?)";
    private final String DELETE_USER = "delete from users where user_id=?";
    private final String UPDATE_USER = "update users set user_login=?, user_password=?, user_email=?, user_role=? where user_id=?";
    private final String GET_ALL_USERS = "select user_id, user_login, user_password, user_email, user_role from users";
    private final String GET_USER = "select user_id, user_login, user_password, user_email, user_role from users where user_id=?";
    private final String GET_USER_ID_BY_LOGIN = "select user_id from users where user_login=?";
    private final String AUTHENTICATION = "select user_id, user_login, user_password, user_email, user_role from users where user_login = ? and user_password =?";

    @Override
    public void addEntity(User user) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_USER);
            preparedStatement.setString(1, user.getUser_login());
            preparedStatement.setString(2, user.getUser_password());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, String.valueOf(user.getUser_role()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                closeConnection();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteEntity(int user_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, user_id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateEntity(User user) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getUser_login());
            preparedStatement.setString(2, user.getUser_password());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, String.valueOf(user.getUser_role()));
            preparedStatement.setInt(5, user.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<User> getAllEntities() throws DAOException {
        ArrayList<User> users = new ArrayList<User>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getInt(Configuration.getProperty("COLUMN_USER_ID")));
                user.setUser_login(resultSet.getString(Configuration.getProperty("COLUMN_USER_LOGIN")));
                user.setUser_password(resultSet.getString(Configuration.getProperty("COLUMN_USER_PASSWORD")));
                user.setUser_email(resultSet.getString(Configuration.getProperty("COLUMN_USER_EMAIL")));
                user.setUser_role(resultSet.getInt(Configuration.getProperty("COLUMN_USER_ROLE")));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return users;
    }

    @Override
    public User getEntityById(int user_id) throws DAOException {
        User user = new User();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_USER);
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setUser_id(resultSet.getInt(Configuration.getProperty("COLUMN_USER_ID")));
                user.setUser_login(resultSet.getString(Configuration.getProperty("COLUMN_USER_LOGIN")));
                user.setUser_password(resultSet.getString(Configuration.getProperty("COLUMN_USER_PASSWORD")));
                user.setUser_email(resultSet.getString(Configuration.getProperty("COLUMN_USER_EMAIL")));
                user.setUser_role(resultSet.getInt(Configuration.getProperty("COLUMN_USER_ROLE")));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public User findUser(String login, String password) {
        User user = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(AUTHENTICATION);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUser_id(resultSet.getInt(Configuration.getProperty("COLUMN_USER_ID")));
                user.setUser_login(resultSet.getString(Configuration.getProperty("COLUMN_USER_LOGIN")));
                user.setUser_password(resultSet.getString(Configuration.getProperty("COLUMN_USER_PASSWORD")));
                user.setUser_email(resultSet.getString(Configuration.getProperty("COLUMN_USER_EMAIL")));
                user.setUser_role(resultSet.getInt(Configuration.getProperty("COLUMN_USER_ROLE")));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public int getUserIdByLogin(String login) {
        int user_id = -1;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_USER_ID_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user_id = resultSet.getInt(Configuration.getProperty("COLUMN_USER_ID"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user_id;
    }
}
