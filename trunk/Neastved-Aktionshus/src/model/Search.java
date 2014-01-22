/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author markh_000
 */
public class Search {
    
//    ArrayList<Auction> auction = new ArrayList<Auction>();
    private HashSet<String> alist;
    private ArrayList<Auction> auctionList;

    public Search(ArrayList<Auction> auctionList) {
        this.auctionList = auctionList;
        alist = new HashSet<>();
        doCombo();

    }

    public void getProduct() {
        for (int i = 0; i < auctionList.size(); i++) {
            alist.add(auctionList.get(i).getProduct().getTitle());
            
        }
      
    }
    public void setProductlist(Object object){
        for (int i = 0; i < auctionList.size(); i++) {
            if (!auctionList.get(i).getProduct().getTitle().equals(object)) {
                System.out.println(auctionList.get(i).getProduct().getTitle());
                auctionList.add(auctionList.get(i));
                
            }
            
            
        }
        
    }
    
    private void doCombo() {
        getProduct();
        

    }

    public Set getProdukt() {
        getProduct();
        return alist;

    }
    
}
