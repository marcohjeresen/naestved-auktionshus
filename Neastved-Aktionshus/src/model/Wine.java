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
    private String yearOfProduction;
    private String grapes;
    private double percent;
    private int bottleSize;
    private int quantity ;

    public Wine(String manufacturer, String country, String yearOfProduction, String grapes, double percent, int bottleSize, int quantity, String title, String description, double estimatedPrice) {
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

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
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

    public int getBottleSize() {
        return bottleSize;
    }

    public void setBottleSize(int bottleSize) {
        this.bottleSize = bottleSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
