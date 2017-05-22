package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Staff;
import by.bsuir.project.model.Staff;
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
public class StaffDAOImpl extends DAO implements CrudDAO<Staff> {
    private static final String ADD_STAFF = "insert into staff (staff_full_name, staff_post, staff_salary) values (?,?,?)";
    private static final String DELETE_STAFF = "delete from staff where staff_id=?";
    private static final String UPDATE_STAFF = "update staff set staff_full_name=?, staff_post=?, staff_salary=? where staff_id=?";
    private static final String GET_ALL_STAFF = "select staff_id, staff_full_name, staff_post, staff_salary from staff";
    private static final String GET_STAFF= "select staff_id, staff_full_name, staff_post, staff_salary from staff where staff_id=?";

    @Override
    public void addEntity(Staff staff) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_STAFF);
            preparedStatement.setString(1, String.valueOf(staff.getStaff_full_name()));
            preparedStatement.setString(2, String.valueOf(staff.getStaff_post()));
            preparedStatement.setString(3, String.valueOf(staff.getStaff_salary()));
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
    public void deleteEntity(int staff_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_STAFF);
            preparedStatement.setInt(1, staff_id);
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
    public void updateEntity(Staff staff) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_STAFF);
            preparedStatement.setString(1, String.valueOf(staff.getStaff_full_name()));
            preparedStatement.setString(2, String.valueOf(staff.getStaff_post()));
            preparedStatement.setString(3, String.valueOf(staff.getStaff_salary()));
            preparedStatement.setInt(4, staff.getStaff_id());
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
    public ArrayList<Staff> getAllEntities() throws DAOException {
        ArrayList<Staff> staffs = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_STAFF);
            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt(Configuration.getProperty("COLUMN_STAFF_ID")));
                staff.setStaff_full_name(resultSet.getString(Configuration.getProperty("COLUMN_STAFF_FULL_NAME")));
                staff.setStaff_post(resultSet.getString(Configuration.getProperty("COLUMN_STAFF_POST")));
                staff.setStaff_salary(resultSet.getFloat(Configuration.getProperty("COLUMN_STAFF_SALARY")));
                staffs.add(staff);
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
        return staffs;
    }

    @Override
    public Staff getEntityById(int staff_id) throws DAOException {
        Staff staff = new Staff();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_STAFF);
            preparedStatement.setInt(1, staff_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                staff.setStaff_id(resultSet.getInt(Configuration.getProperty("COLUMN_STAFF_ID")));
                staff.setStaff_full_name(resultSet.getString(Configuration.getProperty("COLUMN_STAFF_FULL_NAME")));
                staff.setStaff_post(resultSet.getString(Configuration.getProperty("COLUMN_STAFF_POST")));
                staff.setStaff_salary(resultSet.getFloat(Configuration.getProperty("COLUMN_STAFF_SALARY")));
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
        return staff;
    }
}
