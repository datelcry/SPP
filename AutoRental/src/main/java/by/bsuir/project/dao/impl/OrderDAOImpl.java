package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Order;
import by.bsuir.project.util.Configuration;
import by.bsuir.project.util.DAO;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrderDAOImpl extends DAO implements CrudDAO<Order> {
    private static final String ADD_ORDER = "insert into orders (order_client, order_car, order_date_begin, order_date_expir) values (?,?,?,?)";
    private static final String DELETE_ORDER = "delete from orders where order_id=?";
    private static final String UPDATE_ORDER = "update orders set order_client=?, order_car=?, order_date_begin=?, order_date_expir=? where order_id=?";
    private static final String GET_ALL_ORDERS = "select order_id,order_client,order_car,order_date_begin,order_date_expir from orders";
    private static final String GET_ORDER= "select order_id,order_client,order_car,order_date_begin,order_date_expir from orders where order_id=?";

    @Override
    public void addEntity(Order order) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_ORDER);
            preparedStatement.setString(1, String.valueOf(order.getOrder_client()));
            preparedStatement.setString(2, String.valueOf(order.getOrder_car()));
            preparedStatement.setString(3, order.getOrder_date_begin().toString());
            preparedStatement.setString(4, order.getOrder_date_expir().toString());
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
    public void deleteEntity(int order_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_ORDER);
            preparedStatement.setInt(1, order_id);
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
    public void updateEntity(Order order) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_ORDER);
            preparedStatement.setString(1, String.valueOf(order.getOrder_client()));
            preparedStatement.setString(2, String.valueOf(order.getOrder_car()));
            preparedStatement.setString(3, order.getOrder_date_begin().toString());
            preparedStatement.setString(4, order.getOrder_date_expir().toString());
            preparedStatement.setInt(5, order.getOrder_id());
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
    public ArrayList<Order> getAllEntities() throws DAOException {
        ArrayList<Order> orders = new ArrayList<Order>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_ORDERS);
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrder_id(resultSet.getInt(Configuration.getProperty("COLUMN_ORDER_ID")));
                order.setOrder_client(resultSet.getInt(Configuration.getProperty("COLUMN_ORDER_CLIENT")));
                order.setOrder_car(resultSet.getInt(Configuration.getProperty("COLUMN_ORDER_CAR")));
                order.setOrder_date_begin(resultSet.getDate(Configuration.getProperty("COLUMN_ORDER_DATE_BEGIN")));
                order.setOrder_date_expir(resultSet.getDate(Configuration.getProperty("COLUMN_ORDER_DATE_EXPIR")));
                orders.add(order);
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
        return orders;
    }

    @Override
    public Order getEntityById(int order_id) throws DAOException {
        Order order = new Order();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_ORDER);
            preparedStatement.setInt(1, order_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order.setOrder_id(resultSet.getInt(Configuration.getProperty("COLUMN_ORDER_ID")));
                order.setOrder_client(resultSet.getInt(Configuration.getProperty("COLUMN_ORDER_CLIENT")));
                order.setOrder_car(resultSet.getInt(Configuration.getProperty("COLUMN_ORDER_CAR")));
                order.setOrder_date_begin(resultSet.getDate(Configuration.getProperty("COLUMN_ORDER_DATE_BEGIN")));
                order.setOrder_date_expir(resultSet.getDate(Configuration.getProperty("COLUMN_ORDER_DATE_EXPIR")));
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
        return order;
    }
}
