/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author markh_000
 */
public class Main {
    public static void main(String[] args) {
        User Kurt = new User("Kurt", "Parkvej 170", 24243546);
        User Bent = new User("Bent", "Nøregade", 464646464);
        
        ArrayList<User> userList = new ArrayList<>();
        userList.add(Bent);
        userList.add(Kurt);
        
        String manufacturer = "ItalieWine";
        String country = "Italie";
        double yearOfProduction = 1890;
        String grapes = "RedGrapes";
        double percent = 13;
        double bottleSize = 1;
        int quantity = 3;
        String title = "Wine";
        String description = "Flot Flot vin";
        double estimatedPrice = 13000;
                

        Wine vin1 = new Wine(manufacturer, country, yearOfProduction, grapes, percent, bottleSize, quantity, title, description, estimatedPrice);
        
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
        Wine vin2 = new Wine(manufacturer, country, yearOfProduction, grapes, percent, bottleSize, quantity, title, description, estimatedPrice);
        
        String materials = "Bøetræ";
        String dimensions = "50 * 200";
        title = "Furniture";
        description = "Arve Stykke";
        estimatedPrice = 5000;
        
        Furniture møbel = new Furniture(materials, dimensions, title, description, estimatedPrice);
        
        materials = "egetræ";
        dimensions = "50 * 250";
        title = "Furniture";
        description = "Nedslidt sofa";
        estimatedPrice = 1000;
        
        Furniture møbel2 = new Furniture(materials, dimensions, title, description, estimatedPrice);
        
        
    };
    
}
