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
public class Vin extends Vare{

    public Vin(String titel, String beskrivelse, double vurderingspris) {
        super(titel, beskrivelse, vurderingspris);
    }
    private String producent;
    private String land;
    private String årgang;
    private String druer;
    private double procent;
    private int flaskestørrelse;
    private int antal;

    public Vin(String producent, String land, String årgang, String druer, double procent, int flaskestørrelse, int antal, String titel, String beskrivelse, double vurderingspris) {
        super(titel, beskrivelse, vurderingspris);
        this.producent = producent;
        this.land = land;
        this.årgang = årgang;
        this.druer = druer;
        this.procent = procent;
        this.flaskestørrelse = flaskestørrelse;
        this.antal = antal;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getÅrgang() {
        return årgang;
    }

    public void setÅrgang(String årgang) {
        this.årgang = årgang;
    }

    public String getDruer() {
        return druer;
    }

    public void setDruer(String druer) {
        this.druer = druer;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }

    public int getFlaskestørrelse() {
        return flaskestørrelse;
    }

    public void setFlaskestørrelse(int flaskestørrelse) {
        this.flaskestørrelse = flaskestørrelse;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }
    
}
