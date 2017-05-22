package by.bsuir.project.dao;

import by.bsuir.project.model.Order;
import by.bsuir.project.util.DAO;
import by.bsuir.project.util.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by User on 27.03.2017.
 */
public class OrderDAOImpl extends DAO implements OrderDAO {
    private static final String COLUMN_ORDER_ID = "order_id";
    private static final String COLUMN_ORDER_CLIENT = "order_client";
    private static final String COLUMN_ORDER_CAR = "order_car";
    private static final String COLUMN_ORDER_DATE_BEGIN = "order_date_begin";
    private static final String COLUMN_ORDER_DATE_EXPIR= "order_date_expir";

    private static final String QUERY_ADD_ORDER = "insert into orders (order_client, order_car, order_date_begin, order_date_expir) values (?,?,?,?)";
    private static final String QUERY_DELETE_ORDER = "delete from orders where order_id=?";
    private static final String QUERY_UPDATE_ORDER = "update orders set order_client=?, order_car=?, order_date_begin=?, order_date_expir=? where order_id=?";
    private static final String QUERY_GET_ALL_ORDERS = "select order_id,order_client,order_car,order_date_begin,order_date_expir from orders";
    private static final String QUERY_GET_ORDER= "select order_id,order_client,order_car,order_date_begin,order_date_expir from orders where order_id=?";

    public void addOrder(Order order) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(QUERY_ADD_ORDER);
            preparedStatement.setString(1, String.valueOf(order.getOrder_client()));
            preparedStatement.setString(2, String.valueOf(order.getOrder_car()));
            preparedStatement.setString(3, order.getOrder_date_begin().toString());
            preparedStatement.setString(4, order.getOrder_date_expir().toString());
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

    public void deleteOrder(int order_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(QUERY_DELETE_ORDER);
            preparedStatement.setInt(1, order_id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                closeConnection();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateOrder(Order order) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(QUERY_UPDATE_ORDER);
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

    public List<Order> getAllOrders() throws DAOException {
        List<Order> orders = new ArrayList<Order>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(QUERY_GET_ALL_ORDERS);
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrder_id(resultSet.getInt(COLUMN_ORDER_ID));
                order.setOrder_client(resultSet.getInt(COLUMN_ORDER_CLIENT));
                order.setOrder_car(resultSet.getInt(COLUMN_ORDER_CAR));
                order.setOrder_date_begin(resultSet.getDate(COLUMN_ORDER_DATE_BEGIN));
                order.setOrder_date_expir(resultSet.getDate(COLUMN_ORDER_DATE_EXPIR));
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
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    public Order getOrderById(int order_id) throws DAOException {
        Order order = new Order();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(QUERY_GET_ORDER);
            preparedStatement.setInt(1, order_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order.setOrder_id(resultSet.getInt(COLUMN_ORDER_ID));
                order.setOrder_client(resultSet.getInt(COLUMN_ORDER_CLIENT));
                order.setOrder_car(resultSet.getInt(COLUMN_ORDER_CAR));
                order.setOrder_date_begin(resultSet.getDate(COLUMN_ORDER_DATE_BEGIN));
                order.setOrder_date_expir(resultSet.getDate(COLUMN_ORDER_DATE_EXPIR));
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
