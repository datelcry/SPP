package by.bsuir.project.model;

import java.io.Serializable;

/**
 * Created by User on 20.05.2017.
 */
public class Client implements Serializable {
    private int client_id;
    private String client_full_name;
    private String client_number_passport;
    private String client_number_license;
    private String client_location;
    private String client_number_phone;
    private int client_account;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_full_name() {
        return client_full_name;
    }

    public void setClient_full_name(String client_full_name) {
        this.client_full_name = client_full_name;
    }

    public String getClient_number_passport() {
        return client_number_passport;
    }

    public void setClient_number_passport(String client_number_passport) {
        this.client_number_passport = client_number_passport;
    }

    public String getClient_number_license() {
        return client_number_license;
    }

    public void setClient_number_license(String client_number_license) {
        this.client_number_license = client_number_license;
    }

    public String getClient_location() {
        return client_location;
    }

    public void setClient_location(String client_location) {
        this.client_location = client_location;
    }

    public String getClient_number_phone() {
        return client_number_phone;
    }

    public void setClient_number_phone(String client_number_phone) {
        this.client_number_phone = client_number_phone;
    }

    public int getClient_account() {
        return client_account;
    }

    public void setClient_account(int client_account) {
        this.client_account = client_account;
    }
}
