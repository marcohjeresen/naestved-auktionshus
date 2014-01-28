/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.Timer;
import view.Loggin;


/**
 *
 * @author markh_000
 */
public class Main {
    

    public static void main(String[] args) {
        User Kurt = new User("Kurt", "Parkvej 170", 24243546);
        User Bent = new User("Bent", "Nøregade", 464646464);
        User Jens = new User("Jens", "Nøregade", 464646464);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(Bent);
        userList.add(Kurt);
        userList.add(Jens);
        
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 01, 20, 16, 30);
        

        String manufacturer = "ItalieWine";
        String country = "Italie";
        int yearOfProduction = 1890;
        String grapes = "RedGrapes";
        double percent = 13;
        double bottleSize = 1;
        int quantity = 3;
        String title = "Wine";
        String description = "Flot Flot vin";
        double estimatedPrice = 13000;
        String picturePath = ".\\Billeder\\glas vin.jpg";

        Wine vin1 = new Wine(manufacturer, country, yearOfProduction, grapes, percent, bottleSize, quantity, title, description, estimatedPrice, picturePath);

        manufacturer = "Denmark Wine";
        country = "Denmark";
        yearOfProduction = 1700;
        grapes = "Hvide Druer";
        percent = 15;
        bottleSize = 0.75;
        quantity = 4;
        title = "Wine";
        description = "Gammel vin fra mormorstid";
        estimatedPrice = 15000;
        picturePath = ".\\Billeder\\vin.jpg";
        Wine vin2 = new Wine(manufacturer, country, yearOfProduction, grapes, percent, bottleSize, quantity, title, description, estimatedPrice, picturePath);

        String materials = "Bøetræ";
        String dimensions = "50 * 200";
        title = "Furniture";
        description = "Arve Stykke";
        estimatedPrice = 5000;
        picturePath = ".\\Billeder\\bøgetræ sofa.jpg";

        Furniture møbel = new Furniture(materials, dimensions, title, description, estimatedPrice, picturePath);

        materials = "egetræ";
        dimensions = "50 * 250";
        title = "Furniture";
        description = "Nedslidt sofa";
        estimatedPrice = 1000;
        picturePath = ".\\Billeder\\Nedsligt egetræ sofa.jpg";

        Furniture møbel2 = new Furniture(materials, dimensions, title, description, estimatedPrice, picturePath);

        String metal = "Sølv";
        String gemstone = "Diamant";
        String stamp = "Bente";
        title = "Jewellery";
        description = "Mega flot ring";
        estimatedPrice = 2000;
        picturePath = ".\\Billeder\\sølvring med diamant.jpg";

        Jewellery smykke1 = new Jewellery(metal, gemstone, stamp, title, description, estimatedPrice, picturePath);

        metal = "Guld";
        gemstone = "Ædelsten";
        stamp = "Gucci";
        title = "Jewellery";
        description = "Gucci ring";
        estimatedPrice = 10000;
        picturePath = ".\\Billeder\\gucci ring med ædel.jpg";

        Jewellery smykke2 = new Jewellery(metal, gemstone, stamp, title, description, estimatedPrice, picturePath);

        String artist = "Vincent Van Gogh";
        int year = 1887;
        String style = "Den afslappede stil";
        String size = "1 * 1";
        title = "Painting";
        description = "Super godt afslappede billede malet af selveste Vincent Van Gogh";
        estimatedPrice = 10000000;
        picturePath = ".\\Billeder\\Vincent Van Gogh afslapp.jpg";

        Painting billede1 = new Painting(artist, year, style, size, title, description, estimatedPrice, picturePath);

        artist = "Vincent Van Gogh";
        year = 1889;
        style = "Den naturlige stil";
        size = "2 * 2";
        title = "Painting";
        description = "Masser af skov på dette mægtige billede af Vincent Van Gogh";
        estimatedPrice = 5000000;
        picturePath = ".\\Billeder\\Vincent Van Gogh natur.jpg";

        Painting billede2 = new Painting(artist, year, style, size, title, description, estimatedPrice, picturePath);
        
        Auction auk1 = new Auction(vin1, Jens, 1000, cal.getTime());
        cal.set(2014, 00, 21, 10, 04);
        Auction auk2 = new Auction(vin2, Jens, 1500, cal.getTime());
        cal.set(2014, 02, 15, 17, 00);
        Auction auk3 = new Auction(smykke1, Jens, 1000, cal.getTime());
        cal.set(2014, 01, 19, 12, 10);
        Auction auk4 = new Auction(smykke2, Jens, 5000, cal.getTime());
        cal.set(2014, 01, 17, 14, 20);
        Auction auk5 = new Auction(billede1, Jens, 8000000, cal.getTime());
        cal.set(2014, 01, 20, 15, 15);
        Auction auk6 = new Auction(billede2, Jens, 4000000, cal.getTime());
        cal.set(2014, 02, 13, 11, 00);
        Auction auk7 = new Auction(møbel, Jens, 900, cal.getTime());
        cal.set(2014, 03, 13, 16, 00);
        Auction auk8 = new Auction(møbel2, Jens, 500, cal.getTime());
        
        ArrayList<Auction> auctionList =  new ArrayList<>();
        auctionList.add(auk1);
        auctionList.add(auk2);
        auctionList.add(auk3);
        auctionList.add(auk4);
        auctionList.add(auk5);
        auctionList.add(auk6);
        auctionList.add(auk7);
        auctionList.add(auk8);
        
        
        Loggin login = new Loggin(userList, auctionList);
        login.setVisible(true);
        
        Loggin login2 = new Loggin(userList, auctionList);
        login2.setVisible(true);
        
        
        
    };
    
    
    
    
        
}
