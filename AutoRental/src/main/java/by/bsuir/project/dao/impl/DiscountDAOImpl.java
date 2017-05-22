package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Discount;
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
public class DiscountDAOImpl extends DAO implements CrudDAO<Discount> {
    private static final String ADD_DISCOUNT = "insert into discounts (discount_name, discount_value) values (?,?)";
    private static final String DELETE_DISCOUNT= "delete from discounts where discount_id=?";
    private static final String UPDATE_DISCOUNT = "update discounts set discount_name=?, discount_value=? where discount_id=?";
    private static final String GET_ALL_DISCOUNTS = "select discount_id, discount_name, discount_value from discounts";
    private static final String GET_DISCOUNT= "select discount_id, discount_name, discount_value from discounts where discount_id=?";

    @Override
    public void addEntity(Discount discount) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_DISCOUNT);
            preparedStatement.setString(1, String.valueOf(discount.getDiscount_name()));
            preparedStatement.setString(2, String.valueOf(discount.getDiscount_value()));
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
    public void deleteEntity(int discount_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_DISCOUNT);
            preparedStatement.setInt(1, discount_id);
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
    public void updateEntity(Discount discount) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_DISCOUNT);
            preparedStatement.setString(1, String.valueOf(discount.getDiscount_name()));
            preparedStatement.setString(2, String.valueOf(discount.getDiscount_value()));
            preparedStatement.setInt(3, discount.getDiscount_id());
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
    public ArrayList<Discount> getAllEntities() throws DAOException {
        ArrayList<Discount> discounts = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_DISCOUNTS);
            while (resultSet.next()) {
                Discount discount = new Discount();
                discount.setDiscount_id(resultSet.getInt(Configuration.getProperty("COLUMN_DISCOUNT_ID")));
                discount.setDiscount_name(resultSet.getString(Configuration.getProperty("COLUMN_DISCOUNT_NAME")));
                discount.setDiscount_value(resultSet.getFloat(Configuration.getProperty("COLUMN_DISCOUNT_VALUE")));
                discounts.add(discount);
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
        return discounts;
    }

    @Override
    public Discount getEntityById(int discount_id) throws DAOException {
        Discount discount = new Discount();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_DISCOUNT);
            preparedStatement.setInt(1, discount_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                discount.setDiscount_id(resultSet.getInt(Configuration.getProperty("COLUMN_DISCOUNT_ID")));
                discount.setDiscount_name(resultSet.getString(Configuration.getProperty("COLUMN_DISCOUNT_NAME")));
                discount.setDiscount_value(resultSet.getFloat(Configuration.getProperty("COLUMN_DISCOUNT_VALUE")));
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
        return discount;
    }
}
