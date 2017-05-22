package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Bill;
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
public class BillDAOImpl extends DAO implements CrudDAO<Bill> {
    private static final String ADD_BILL = "insert into bills (bill_code, bill_cost, bill_discount, bill_order) values (?,?,?,?)";
    private static final String DELETE_BILL= "delete from bills where bill_id=?";
    private static final String UPDATE_BILL = "update bills set bill_code=?, bill_cost=?, bill_discount=?, bill_order=? where bill_id=?";
    private static final String GET_ALL_BILLS = "select bill_id, bill_code, bill_cost, bill_discount, bill_order from bills";
    private static final String GET_BILL= "select bill_id, bill_code, bill_cost, bill_discount, bill_order from bills where bill_id=?";

    @Override
    public void addEntity(Bill bill) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_BILL);
            preparedStatement.setString(1, String.valueOf(bill.getBill_code()));
            preparedStatement.setString(2, String.valueOf(bill.getBill_cost()));
            preparedStatement.setString(3, String.valueOf(bill.getBill_discount()));
            preparedStatement.setString(4, String.valueOf(bill.getBill_order()));
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
    public void deleteEntity(int bill_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_BILL);
            preparedStatement.setInt(1, bill_id);
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
    public void updateEntity(Bill bill) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_BILL);
            preparedStatement.setString(1, String.valueOf(bill.getBill_code()));
            preparedStatement.setString(2, String.valueOf(bill.getBill_cost()));
            preparedStatement.setString(3, String.valueOf(bill.getBill_discount()));
            preparedStatement.setString(4, String.valueOf(bill.getBill_order()));
            preparedStatement.setInt(5, bill.getBill_id());
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
    public ArrayList<Bill> getAllEntities() throws DAOException {
        ArrayList<Bill> bills = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_BILLS);
            while (resultSet.next()) {
                Bill bill = new Bill();
                bill.setBill_id(resultSet.getInt(Configuration.getProperty("COLUMN_BILL_ID")));
                bill.setBill_code(resultSet.getString(Configuration.getProperty("COLUMN_BILL_CODE")));
                bill.setBill_cost(resultSet.getFloat(Configuration.getProperty("COLUMN_BILL_COST")));
                bill.setBill_discount(resultSet.getInt(Configuration.getProperty("COLUMN_BILL_DISCOUNT")));
                bill.setBill_order(resultSet.getInt(Configuration.getProperty("COLUMN_BILL_ORDER")));
                bills.add(bill);
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
        return bills;
    }

    @Override
    public Bill getEntityById(int bill_id) throws DAOException {
        Bill bill = new Bill();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_BILL);
            preparedStatement.setInt(1, bill_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bill.setBill_id(resultSet.getInt(Configuration.getProperty("COLUMN_BILL_ID")));
                bill.setBill_code(resultSet.getString(Configuration.getProperty("COLUMN_BILL_CODE")));
                bill.setBill_cost(resultSet.getFloat(Configuration.getProperty("COLUMN_BILL_COST")));
                bill.setBill_discount(resultSet.getInt(Configuration.getProperty("COLUMN_BILL_DISCOUNT")));
                bill.setBill_order(resultSet.getInt(Configuration.getProperty("COLUMN_BILL_ORDER")));
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
        return bill;
    }
}
