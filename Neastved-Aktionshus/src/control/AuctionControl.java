/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.ArrayList;
import java.util.Date;
import model.Auction;
import model.Furniture;
import model.Jewellery;
import model.Painting;
import model.Product;
import model.User;
import model.Wine;

/**
 *
 * @author markh_000
 */
public class AuctionControl {
    
    private ArrayList<Auction> auctionlist;
    
    public AuctionControl(ArrayList<Auction> auctionlist){
        this.auctionlist = auctionlist;
        
    }
    
    public ArrayList<Auction> getAuctionlist() {
        return auctionlist;
    }
    
    public void addAuction(Auction action){
        auctionlist.add(action);
    }
    public ArrayList<Auction> getSpecificAuction(String product, String maxPrice){
        ArrayList<Auction> al = new ArrayList<>();
        int max;
        try {
            max = Integer.parseInt(maxPrice);
            if (max == 0) {
                max = 10000000;
                
            }
        }catch (NumberFormatException ex) {
            max = 10000000;
        }

        for (Auction auction : auctionlist) {

            switch (product) {
                case "Furniture":
                    if (auction.getProduct() instanceof Furniture) {
                        if (auction.getLatestBid() <= max) {
                            al.add(auction);
                        }
                    }
                    break;
                case "Jewellery":
                    if (auction.getProduct() instanceof Jewellery) {
                        if (auction.getLatestBid() <= max) {
                            al.add(auction);
                        }
                    }
                    break;
                case "Painting":
                    if (auction.getProduct() instanceof Painting) {
                        if (auction.getLatestBid() <= max) {
                            al.add(auction);
                        }
                    }
                    break;
                case "Wine":
                    if (auction.getProduct() instanceof Wine) {
                        if (auction.getLatestBid() <= max) {
                            al.add(auction);
                        }
                    }
                    break;
                case "all auctions":

                    if (auction.getLatestBid() <= max) {
                        al.add(auction);

                    }
                break;
                    
                default:
                    al = auctionlist;
                    break;
            }
        }

        
        
        
        return al;
    }
    
    public void createAuction(Product p, User u, int startbid, Date time){
        Auction a = new Auction(p, u, startbid, time);
        auctionlist.add(a);
        
    }
    
}
