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
public class Painting extends Product{

    public Painting(String title, String description, double estimatedPrice) {
        super(title, description, estimatedPrice);
    }

    private String artist;
    private int year;
    private String style;
    private String size;

    public Painting(String artist, int year, String style, String size, String title, String description, double estimatedPrice) {
        super(title, description, estimatedPrice);
        this.artist = artist;
        this.year = year;
        this.style = style;
        this.size = size;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
   
    
}
