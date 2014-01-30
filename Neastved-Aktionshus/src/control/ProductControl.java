/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Furniture;
import model.Jewellery;
import model.Painting;
import model.Wine;

/**
 *
 * @author markh_000
 */
public class ProductControl {

    private String manufacturer;
    private String country;
    private int yearOfProduction;
    private String grapes;
    private double percent;
    private double bottleSize;
    private int quantity;
    private String title;
    private String description;
    private int estimatedPrice;
    private String picturePath;
    private String materials;
    private String dimensions;
    private String metal;
    private String gemstone;
    private String stamp;
    private String artist;
    private int year;
    private String style;
    private String size;

    public ProductControl() {

    }
    
    public Wine createWine(){
        Wine wine = new Wine(manufacturer, country, yearOfProduction, grapes, percent, bottleSize, quantity, title, description, estimatedPrice, picturePath);
        return wine;
    }
    
    public Furniture createFurniture(){
        Furniture f = new Furniture(materials, dimensions, title, description, estimatedPrice, picturePath);
        return f;
    }
    public Painting createPainting(){
        Painting p = new Painting(artist, year, style, size, title, description, estimatedPrice, picturePath);
        return p;
    }
    
    public Jewellery createJewellery(){
        Jewellery j = new Jewellery(metal, gemstone, stamp, title, description, estimatedPrice, picturePath);
        return j;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void setBottleSize(double bottleSize) {
        this.bottleSize = bottleSize;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEstimatedPrice(int estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public void setGemstone(String gemstone) {
        this.gemstone = gemstone;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setSize(String size) {
        this.size = size;
    }
    

}
