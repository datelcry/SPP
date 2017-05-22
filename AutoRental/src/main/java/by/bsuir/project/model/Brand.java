package by.bsuir.project.model;

import java.io.Serializable;

/*
 * Created by User on 09.05.2017.
 */
public class Brand implements Serializable {
    private int brand_id;
    private String brand_name;
    private String brand_class;
    private int brand_numbers_of_seats;
    private int brand_issue_year;
    private String brand_engine;
    private float brand_tariff;

    public float getBrand_tariff() {
        return brand_tariff;
    }

    public void setBrand_tariff(float brand_tariff) {
        this.brand_tariff = brand_tariff;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_class() {
        return brand_class;
    }

    public void setBrand_class(String brand_class) {
        this.brand_class = brand_class;
    }

    public int getBrand_numbers_of_seats() {
        return brand_numbers_of_seats;
    }

    public void setBrand_numbers_of_seats(int brand_numbers_of_seats) {
        this.brand_numbers_of_seats = brand_numbers_of_seats;
    }

    public int getBrand_issue_year() {
        return brand_issue_year;
    }

    public void setBrand_issue_year(int brand_issue_year) {
        this.brand_issue_year = brand_issue_year;
    }

    public String getBrand_engine() {
        return brand_engine;
    }

    public void setBrand_engine(String brand_engine) {
        this.brand_engine = brand_engine;
    }
}
