/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Madsen
 */
public class Jewellery extends Product {

    public Jewellery(String title, String description, double estimatedPrice, String picturePath) {
        super(title, description, estimatedPrice, picturePath);
    }
    
    private String metal;
    private String gemstone;
    private String stamp;

    public Jewellery(String metal, String gemstone, String stamp, String title, String description, double estimatedPrice, String picturePath) {
        super(title, description, estimatedPrice, picturePath);
        this.metal = metal;
        this.gemstone = gemstone;
        this.stamp = stamp;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getGemstone() {
        return gemstone;
    }

    public void setGemstone(String gemstone) {
        this.gemstone = gemstone;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    

}
