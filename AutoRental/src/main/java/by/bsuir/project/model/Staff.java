package by.bsuir.project.model;

import java.io.Serializable;

/**
 * Created by User on 20.05.2017.
 */
public class Staff implements Serializable {
    private int staff_id;
    private String staff_full_name;
    private String staff_post;
    private float staff_salary;

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_full_name() {
        return staff_full_name;
    }

    public void setStaff_full_name(String staff_full_name) {
        this.staff_full_name = staff_full_name;
    }

    public String getStaff_post() {
        return staff_post;
    }

    public void setStaff_post(String staff_post) {
        this.staff_post = staff_post;
    }

    public float getStaff_salary() {
        return staff_salary;
    }

    public void setStaff_salary(float staff_salary) {
        this.staff_salary = staff_salary;
    }
}
