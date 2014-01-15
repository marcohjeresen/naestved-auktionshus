/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

/**
 *
 * @author markh_000
 */
public class Bud {
    private Bruger bruger;
    private Date tidspunkt;
    private double beloeb;

    public Bud(Bruger bruger, Date tidspunkt, double beloeb) {
        this.bruger = bruger;
        this.tidspunkt = tidspunkt;
        this.beloeb = beloeb;
    }

    public Bruger getBruger() {
        return bruger;
    }

    public void setBruger(Bruger bruger) {
        this.bruger = bruger;
    }

    public Date getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(Date tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public double getBeloeb() {
        return beloeb;
    }

    public void setBeloeb(double beloeb) {
        this.beloeb = beloeb;
    }
    
}
