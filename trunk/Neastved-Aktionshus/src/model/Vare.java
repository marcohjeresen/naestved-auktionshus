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
public class Vare {
    protected String titel;
    protected String beskrivelse;
    protected double vurderingspris;
//vi vælger af lave dem protected så vi kan tilgå variablerne fra underklasser
    
    public Vare(String titel, String beskrivelse, double vurderingspris) {
        this.titel = titel;
        this.beskrivelse = beskrivelse;
        this.vurderingspris = vurderingspris;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public double getVurderingspris() {
        return vurderingspris;
    }

    public void setVurderingspris(double vurderingspris) {
        this.vurderingspris = vurderingspris;
    }
    
}
