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
public class Bid {

    private User user;
    private Date time;
    private int amount;

    public Bid(User user, Date time, int amount) {
        this.user = user;
        this.time = time;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date tidspunkt) {
        this.time = tidspunkt;
    }

    public int getAmount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }
}
