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
    private double startbid;
    private Date time;
    ArrayList<Bid> bidingHistory;

    public Auction(Product product, User user, double startbid, Date time) {
        this.product = product;
        this.user = user;
        this.startbid = startbid;
        this.time = time;
        bidingHistory = new ArrayList<Bid>();
    }
    
    public double getLatestBid(){
        double bid;
        if (bidingHistory.isEmpty()) {
            bid = startbid;
            
        }else{
            bid = bidingHistory.get(bidingHistory.size() - 1).getAmount();
        }
        return bid;
    }
    


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

    public double getStartbid() {
        return startbid;
    }

    public void setStartbid(double startbid) {
        this.startbid = startbid;
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
