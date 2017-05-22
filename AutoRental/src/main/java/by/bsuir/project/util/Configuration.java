package by.bsuir.project.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by User on 14.05.2017.
 */
public class Configuration {
    private final static ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("config");

    private Configuration(){

    }

    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
