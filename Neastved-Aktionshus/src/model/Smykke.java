/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Madsen
 */
public class Smykke {

    private String aedelsten;
    private String metal;
    private String stempel;

    public Smykke(String aedelsten, String metal, String stempel) {
        this.aedelsten = aedelsten;
        this.metal = metal;
        this.stempel = stempel;
    }

    public String getAedelsten() {
        return aedelsten;
    }

    public void setAedelsten(String aedelsten) {
        this.aedelsten = aedelsten;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getStempel() {
        return stempel;
    }

    public void setStempel(String stempel) {
        this.stempel = stempel;
    }
}
