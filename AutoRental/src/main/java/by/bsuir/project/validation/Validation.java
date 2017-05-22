package by.bsuir.project.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 20.05.2017.
 */
public class Validation {

    public boolean isValidLogin(String login) {
        Pattern p = Pattern.compile("^[A-z]{1}[a-zA-Z0-9-_\\\\.]{5,20}$");
        Matcher m = p.matcher(login);
        return m.matches();
    }

    public boolean isValidPassword(String password) {
        Pattern p = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public boolean isValidDate(String date) {
        Pattern p = Pattern.compile("(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)");
        Matcher m = p.matcher(date);
        return m.matches();

    }

    public boolean isValidID(String id) {
        Pattern p = Pattern.compile("[0-9]{1,10}");
        Matcher m = p.matcher(id);
        return m.matches();
    }

    public boolean isValidEmail(String email) {
        Pattern p = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
