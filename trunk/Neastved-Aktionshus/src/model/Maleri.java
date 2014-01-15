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
public class Maleri extends Vare{

    public Maleri(String titel, String beskrivelse, double vurderingspris) {
        super(titel, beskrivelse, vurderingspris);
    }
    private String kunstner;
    private int aarstal;
    private String stilart;
    private String stoerrelse;

    public Maleri(String kunstner, int aarstal, String stilart, String stoerrelse, String titel, String beskrivelse, double vurderingspris) {
        super(titel, beskrivelse, vurderingspris);
        this.kunstner = kunstner;
        this.aarstal = aarstal;
        this.stilart = stilart;
        this.stoerrelse = stoerrelse;
    }

    public String getKunstner() {
        return kunstner;
    }

    public void setKunstner(String kunstner) {
        this.kunstner = kunstner;
    }

    public int getAarstal() {
        return aarstal;
    }

    public void setAarstal(int aarstal) {
        this.aarstal = aarstal;
    }

    public String getStilart() {
        return stilart;
    }

    public void setStilart(String stilart) {
        this.stilart = stilart;
    }

    public String getStoerrelse() {
        return stoerrelse;
    }

    public void setStoerrelse(String stoerrelse) {
        this.stoerrelse = stoerrelse;
    }
    
}
