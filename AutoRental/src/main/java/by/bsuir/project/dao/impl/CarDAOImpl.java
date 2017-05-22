package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Car;
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
public class CarDAOImpl extends DAO implements CrudDAO<Car> {
    private static final String ADD_CAR = "insert into cars (car_number, car_category, car_brand, car_staff, car_available) values (?,?,?,?,?)";
    private static final String DELETE_CAR= "delete from cars where car_id=?";
    private static final String UPDATE_CAR = "update cars set car_number=?, car_category=?, car_brand=?, car_staff=?, car_available=? where car_id=?";
    private static final String GET_ALL_CARS = "select car_id, car_number, car_category, car_brand, car_staff, car_available from cars";
    private static final String GET_CAR= "select car_id, car_number, car_category, car_brand, car_staff, car_available from cars where car_id=?";

    @Override
    public void addEntity(Car car) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_CAR);
            preparedStatement.setString(1, String.valueOf(car.getCar_number()));
            preparedStatement.setString(2, String.valueOf(car.getCar_category()));
            preparedStatement.setString(3, String.valueOf(car.getCar_brand()));
            preparedStatement.setString(4, String.valueOf(car.getCar_staff()));
            preparedStatement.setString(5, String.valueOf(car.getCar_available()));
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
    public void deleteEntity(int car_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_CAR);
            preparedStatement.setInt(1, car_id);
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
    public void updateEntity(Car car) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_CAR);
            preparedStatement.setString(1, String.valueOf(car.getCar_number()));
            preparedStatement.setString(2, String.valueOf(car.getCar_category()));
            preparedStatement.setString(3, String.valueOf(car.getCar_brand()));
            preparedStatement.setString(4, String.valueOf(car.getCar_staff()));
            preparedStatement.setString(5, String.valueOf(car.getCar_available()));
            preparedStatement.setInt(6, car.getCar_id());
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
    public ArrayList<Car> getAllEntities() throws DAOException {
        ArrayList<Car> cars = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_CARS);
            while (resultSet.next()) {
                Car car = new Car();
                car.setCar_id(resultSet.getInt(Configuration.getProperty("COLUMN_CAR_ID")));
                car.setCar_number(resultSet.getString(Configuration.getProperty("COLUMN_CAR_NUMBER")));
                car.setCar_category(resultSet.getString(Configuration.getProperty("COLUMN_CAR_CATEGORY")));
                car.setCar_brand(resultSet.getInt(Configuration.getProperty("COLUMN_CAR_BRAND")));
                car.setCar_staff(resultSet.getInt(Configuration.getProperty("COLUMN_CAR_STAFF")));
                car.setCar_available(resultSet.getInt(Configuration.getProperty("COLUMN_CAR_AVAILABLE")));
                cars.add(car);
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
        return cars;
    }

    @Override
    public Car getEntityById(int car_id) throws DAOException {
        Car car = new Car();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_CAR);
            preparedStatement.setInt(1, car_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car.setCar_id(resultSet.getInt(Configuration.getProperty("COLUMN_CAR_ID")));
                car.setCar_number(resultSet.getString(Configuration.getProperty("COLUMN_CAR_NUMBER")));
                car.setCar_category(resultSet.getString(Configuration.getProperty("COLUMN_CAR_CATEGORY")));
                car.setCar_brand(resultSet.getInt(Configuration.getProperty("COLUMN_CAR_BRAND")));
                car.setCar_staff(resultSet.getInt(Configuration.getProperty("COLUMN_CAR_STAFF")));
                car.setCar_available(resultSet.getInt(Configuration.getProperty("COLUMN_CAR_AVAILABLE")));
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
        return car;
    }
}
