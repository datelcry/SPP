package by.bsuir.project.util;

/**
 * Created by User on 23.03.2017.
 */

import com.mysql.jdbc.Driver;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Driver;

public abstract class DAO {
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "user";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PROPERTIES_FILE = "/db.properties";

    private Connection connection;
    protected Connection getConnection() {
        InputStream inputStream = DAO.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        Properties properties = new Properties();
        try {
            if (connection != null && !connection.isClosed())
                return connection;
            properties.load(inputStream);
            String url = properties.getProperty(PROPERTY_URL);
            String driver = properties.getProperty(PROPERTY_DRIVER);
            String user = properties.getProperty(PROPERTY_USERNAME);
            String password = properties.getProperty(PROPERTY_PASSWORD);
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            throw new DAOException(e);
        }
        return connection;
    }

    protected void closeConnection() {
        if (connection == null)
            return;
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
