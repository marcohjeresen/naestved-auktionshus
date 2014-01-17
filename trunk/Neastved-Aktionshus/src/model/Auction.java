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
public class Auction {
    private Product product;
    private User user;
    private double amount;
    private Date time;
    ArrayList<Bid> bidingHistory;

    public Auction(Product product, User user, double amount, Date time) {
        this.product = product;
        this.user = user;
        this.amount = amount;
        this.time = time;
        bidingHistory = new ArrayList<Bid>();
    }
    
//    public void addBid(Bid bid){
//        if (bidingHistory.isEmpty()) {
//            setAmount(bid);
//            bidingHistory.add(bid);
//        }else {
//            bidingHistory.add(bid);
//        }
//        
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ArrayList<Bid> getBidingHistory() {
        return bidingHistory;
    }

    public void setBidingHistory(ArrayList<Bid> bidingHistory) {
        this.bidingHistory = bidingHistory;
    }

   
    
}
