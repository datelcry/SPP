package by.bsuir.project.dao.impl;

import by.bsuir.project.dao.CrudDAO;
import by.bsuir.project.exception.DAOException;
import by.bsuir.project.model.Maintenance;
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
public class MaintenanceDAOImpl extends DAO implements CrudDAO<Maintenance> {
    private static final String ADD_MAINTENANCE = "insert into maintenances (maintenance_defect, maintenance_cost, maintenance_car, maintenance_staff, maintenance_date_begin, maintenance_date_expir) values (?,?,?,?,?,?)";
    private static final String DELETE_MAINTENANCE = "delete from maintenances where maintenance_id=?";
    private static final String UPDATE_MAINTENANCE = "update maintenances set maintenance_defect=?, maintenance_cost=?, maintenance_car=?, maintenance_staff=?, maintenance_date_begin=?, maintenance_date_expir=? where maintenance_id=?";
    private static final String GET_ALL_MAINTENANCES = "select maintenance_id, maintenance_defect, maintenance_cost, maintenance_car, maintenance_staff, maintenance_date_begin, maintenance_date_expir from maintenances";
    private static final String GET_MAINTENANCE= "select maintenance_id, maintenance_defect, maintenance_cost, maintenance_car, maintenance_staff, maintenance_date_begin, maintenance_date_expir from maintenances where maintenance_id=?";

    @Override
    public void addEntity(Maintenance maintenance) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(ADD_MAINTENANCE);
            preparedStatement.setString(1, String.valueOf(maintenance.getMaintenance_defect()));
            preparedStatement.setString(2, String.valueOf(maintenance.getMaintenance_cost()));
            preparedStatement.setString(3, String.valueOf(maintenance.getMaintenance_car()));
            preparedStatement.setString(4, String.valueOf(maintenance.getMaintenance_staff()));
            preparedStatement.setString(5, maintenance.getMaintenance_date_begin().toString());
            preparedStatement.setString(6, maintenance.getMaintenance_date_expir().toString());
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
    public void deleteEntity(int maintenance_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_MAINTENANCE);
            preparedStatement.setInt(1, maintenance_id);
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
    public void updateEntity(Maintenance maintenance) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_MAINTENANCE);
            preparedStatement.setString(1, String.valueOf(maintenance.getMaintenance_defect()));
            preparedStatement.setString(2, String.valueOf(maintenance.getMaintenance_cost()));
            preparedStatement.setString(3, String.valueOf(maintenance.getMaintenance_car()));
            preparedStatement.setString(4, String.valueOf(maintenance.getMaintenance_staff()));
            preparedStatement.setString(5, maintenance.getMaintenance_date_begin().toString());
            preparedStatement.setString(6, maintenance.getMaintenance_date_expir().toString());
            preparedStatement.setInt(7, maintenance.getMaintenance_id());
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
    public ArrayList<Maintenance> getAllEntities() throws DAOException {
        ArrayList<Maintenance> maintenances = new ArrayList<Maintenance>();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_MAINTENANCES);
            while (resultSet.next()) {
                Maintenance maintenance = new Maintenance();
                maintenance.setMaintenance_id(resultSet.getInt(Configuration.getProperty("COLUMN_MAINTENANCE_ID")));
                maintenance.setMaintenance_defect(resultSet.getString(Configuration.getProperty("COLUMN_MAINTENANCE_DEFECT")));
                maintenance.setMaintenance_cost(resultSet.getFloat(Configuration.getProperty("COLUMN_MAINTENANCE_COST")));
                maintenance.setMaintenance_car(resultSet.getInt(Configuration.getProperty("COLUMN_MAINTENANCE_CAR")));
                maintenance.setMaintenance_staff(resultSet.getInt(Configuration.getProperty("COLUMN_MAINTENANCE_STAFF")));
                maintenance.setMaintenance_date_begin(resultSet.getDate(Configuration.getProperty("COLUMN_MAINTENANCE_DATE_BEGIN")));
                maintenance.setMaintenance_date_expir(resultSet.getDate(Configuration.getProperty("COLUMN_MAINTENANCE_DATE_EXPIR")));
                maintenances.add(maintenance);
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
        return maintenances;
    }

    @Override
    public Maintenance getEntityById(int maintenance_id) throws DAOException {
        Maintenance maintenance = new Maintenance();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(GET_MAINTENANCE);
            preparedStatement.setInt(1, maintenance_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                maintenance.setMaintenance_id(resultSet.getInt(Configuration.getProperty("COLUMN_MAINTENANCE_ID")));
                maintenance.setMaintenance_defect(resultSet.getString(Configuration.getProperty("COLUMN_MAINTENANCE_DEFECT")));
                maintenance.setMaintenance_cost(resultSet.getFloat(Configuration.getProperty("COLUMN_MAINTENANCE_COST")));
                maintenance.setMaintenance_car(resultSet.getInt(Configuration.getProperty("COLUMN_MAINTENANCE_CAR")));
                maintenance.setMaintenance_staff(resultSet.getInt(Configuration.getProperty("COLUMN_MAINTENANCE_STAFF")));
                maintenance.setMaintenance_date_begin(resultSet.getDate(Configuration.getProperty("COLUMN_MAINTENANCE_DATE_BEGIN")));
                maintenance.setMaintenance_date_expir(resultSet.getDate(Configuration.getProperty("COLUMN_MAINTENANCE_DATE_EXPIR")));
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
        return maintenance;
    }
}
