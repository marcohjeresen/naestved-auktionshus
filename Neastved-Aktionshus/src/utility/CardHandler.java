/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Anders Bo Rasmussen
 */
public class CardHandler {

    private CardLayout cl;
    private JPanel main;
    private ArrayList<JPanel> pages;

    public CardHandler(CardLayout cl, JPanel main) {
        this.cl = cl;
        this.main = main;
        pages = new ArrayList<>();
        this.cl = (CardLayout) main.getLayout();
    }

    public void addPage(JPanel panel, String ref) {
        main.add(panel, ref);
    }

    public void show(String ref) {
        cl.show(main, ref);
        main.revalidate();
    }
}
