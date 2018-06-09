package com.yorix.hillel.java_elementary.task40.domains;

import java.math.BigDecimal;
import java.util.Calendar;

public class Model {
    private int id;
    private int markId;
    private String model;
    private int gearBoxTypeId;
    private Calendar yearOfManufacture;
    private BigDecimal price;
    private int number;
    private int countryId;

    public Model(int id, int markId, String model, int gearBoxTypeId, Calendar yearOfManufacture, BigDecimal price, int number, int countryId) {
        this.id = id;
        this.markId = markId;
        this.model = model;
        this.gearBoxTypeId = gearBoxTypeId;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.number = number;
        this.countryId = countryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGearBoxTypeId() {
        return gearBoxTypeId;
    }

    public void setGearBoxTypeId(int gearBoxTypeId) {
        this.gearBoxTypeId = gearBoxTypeId;
    }

    public Calendar getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Calendar yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
