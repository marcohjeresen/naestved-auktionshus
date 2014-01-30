/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Auction;
import model.Furniture;
import model.Jewellery;
import model.Painting;
import model.Search;
import model.User;
import model.Wine;

/**
 *
 * @author markh_000
 */
public class HovdePanel extends javax.swing.JPanel {

    private ArrayList<Auction> auctionsListe;
    private ArrayList<AuctionPanel> apListe;
    private User buyer;
    private int i;
    private Auction at;
    private Search search;
    private String maxPrice;
    private double MaxPrice;
    private MainFrame1 mf;
    private boolean færdig = false;

    /**
     * Creates new form main
     */
    public HovdePanel(ArrayList<Auction> auctionsListe, User buyer, MainFrame1 mf) {

        initComponents();
        this.auctionsListe = auctionsListe;
        apListe = new ArrayList<>();
        this.buyer = buyer;
        this.mf = mf;

        createPanels(auctionsListe);
        setJcombobox();

    }

    private void createPanels(ArrayList<Auction> auctionsLis) {

        int x = 0;
        int y = 0;
        int height = 0;
        int width = 0;
        for (Auction auction : auctionsLis) {
            AuctionPanel ap = new AuctionPanel(auction, mf);
            ap.setLocation(x, y);
            jPanel_SamletAktion.add(ap);
            jPanel_SamletAktion.revalidate();
            y += ap.getHeight();
            ap.setVisible(true);
            height = ap.getHeight();
            width = ap.getWidth();
        }
        if (auctionsLis.size() > 4) {
            height *= auctionsListe.size();
            jPanel_SamletAktion.setPreferredSize(new Dimension(width, height));
            width += 18;
            jScrollPane1.setPreferredSize(new Dimension(width, height));
        }
    }

    public User getBuyer() {
        return buyer;
    }

    private void setJcombobox() {
        jComboBox1.removeAllItems();
        Search search = new Search(auctionsListe);
        jComboBox1.addItem("all auctions");
        for (Object s : search.getProdukt()) {
            jComboBox1.addItem(s);
        }
    }

    public ArrayList<Auction> getSpecificAuction(String product) throws Exception {
        ArrayList<Auction> al = new ArrayList<>();

        for (Auction auction : auctionsListe) {

            switch (product) {
                case "Furniture":
                    if (auction.getProduct() instanceof Furniture) {
                        if (auction.getLatestBid() <= MaxPrice) {
                            al.add(auction);
                        }
                    }
                    break;
                case "Jewellery":
                    if (auction.getProduct() instanceof Jewellery) {
                        if (auction.getLatestBid() <= MaxPrice) {
                            al.add(auction);
                        }
                    }
                    break;
                case "Painting":
                    if (auction.getProduct() instanceof Painting) {
                        if (auction.getLatestBid() <= MaxPrice) {
                            al.add(auction);
                        }
                    }
                    break;
                case "Wine":
                    if (auction.getProduct() instanceof Wine) {
                        if (auction.getLatestBid() <= MaxPrice) {
                            al.add(auction);
                        }
                    }
                    break;
                case "all auctions":

                    if (auction.getLatestBid() <= MaxPrice) {
                        al.add(auction);

                    }
                break;
                    
                default:
                    al = auctionsListe;
                    break;
            }
        }

        jPanel_SamletAktion.removeAll();
        createPanels(al);
        jPanel_SamletAktion.updateUI();
        return al;

    }

    public void update() {
        maxPrice = jTextField_pris.getText();
        if ("".equals(maxPrice) || "0".equals(maxPrice)) {
            maxPrice = "10000000";
        }
        try {
            String selectedItem = (String) jComboBox1.getSelectedItem();
            MaxPrice = Double.parseDouble(maxPrice);
            getSpecificAuction(selectedItem);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel_SamletAktion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jTextField_pris = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jPanel_SamletAktion.setMinimumSize(new java.awt.Dimension(534, 487));

        javax.swing.GroupLayout jPanel_SamletAktionLayout = new javax.swing.GroupLayout(jPanel_SamletAktion);
        jPanel_SamletAktion.setLayout(jPanel_SamletAktionLayout);
        jPanel_SamletAktionLayout.setHorizontalGroup(
            jPanel_SamletAktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        jPanel_SamletAktionLayout.setVerticalGroup(
            jPanel_SamletAktionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel_SamletAktion);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Næstved Aktionshus");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Type:" }));

        jButton1.setText("Søg");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField_pris.setText("0");

        jLabel2.setText("Max Pris:");

        jButton3.setText("Opret Produkt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField_pris)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_pris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(19, 19, 19))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        maxPrice = jTextField_pris.getText();
        if ("".equals(maxPrice) || "0".equals(maxPrice)) {
            maxPrice = "10000000";
        }

        String selectedItem = (String) jComboBox1.getSelectedItem();
        try {

            MaxPrice = Double.parseDouble(maxPrice);

            getSpecificAuction(selectedItem);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Bokstaver er ikke tilladt");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        mf.getCardHandler().show(MainFrame1.CREATEPRODUCT);

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel_SamletAktion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_pris;
    // End of variables declaration//GEN-END:variables
}
