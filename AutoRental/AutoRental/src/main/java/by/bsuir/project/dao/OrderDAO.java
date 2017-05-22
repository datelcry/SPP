package by.bsuir.project.dao;

import by.bsuir.project.model.Order;
import by.bsuir.project.util.DAOException;

import java.util.List;

/**
 * Created by User on 27.03.2017.
 */
public interface OrderDAO {

    void addOrder(Order order) throws DAOException;

    void deleteOrder(int order_id) throws DAOException;

    void updateOrder(Order order) throws DAOException;

    List<Order> getAllOrders() throws DAOException;

    Order getOrderById(int order_id) throws DAOException;
}
