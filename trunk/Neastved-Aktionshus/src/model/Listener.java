/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Anders Bo Rasmussen
 */
public class Listener {

    private ArrayList<ActionListener> listeners;

    public Listener() {
        listeners = new ArrayList<>();
    }

    public void addListener(ActionListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(String msg) {
        for (ActionListener listener : listeners) {
            ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, msg);
            listener.actionPerformed(event);
        }
    }

}
