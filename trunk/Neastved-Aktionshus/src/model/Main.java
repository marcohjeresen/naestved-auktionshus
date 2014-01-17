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
        
        
        
        
        
    };
    
}
