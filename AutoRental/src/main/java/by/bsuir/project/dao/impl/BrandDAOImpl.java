package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Brand;
import by.bsuir.project.model.Discount;
import by.bsuir.project.util.Configuration;
import by.bsuir.project.util.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by User on 17.05.2017.
 */
public class BrandDAOImpl extends DAO implements CrudDAO<Brand> {
    private static final String ADD_BRAND = "insert into brands (brand_name, brand_tariff, brand_class, brand_number_of_seats, brand_issue_year, brand_engine) values (?,?,?,?,?,?)";
    private static final String DELETE_BRAND= "delete from brands where brand_id=?";
    private static final String UPDATE_BRAND = "update brands set brand_name=?, brand_tariff=?, brand_class=?, brand_number_of_seats=?, brand_issue_year=?, brand_engine=? where brand_id=?";
    private static final String GET_ALL_BRANDS = "select brand_id, brand_name, brand_tariff, brand_class, brand_number_of_seats, brand_issue_year, brand_engine from brands";
    private static final String GET_BRAND= "select brand_id, brand_name, brand_tariff, brand_class, brand_number_of_seats, brand_issue_year, brand_engine from brands where brand_id=?";

    @Override
    public void addEntity(Brand brand) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_BRAND);
            preparedStatement.setString(1, String.valueOf(brand.getBrand_name()));
            preparedStatement.setString(2, String.valueOf(brand.getBrand_tariff()));
            preparedStatement.setString(3, String.valueOf(brand.getBrand_class()));
            preparedStatement.setString(4, String.valueOf(brand.getBrand_numbers_of_seats()));
            preparedStatement.setString(5, String.valueOf(brand.getBrand_issue_year()));
            preparedStatement.setString(6, String.valueOf(brand.getBrand_engine()));
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
    public void deleteEntity(int brand_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_BRAND);
            preparedStatement.setInt(1, brand_id);
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
    public void updateEntity(Brand brand) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_BRAND);
            preparedStatement.setString(1, String.valueOf(brand.getBrand_name()));
            preparedStatement.setString(2, String.valueOf(brand.getBrand_tariff()));
            preparedStatement.setString(3, String.valueOf(brand.getBrand_class()));
            preparedStatement.setString(4, String.valueOf(brand.getBrand_numbers_of_seats()));
            preparedStatement.setString(5, String.valueOf(brand.getBrand_issue_year()));
            preparedStatement.setString(6, String.valueOf(brand.getBrand_engine()));
            preparedStatement.setInt(7, brand.getBrand_id());
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
    public ArrayList<Brand> getAllEntities() throws DAOException {
        ArrayList<Brand> brands = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_BRANDS);
            while (resultSet.next()) {
                Brand brand = new Brand();
                brand.setBrand_id(resultSet.getInt(Configuration.getProperty("COLUMN_BRAND_ID")));
                brand.setBrand_name(resultSet.getString(Configuration.getProperty("COLUMN_BRAND_NAME")));
                brand.setBrand_tariff(resultSet.getFloat(Configuration.getProperty("COLUMN_BRAND_TARIFF")));
                brand.setBrand_class(resultSet.getString(Configuration.getProperty("COLUMN_BRAND_CLASS")));
                brand.setBrand_numbers_of_seats(resultSet.getInt(Configuration.getProperty("COLUMN_BRAND_NUMBER_OF_SEATS")));
                brand.setBrand_issue_year(resultSet.getInt(Configuration.getProperty("COLUMN_BRAND_ISSUE_YEAR")));
                brand.setBrand_engine(resultSet.getString(Configuration.getProperty("COLUMN_BRAND_ENGINE")));
                brands.add(brand);
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
        return brands;
    }

    @Override
    public Brand getEntityById(int brand_id) throws DAOException {
        Brand brand = new Brand();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_BRAND);
            preparedStatement.setInt(1, brand_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                brand.setBrand_id(resultSet.getInt(Configuration.getProperty("COLUMN_BRAND_ID")));
                brand.setBrand_name(resultSet.getString(Configuration.getProperty("COLUMN_BRAND_NAME")));
                brand.setBrand_tariff(resultSet.getFloat(Configuration.getProperty("COLUMN_BRAND_TARIFF")));
                brand.setBrand_class(resultSet.getString(Configuration.getProperty("COLUMN_BRAND_CLASS")));
                brand.setBrand_numbers_of_seats(resultSet.getInt(Configuration.getProperty("COLUMN_BRAND_NUMBER_OF_SEATS")));
                brand.setBrand_issue_year(resultSet.getInt(Configuration.getProperty("COLUMN_BRAND_ISSUE_YEAR")));
                brand.setBrand_engine(resultSet.getString(Configuration.getProperty("COLUMN_BRAND_ENGINE")));
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
        return brand;
    }
}
