package by.bsuir.project.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by User on 27.03.2017.
 */
public class Order implements Serializable {
    private int order_id;
    private int order_client;
    private int order_car;
    private Date order_date_begin;
    private Date order_date_expir;

    public Date getOrder_date_expir() {
        return order_date_expir;
    }

    public void setOrder_date_expir(Date order_date_expir) {
        this.order_date_expir = order_date_expir;
    }

    public Date getOrder_date_begin() {
        return order_date_begin;
    }

    public void setOrder_date_begin(Date order_date_begin) {
        this.order_date_begin = order_date_begin;
    }

    public int getOrder_car() {
        return order_car;
    }

    public void setOrder_car(int order_car) {
        this.order_car = order_car;
    }

    public int getOrder_client() {
        return order_client;
    }

    public void setOrder_client(int order_client) {
        this.order_client = order_client;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
