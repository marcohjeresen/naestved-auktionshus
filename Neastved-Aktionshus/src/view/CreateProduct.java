/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.*;

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

    public void setCreateProduct(Product product) {
        String title;
        double estimatedPrice;
        String description;
        String picturePath;
        double minimumspris;
        minimumspris = Double.parseDouble(jTextField9.getText());
        

        Calendar cal = Calendar.getInstance();
        cal.set(2014, 00, 21, 10, 04);

        if (product instanceof Furniture) {
            String matrialer = jTextField1.getText();
            String dimensions = jTextField2.getText();
            title = (String) jComboBox_typer.getSelectedItem();
            estimatedPrice = Double.parseDouble(jTextField3.getText());
            description = jTextArea1.getText();
            picturePath = "";
            Furniture f = new Furniture(matrialer, dimensions, title, description, estimatedPrice, picturePath);
            Auction auk = new Auction(f, buyer, minimumspris, cal.getTime());
            auctionsListe.add(auk);

        } else if (product instanceof Jewellery) {

            String metal = jTextField1.getText();
            String gemstone = jTextField2.getText();
            String stamp = jTextField3.getText();
            title = (String) jComboBox_typer.getSelectedItem();
            description = jTextArea1.getText();
            estimatedPrice = Double.parseDouble(jTextField4.getText());
            picturePath = "";

            Jewellery s = new Jewellery(metal, gemstone, stamp, title, description, estimatedPrice, picturePath);
            Auction auk = new Auction(s, buyer, minimumspris, cal.getTime());
            auctionsListe.add(auk);

        } else if (product instanceof Wine) {
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
            picturePath = "";

            Wine v = new Wine(manufacturer, country, yearOfProduction, grapes, percent, bottleSize, quantity, title, description, estimatedPrice, picturePath);
            Auction auk = new Auction(v, buyer, minimumspris, cal.getTime());
            auctionsListe.add(auk);

        } else if (product instanceof Painting) {

            String artist = jTextField1.getText();
            int year = Integer.parseInt(jTextField2.getText());
            String style = jTextField3.getText();
            String size = jTextField4.getText();
            title = (String) jComboBox_typer.getSelectedItem();
            description = jTextArea1.getText();
            estimatedPrice = Double.parseDouble(jTextField5.getText());
            picturePath = "";

            Painting b = new Painting(artist, year, style, size, title, description, estimatedPrice, picturePath);
            Auction auk = new Auction(b, buyer, minimumspris, cal.getTime());
            auctionsListe.add(auk);

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
        jComboBox_YYY = new javax.swing.JComboBox();
        jComboBox_MM = new javax.swing.JComboBox();
        jComboBox_DD = new javax.swing.JComboBox();
        jComboBox_TT = new javax.swing.JComboBox();
        jComboBox_Minut = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        jComboBox_YYY.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_MM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_DD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_TT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_Minut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("YY-MM-DD");

        jLabel2.setText("Time-Minut");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_typer, 0, 129, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Chose, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jButton_OpretAuction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton_tilbage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6)
                    .addComponent(jTextField7)
                    .addComponent(jTextField8)
                    .addComponent(jTextField9)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jComboBox_TT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Minut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox_YYY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_MM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_DD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(146, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_YYY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_MM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_DD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_TT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Minut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_OpretAuction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton_tilbage)
                .addContainerGap(26, Short.MAX_VALUE))
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
//        try {
//            getSpecificAuction(selectedItem);
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
//        }
    }//GEN-LAST:event_jButton_OpretAuctionActionPerformed

    private void jToggleButton_tilbageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_tilbageActionPerformed
        mf.getCardHandler().show(MainFrame1.HOVEDPANEL);
    }//GEN-LAST:event_jToggleButton_tilbageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Chose;
    private javax.swing.JButton jButton_OpretAuction;
    private javax.swing.JComboBox jComboBox_DD;
    private javax.swing.JComboBox jComboBox_MM;
    private javax.swing.JComboBox jComboBox_Minut;
    private javax.swing.JComboBox jComboBox_TT;
    private javax.swing.JComboBox jComboBox_YYY;
    private javax.swing.JComboBox jComboBox_typer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton_tilbage;
    // End of variables declaration//GEN-END:variables
}
