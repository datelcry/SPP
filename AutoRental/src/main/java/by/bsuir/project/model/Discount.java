package by.bsuir.project.model;

import java.io.Serializable;

/**
 * Created by User on 16.05.2017.
 */
public class Discount implements Serializable {
    private int discount_id;
    private String discount_name;

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
    }

    public float getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(float discount_value) {
        this.discount_value = discount_value;
    }

    private float discount_value;
}
