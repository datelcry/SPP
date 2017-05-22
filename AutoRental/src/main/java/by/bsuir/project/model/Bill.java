package by.bsuir.project.model;

import java.io.Serializable;

/**
 * Created by User on 09.05.2017.
 */
public class Bill implements Serializable {
    private int bill_id;
    private String bill_code;
    private float bill_cost;
    private int bill_discount;
    private int bill_order;

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_code() {
        return bill_code;
    }

    public void setBill_code(String bill_code) {
        this.bill_code = bill_code;
    }

    public float getBill_cost() {
        return bill_cost;
    }

    public void setBill_cost(float bill_cost) {
        this.bill_cost = bill_cost;
    }

    public int getBill_discount() {
        return bill_discount;
    }

    public void setBill_discount(int bill_discount) {
        this.bill_discount = bill_discount;
    }

    public int getBill_order() {
        return bill_order;
    }

    public void setBill_order(int bill_order) {
        this.bill_order = bill_order;
    }
}
