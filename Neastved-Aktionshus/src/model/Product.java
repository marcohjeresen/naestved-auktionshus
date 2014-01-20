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
public class Product {
    private String title;
    private String description;
    private double estimatedPrice;

//vi vælger af lave dem protected så vi kan tilgå variablerne fra underklasser
    public Product(String title, String description, double estimatedPrice) {
        this.title = title;
        this.description = description;
        this.estimatedPrice = estimatedPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }
    
   
}
