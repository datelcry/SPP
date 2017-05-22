package by.bsuir.project.model;

import java.io.Serializable;

/**
 * Created by User on 20.05.2017.
 */
public class Car implements Serializable {
    private int car_id;
    private String car_number;
    private String car_category;
    private int car_brand;
    private int car_staff;
    private int car_available;

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCar_category() {
        return car_category;
    }

    public void setCar_category(String car_category) {
        this.car_category = car_category;
    }

    public int getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(int car_brand) {
        this.car_brand = car_brand;
    }

    public int getCar_staff() {
        return car_staff;
    }

    public void setCar_staff(int car_staff) {
        this.car_staff = car_staff;
    }

    public int getCar_available() {
        return car_available;
    }

    public void setCar_available(int car_available) {
        this.car_available = car_available;
    }
}
