package com.SirmaAcademy.OOPRetake.Clients;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Client implements Serializable {
    @JsonIgnore
    private  static int autoid=0;
    private int id;
    private String name;
    private String industry;
    private String contactPerson;
    private double revenue;

    public Client() {
    }
    public Client(String name, String industry, String contactPerson, double revenue) {
        this.id=autoid++;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String Information(){
        return  toString();
    }

    @Override
    public String toString() {
        return  "id: " + id +
                " Name: " + name +
                " Industry: "  + industry +
                " Contact Person: " + contactPerson +
                " Revenue: " + revenue;
    }
}
