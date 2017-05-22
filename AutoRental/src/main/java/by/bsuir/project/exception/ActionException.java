package by.bsuir.project.exception;

/**
 * Created by User on 14.05.2017.
 */
public class ActionException extends Exception {

    public ActionException(String message) {
        super(message);
    }

    public ActionException(Throwable cause) {
        super(cause);
    }

    public ActionException(String message, Throwable cause) {
        super(message, cause);
    }

}
