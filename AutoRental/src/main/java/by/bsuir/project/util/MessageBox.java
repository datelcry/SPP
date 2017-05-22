package by.bsuir.project.util;

import javafx.scene.control.Alert;

/**
 * Created by User on 21.05.2017.
 */
public class MessageBox {
    public static void Show(String title, String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
