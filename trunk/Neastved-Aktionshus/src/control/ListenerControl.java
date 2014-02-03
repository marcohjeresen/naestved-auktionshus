/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionListener;
import model.Listener;

/**
 *
 * @author Anders Bo Rasmussen
 */
public class ListenerControl {

    private Listener listen;

    public ListenerControl() {
        listen = new Listener();
    }

    public void addListener(ActionListener listener) {
        listen.addListener(listener);
    }

    public void notifyListeners(String msg) {
        listen.notifyListeners(msg);
    }

}
