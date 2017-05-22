package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Order;
import by.bsuir.project.model.Service;
import by.bsuir.project.util.Configuration;
import by.bsuir.project.util.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by User on 16.05.2017.
 */
public class ServiceDAOImpl extends DAO implements CrudDAO<Service> {
    private static final String ADD_SERVICE = "insert into services (service_name, service_cost) values (?,?)";
    private static final String DELETE_SERVICE = "delete from services where service_id=?";
    private static final String UPDATE_SERVICE = "update services set service_name=?, service_cost=? where service_id=?";
    private static final String GET_ALL_SERVICES = "select service_id, service_name, service_cost from services";
    private static final String GET_SERVICE= "select service_id, service_name, service_cost from services where service_id=?";

    @Override
    public void addEntity(Service service) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_SERVICE);
            preparedStatement.setString(1, String.valueOf(service.getService_name()));
            preparedStatement.setString(2, String.valueOf(service.getService_cost()));
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
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteEntity(int service_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_SERVICE);
            preparedStatement.setInt(1, service_id);
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
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateEntity(Service service) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_SERVICE);
            preparedStatement.setString(1, String.valueOf(service.getService_name()));
            preparedStatement.setString(2, String.valueOf(service.getService_cost()));
            preparedStatement.setInt(3, service.getService_id());
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
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Service> getAllEntities() throws DAOException {
        ArrayList<Service> services = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_SERVICES);
            while (resultSet.next()) {
                Service service = new Service();
                service.setService_id(resultSet.getInt(Configuration.getProperty("COLUMN_SERVICE_ID")));
                service.setService_name(resultSet.getString(Configuration.getProperty("COLUMN_SERVICE_NAME")));
                service.setService_cost(resultSet.getFloat(Configuration.getProperty("COLUMN_SERVICE_COST")));
                services.add(service);
            }
        }
        catch (SQLException e) {
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
        return services;
    }

    @Override
    public Service getEntityById(int service_id) throws DAOException {
        Service service = new Service();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_SERVICE);
            preparedStatement.setInt(1, service_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                service.setService_id(resultSet.getInt(Configuration.getProperty("COLUMN_SERVICE_ID")));
                service.setService_name(resultSet.getString(Configuration.getProperty("COLUMN_SERVICE_NAME")));
                service.setService_cost(resultSet.getFloat(Configuration.getProperty("COLUMN_SERVICE_COST")));
            }
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                closeConnection();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return service;
    }
}
