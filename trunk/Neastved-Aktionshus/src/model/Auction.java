/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import view.AuctionPanel;

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

    public double getLatestBid() {
        double bid;
        if (bidingHistory.isEmpty()) {
            bid = startbid;

        } else {
            bid = bidingHistory.get(bidingHistory.size() - 1).getAmount();
        }
        return bid;
    }

    public void setLatesBid(Bid bid) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (getUser().getName().equals(bid.getUser().getName())) {
            throw new Exception("Sælger kan ikke byde");
        
        }else{
            if (cal.getTime().after(time)) {
            throw new Exception("Auctinon er slut");
        } else {
            if (bidingHistory.isEmpty() && bid.getAmount() > startbid) {
                bidingHistory.add(bid);

            } else if (!bidingHistory.isEmpty() && bid.getAmount() > getLatestBid()) {
                bidingHistory.add(bid);

            } else {
                throw new Exception("Budet er nød til at være højere ind det nuværende og/eller Startbud");
            }
        }
    }}
    
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

    public void add(Auction auction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
