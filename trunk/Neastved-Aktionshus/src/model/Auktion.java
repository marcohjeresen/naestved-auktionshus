/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Madsen
 */
public class Auktion {
    private Vare vare;
    private Bruger saelger;
    private Bud startbud;
    private Date sluttidspunkt;
    ArrayList<Bud> budhistorik = new ArrayList<Bud>();

    public Auktion(Vare vare, Bruger saelger, Bud startbud, Date sluttidspunkt) {
        this.vare = vare;
        this.saelger = saelger;
        this.startbud = startbud;
        this.sluttidspunkt = sluttidspunkt;
    }

    public Vare getVare() {
        return vare;
    }

    public void setVare(Vare vare) {
        this.vare = vare;
    }

    public Bruger getSaelger() {
        return saelger;
    }

    public void setSaelger(Bruger saelger) {
        this.saelger = saelger;
    }

    public Bud getStartbud() {
        return startbud;
    }

    public void setStartbud(Bud startbud) {
        this.startbud = startbud;
    }

    public Date getSluttidspunkt() {
        return sluttidspunkt;
    }

    public void setSluttidspunkt(Date sluttidspunkt) {
        this.sluttidspunkt = sluttidspunkt;
    }

    public ArrayList<Bud> getBudhistorik() {
        return budhistorik;
    }

    public void setBudhistorik(ArrayList<Bud> budhistorik) {
        this.budhistorik = budhistorik;
    }
            
}
