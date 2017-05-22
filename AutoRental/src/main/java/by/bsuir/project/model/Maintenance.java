package by.bsuir.project.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by User on 20.05.2017.
 */
public class Maintenance implements Serializable {
    private int maintenance_id;
    private String maintenance_defect;
    private float maintenance_cost;
    private int maintenance_car;
    private int maintenance_staff;
    private Date maintenance_date_begin;
    private Date maintenance_date_expir;

    public int getMaintenance_id() {
        return maintenance_id;
    }

    public void setMaintenance_id(int maintenance_id) {
        this.maintenance_id = maintenance_id;
    }

    public String getMaintenance_defect() {
        return maintenance_defect;
    }

    public void setMaintenance_defect(String maintenance_defect) {
        this.maintenance_defect = maintenance_defect;
    }

    public float getMaintenance_cost() {
        return maintenance_cost;
    }

    public void setMaintenance_cost(float maintenance_cost) {
        this.maintenance_cost = maintenance_cost;
    }

    public int getMaintenance_car() {
        return maintenance_car;
    }

    public void setMaintenance_car(int maintenance_car) {
        this.maintenance_car = maintenance_car;
    }

    public int getMaintenance_staff() {
        return maintenance_staff;
    }

    public void setMaintenance_staff(int maintenance_staff) {
        this.maintenance_staff = maintenance_staff;
    }

    public Date getMaintenance_date_begin() {
        return maintenance_date_begin;
    }

    public void setMaintenance_date_begin(Date maintenance_date_begin) {
        this.maintenance_date_begin = maintenance_date_begin;
    }

    public Date getMaintenance_date_expir() {
        return maintenance_date_expir;
    }

    public void setMaintenance_date_expir(Date maintenance_date_expir) {
        this.maintenance_date_expir = maintenance_date_expir;
    }
}
