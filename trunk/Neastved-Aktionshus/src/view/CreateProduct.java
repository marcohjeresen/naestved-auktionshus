/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.*;
import utility.CardHandler;
import view.*;

/**
 *
 * @author markh_000
 */
public class CreateProduct extends javax.swing.JPanel {

    private ArrayList<Auction> auctionsListe;
    private User buyer;
    private Product product;
    private Auction akt;
    private MainFrame1 mf;
    private HovdePanel hp;

    /**
     * Creates new form OpretProduct
     */
    public CreateProduct(ArrayList<Auction> auctionsListe, User buyer, MainFrame1 mf) {
        this.auctionsListe = auctionsListe;
        this.buyer = buyer;
        this.mf = mf;
        initComponents();

        startCreate();

    }

    public void startCreate() {
        jLabel_User.setText("Bruger: " + buyer.getName());

        setJcombobox();
        removeTextfeild();

    }

    private void removeTextfeild() {
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
        jTextField6.setVisible(false);
        jTextField7.setVisible(false);
        jTextField8.setVisible(false);
        jTextField9.setVisible(false);

        if (jComboBox_typer.getSelectedItem() == "Painting") {
            jTextField1.setVisible(true);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);
            jTextField6.setVisible(true);

        } else if (jComboBox_typer.getSelectedItem() == "Furniture") {
            jTextField1.setVisible(true);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);

        } else if (jComboBox_typer.getSelectedItem() == "Jewellery") {

            jTextField1.setVisible(true);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);

        } else if (jComboBox_typer.getSelectedItem() == "Wine") {

            jTextField1.setVisible(true);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);
            jTextField6.setVisible(true);
            jTextField7.setVisible(true);
            jTextField8.setVisible(true);
            jTextField9.setVisible(true);

        }
        setTextfeid();
    }

    private void setTextfeid() {

        if (jComboBox_typer.getSelectedItem() == "Painting") {
            jTextField1.setText("Artist: ");
            jTextField2.setText("Year: ");
            jTextField3.setText("Stilart: ");
            jTextField4.setText("Størrelse: ");
            jTextField5.setText("Vudered Pris: ");
            jTextField6.setText("Minimumspris: ");
            jTextArea1.setText("Beskrivelse: ");

        } else if (jComboBox_typer.getSelectedItem() == "Wine") {

            jTextField1.setText("Producent: ");
            jTextField2.setText("Land: ");
            jTextField3.setText("Year: ");
            jTextField4.setText("Druer: ");
            jTextField5.setText("Procent: ");
            jTextField6.setText("Bottle Size: L.");
            jTextField7.setText("Quantity: ");
            jTextField8.setText("Vudered Pris: ");
            jTextField9.setText("Minimumspris: ");
            jTextArea1.setText("Beskrivelse: ");
        } else if (jComboBox_typer.getSelectedItem() == "Jewellery") {

            jTextField1.setText("Metal: ");
            jTextField2.setText("Ædelsten: ");
            jTextField3.setText("Stempel: ");
            jTextField4.setText("Vudered Pris: ");
            jTextField5.setText("Minimumspris: ");
            jTextArea1.setText("Beskrivelse: ");

        } else if (jComboBox_typer.getSelectedItem() == "Furniture") {

            jTextField1.setText("Matrialer: ");
            jTextField2.setText("Dimensioner: ");
            jTextField3.setText("Vudered Pris: ");
            jTextField4.setText("Minimumspris: ");
            jTextArea1.setText("Beskrivelse: ");
        }
        updateUI();

    }

    private void setJcombobox() {
        jComboBox_typer.removeAllItems();
        Search search = new Search(auctionsListe);
        for (Object s : search.getProdukt()) {
            jComboBox_typer.addItem(s);
        }

    }

    public void CreateProduct(String product) {
        String title;
        String description;
        String picturePath;
        try {

            double estimatedPrice;
            double minimumspris;
            
            int years = Integer.parseInt(jTextField_Year.getText());
            int mothn = Integer.parseInt(jTextField_mohnt.getText());
            int day = Integer.parseInt(jTextField_date.getText());
            int time = Integer.parseInt(jTextField_hour.getText());
            int min = Integer.parseInt(jTextField_minut.getText());

            Calendar cal = Calendar.getInstance();
            cal.set(years, mothn, day, time, min);

            for (Auction auction : auctionsListe) {
                switch (product) {
                    case "Furniture":

                        String matrialer = jTextField1.getText();
                        String dimensions = jTextField2.getText();
                        title = (String) jComboBox_typer.getSelectedItem();
                        estimatedPrice = Double.parseDouble(jTextField3.getText());
                        minimumspris = Double.parseDouble(jTextField4.getText());
                        description = jTextArea1.getText();
                        picturePath = "";
                        Furniture f = new Furniture(matrialer, dimensions, title, description, estimatedPrice, picturePath);
                        auction = new Auction(f, buyer, minimumspris, cal.getTime());
                        auctionsListe.add(auction);

                        break;
                    case "Jewellery":

                        String metal = jTextField1.getText();
                        String gemstone = jTextField2.getText();
                        String stamp = jTextField3.getText();
                        title = (String) jComboBox_typer.getSelectedItem();
                        description = jTextArea1.getText();
                        estimatedPrice = Double.parseDouble(jTextField4.getText());
                        minimumspris = Double.parseDouble(jTextField5.getText());
                        picturePath = "";

                        Jewellery s = new Jewellery(metal, gemstone, stamp, title, description, estimatedPrice, picturePath);
                        auction = new Auction(s, buyer, minimumspris, cal.getTime());
                        auctionsListe.add(auction);

                        break;
                    case "Painting":

                        String artist = jTextField1.getText();
                        int year = Integer.parseInt(jTextField2.getText());
                        String style = jTextField3.getText();
                        String size = jTextField4.getText();
                        title = (String) jComboBox_typer.getSelectedItem();
                        description = jTextArea1.getText();
                        estimatedPrice = Double.parseDouble(jTextField5.getText());
                        minimumspris = Double.parseDouble(jTextField6.getText());
                        picturePath = "";

                        Painting b = new Painting(artist, year, style, size, title, description, estimatedPrice, picturePath);
                        auction = new Auction(b, buyer, minimumspris, cal.getTime());
                        auctionsListe.add(auction);

                        break;
                    case "Wine":

                        String manufacturer = jTextField1.getText();
                        String country = jTextField2.getText();
                        double yearOfProduction = Double.parseDouble(jTextField3.getText());
                        String grapes = jTextField4.getText();
                        double percent = Double.parseDouble(jTextField5.getText());
                        double bottleSize = Double.parseDouble(jTextField6.getText());
                        int quantity = Integer.parseInt(jTextField7.getText());
                        title = (String) jComboBox_typer.getSelectedItem();
                        description = jTextArea1.getText();
                        estimatedPrice = Double.parseDouble(jTextField8.getText());
                        minimumspris = Double.parseDouble(jTextField9.getText());
                        picturePath = "";

                        Wine v = new Wine(manufacturer, country, yearOfProduction, grapes, percent, bottleSize, quantity, title, description, estimatedPrice, picturePath);
                        auction = new Auction(v, buyer, minimumspris, cal.getTime());
                        auctionsListe.add(auction);

                        break;
                }
            }
            akt.updateList();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dato, Tid, Pris, og procenter kan ikke være bogstaver");
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

        jComboBox_typer = new javax.swing.JComboBox();
        jButton_Chose = new javax.swing.JButton();
        jLabel_User = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton_OpretAuction = new javax.swing.JButton();
        jToggleButton_tilbage = new javax.swing.JToggleButton();
        jTextField9 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Year = new javax.swing.JTextField();
        jTextField_mohnt = new javax.swing.JTextField();
        jTextField_date = new javax.swing.JTextField();
        jTextField_minut = new javax.swing.JTextField();
        jTextField_hour = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jComboBox_typer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_typer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_typerActionPerformed(evt);
            }
        });

        jButton_Chose.setText("Vælg");
        jButton_Chose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChoseActionPerformed(evt);
            }
        });

        jLabel_User.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_User.setText("Bruger");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jTextField7.setText("jTextField7");

        jTextField8.setText("jTextField8");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton_OpretAuction.setText("Opret Auction");
        jButton_OpretAuction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OpretAuctionActionPerformed(evt);
            }
        });

        jToggleButton_tilbage.setText("Tilbage");
        jToggleButton_tilbage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_tilbageActionPerformed(evt);
            }
        });

        jTextField9.setText("jTextField9");

        jToggleButton1.setText("Tilføj Billed");

        jLabel1.setText("Dato: fks. 2014-11-23.");

        jLabel2.setText("Kl: fks. 21,44");

        jTextField_Year.setText("9999");

        jTextField_mohnt.setText("MM");

        jTextField_date.setText("DD");

        jTextField_minut.setText("Min");

        jTextField_hour.setText("24");
        jTextField_hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_hourActionPerformed(evt);
            }
        });

        jLabel3.setText("Auctionens udløbnings dag/tid");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox_typer, 0, 129, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(jButton_Chose, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton_OpretAuction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton_tilbage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField_Year, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField_mohnt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField_date, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1))
                            .addGap(58, 58, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField_minut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_User, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_typer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Chose))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_mohnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_minut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_OpretAuction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton_tilbage)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_typerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_typerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_typerActionPerformed

    private void jButton_ChoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChoseActionPerformed
        removeTextfeild();

    }//GEN-LAST:event_jButton_ChoseActionPerformed

    private void jButton_OpretAuctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OpretAuctionActionPerformed
        String selectedItem = (String) jComboBox_typer.getSelectedItem();
        try {
            CreateProduct(selectedItem);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Auction oprettet. ");
        }
    }//GEN-LAST:event_jButton_OpretAuctionActionPerformed

    private void jToggleButton_tilbageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_tilbageActionPerformed
        mf.getCardHandler().show(MainFrame1.HOVEDPANEL);
        hp.update();
    }//GEN-LAST:event_jToggleButton_tilbageActionPerformed

    private void jTextField_hourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_hourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_hourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Chose;
    private javax.swing.JButton jButton_OpretAuction;
    private javax.swing.JComboBox jComboBox_typer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_User;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField_Year;
    private javax.swing.JTextField jTextField_date;
    private javax.swing.JTextField jTextField_hour;
    private javax.swing.JTextField jTextField_minut;
    private javax.swing.JTextField jTextField_mohnt;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton_tilbage;
    // End of variables declaration//GEN-END:variables
}
