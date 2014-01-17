/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author markh_000
 */
public class Wine extends Product{

    public Wine(String title, String description, double estimatedPrice) {
        super(title, description, estimatedPrice);
    }
    private String manufacturer;
    private String country;
    private double yearOfProduction;
    private String grapes;
    private double percent;
    private double bottleSize;
    private int quantity ;

    public Wine(String manufacturer, String country, double yearOfProduction, String grapes, double percent, double bottleSize, int quantity, String title, String description, double estimatedPrice) {
        super(title, description, estimatedPrice);
        this.manufacturer = manufacturer;
        this.country = country;
        this.yearOfProduction = yearOfProduction;
        this.grapes = grapes;
        this.percent = percent;
        this.bottleSize = bottleSize;
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(double yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getGrapes() {
        return grapes;
    }

    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getBottleSize() {
        return bottleSize;
    }

    public void setBottleSize(double bottleSize) {
        this.bottleSize = bottleSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}