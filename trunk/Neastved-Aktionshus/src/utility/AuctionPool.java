/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import model.Auction;

/**
 *
 * @author Dennis
 */
public class AuctionPool {
private AuctionList auction; 

    public AuctionPool() {
     auction = new AuctionList();  
    }

    public void addAuction(Auction auction) {
        auction.add (auction); 
    }


    
}
