package by.bsuir.project.model;

import java.io.Serializable;

/**
 * Created by User on 16.05.2017.
 */
public class Service implements Serializable {
    private int service_id;
    private String service_name;
    private float service_cost;

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public float getService_cost() {
        return service_cost;
    }

    public void setService_cost(float service_cost) {
        this.service_cost = service_cost;
    }
}
