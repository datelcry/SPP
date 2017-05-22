package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Client;
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
public class ClientDAOImpl extends DAO implements CrudDAO<Client> {
    private static final String ADD_CLIENT = "insert into clients (client_full_name, client_number_passport, client_number_license, client_location, client_number_phone, client_account) values (?,?,?,?,?,?)";
    private static final String DELETE_CLIENT= "delete from clients where client_id=?";
    private static final String UPDATE_CLIENT = "update clients set client_full_name=?, client_number_passport=?, client_number_license=?, client_location=?, client_number_phone=?, client_account=? where client_id=?";
    private static final String GET_ALL_CLIENTS = "select client_id, client_full_name, client_number_passport, client_number_license, client_location, client_number_phone, client_account from clients";
    private static final String GET_CLIENT= "select client_id, client_full_name, client_number_passport, client_number_license, client_location, client_number_phone, client_account from clients where client_id=?";

    @Override
    public void addEntity(Client client) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_CLIENT);
            preparedStatement.setString(1, String.valueOf(client.getClient_full_name()));
            preparedStatement.setString(2, String.valueOf(client.getClient_number_passport()));
            preparedStatement.setString(3, String.valueOf(client.getClient_number_license()));
            preparedStatement.setString(4, String.valueOf(client.getClient_location()));
            preparedStatement.setString(5, String.valueOf(client.getClient_number_phone()));
            preparedStatement.setString(6, String.valueOf(client.getClient_account()));
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
    public void deleteEntity(int client_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_CLIENT);
            preparedStatement.setInt(1, client_id);
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
    public void updateEntity(Client client) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_CLIENT);
            preparedStatement.setString(1, String.valueOf(client.getClient_full_name()));
            preparedStatement.setString(2, String.valueOf(client.getClient_number_passport()));
            preparedStatement.setString(3, String.valueOf(client.getClient_number_license()));
            preparedStatement.setString(4, String.valueOf(client.getClient_location()));
            preparedStatement.setString(5, String.valueOf(client.getClient_number_phone()));
            preparedStatement.setString(6, String.valueOf(client.getClient_account()));
            preparedStatement.setInt(7, client.getClient_id());
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
    public ArrayList<Client> getAllEntities() throws DAOException {
        ArrayList<Client> clients = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_CLIENTS);
            while (resultSet.next()) {
                Client client = new Client();
                client.setClient_id(resultSet.getInt(Configuration.getProperty("COLUMN_CLIENT_ID")));
                client.setClient_full_name(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_FULL_NAME")));
                client.setClient_number_passport(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_NUMBER_PASSPORT")));
                client.setClient_number_license(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_NUMBER_LICENSE")));
                client.setClient_location(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_LOCATION")));
                client.setClient_number_phone(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_NUMBER_PHONE")));
                client.setClient_account(resultSet.getInt(Configuration.getProperty("COLUMN_CLIENT_ACCOUNT")));
                clients.add(client);
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
        return clients;
    }

    @Override
    public Client getEntityById(int client_id) throws DAOException {
        Client client = new Client();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_CLIENT);
            preparedStatement.setInt(1, client_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client.setClient_id(resultSet.getInt(Configuration.getProperty("COLUMN_CLIENT_ID")));
                client.setClient_full_name(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_FULL_NAME")));
                client.setClient_number_passport(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_NUMBER_PASSPORT")));
                client.setClient_number_license(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_NUMBER_LICENSE")));
                client.setClient_location(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_LOCATION")));
                client.setClient_number_phone(resultSet.getString(Configuration.getProperty("COLUMN_CLIENT_NUMBER_PHONE")));
                client.setClient_account(resultSet.getInt(Configuration.getProperty("COLUMN_CLIENT_ACCOUNT")));
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
        return client;
    }
}
