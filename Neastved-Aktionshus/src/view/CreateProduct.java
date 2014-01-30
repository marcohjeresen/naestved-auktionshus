/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.AuctionControl;
import control.ProductControl;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author markh_000
 */
public class CreateProduct extends javax.swing.JPanel {

    private AuctionControl ac;
    private User buyer;
    private Product product;
    private Auction akt;
    private MainFrame1 mf;
    private HovdePanel hp;
    private String picturePath;

    /**
     * Creates new form OpretProduct
     */
    public CreateProduct(AuctionControl ac, User buyer, MainFrame1 mf) {
        this.ac = ac;
        this.buyer = buyer;
        this.mf = mf;
        picturePath = "";
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
        Search search = new Search(ac.getAuctionlist());
        for (Object s : search.getProdukt()) {
            jComboBox_typer.addItem(s);
        }

    }

    public void CreateProduct(String product) {
        String title;
        String description;
        
        try {

            int estimatedPrice;
            int minimumspris;
            
            int years = Integer.parseInt(jTextField_Year.getText());
            int mothn = Integer.parseInt(jTextField_mohnt.getText()) -1;
            int day = Integer.parseInt(jTextField_date.getText());
            int time = Integer.parseInt(jTextField_hour.getText());
            int min = Integer.parseInt(jTextField_minut.getText());

            Calendar cal = Calendar.getInstance();
            cal.set(years, mothn, day, time, min);
ProductControl pc = new ProductControl();
            for (Auction auction : ac.getAuctionlist()) {
                switch (product) {
                    case "Furniture":

                        pc.setMaterials(jTextField1.getText());
                        pc.setDimensions(jTextField2.getText());
                        pc.setTitle((String) jComboBox_typer.getSelectedItem());
                        pc.setEstimatedPrice(Integer.parseInt(jTextField3.getText()));
                        minimumspris = Integer.parseInt(jTextField4.getText());
                        pc.setDescription(jTextArea1.getText());
                        pc.setPicturePath(picturePath);
                        
                        ac.createAuction(pc.createFurniture(), buyer, minimumspris, cal.getTime());
                        

                        break;
                    case "Jewellery":

                        pc.setMetal(jTextField1.getText());
                        pc.setGemstone(jTextField2.getText());
                        pc.setStamp(jTextField3.getText());
                        pc.setTitle((String) jComboBox_typer.getSelectedItem());
                        pc.setDescription(jTextArea1.getText());
                        pc.setEstimatedPrice(Integer.parseInt(jTextField4.getText()));
                        minimumspris = Integer.parseInt(jTextField5.getText());
                        pc.setPicturePath(picturePath);

                        
                        ac.createAuction(pc.createJewellery(), buyer, minimumspris, cal.getTime());

                        break;
                    case "Painting":

                        pc.setArtist(jTextField1.getText());
                        pc.setYear(Integer.parseInt(jTextField2.getText()));
                        pc.setStyle(jTextField3.getText());
                        pc.setSize(jTextField4.getText());
                        title = (String) jComboBox_typer.getSelectedItem();
                        pc.setDescription(jTextArea1.getText());
                        pc.setEstimatedPrice(Integer.parseInt(jTextField5.getText()));
                        minimumspris = Integer.parseInt(jTextField6.getText());
                        pc.setPicturePath(picturePath);

                        
                        ac.createAuction(pc.createPainting(), buyer, minimumspris, cal.getTime());

                        break;
                    case "Wine":

                        pc.setManufacturer(jTextField1.getText());
                        pc.setCountry(jTextField2.getText()); 
                        pc.setYearOfProduction(Integer.parseInt(jTextField3.getText())); 
                        pc.setGrapes(jTextField4.getText());
                        pc.setPercent(Double.parseDouble(jTextField5.getText())); 
                        pc.setBottleSize(Double.parseDouble(jTextField6.getText())); 
                        pc.setQuantity(Integer.parseInt(jTextField7.getText()));
                        title = (String) jComboBox_typer.getSelectedItem();
                        pc.setDescription(jTextArea1.getText());
                        pc.setEstimatedPrice(Integer.parseInt(jTextField8.getText()));
                        minimumspris = Integer.parseInt(jTextField9.getText());
                        pc.setPicturePath(picturePath);

                        
                        ac.createAuction(pc.createWine(), buyer, minimumspris, cal.getTime());
                        break;
                }
            }
            akt.updateList();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dato, Tid, Pris, og procenter kan ikke være bogstaver" + ex.getLocalizedMessage());
            ex.getLocalizedMessage();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Year = new javax.swing.JTextField();
        jTextField_mohnt = new javax.swing.JTextField();
        jTextField_date = new javax.swing.JTextField();
        jTextField_minut = new javax.swing.JTextField();
        jTextField_hour = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton_tilføj = new javax.swing.JButton();

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

        jLabel1.setText("Dato: fks. 2014-11-23.");

        jLabel2.setText("Kl: fks. 21,44");

        jTextField_Year.setText("YYYY");
        jTextField_Year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_YearActionPerformed(evt);
            }
        });

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

        jButton_tilføj.setText("Tilføj billed");
        jButton_tilføj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tilføjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToggleButton_tilbage, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton_OpretAuction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox_typer, 0, 129, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(jButton_Chose, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton_tilføj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jButton_tilføj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_OpretAuction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton_tilbage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setTextfeid();
       
        
    }//GEN-LAST:event_jToggleButton_tilbageActionPerformed

    private void jTextField_hourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_hourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_hourActionPerformed

    private void jButton_tilføjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tilføjActionPerformed
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            picturePath = jfc.getSelectedFile().getAbsolutePath();
            
        }
    }//GEN-LAST:event_jButton_tilføjActionPerformed

    private void jTextField_YearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_YearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_YearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Chose;
    private javax.swing.JButton jButton_OpretAuction;
    private javax.swing.JButton jButton_tilføj;
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
    private javax.swing.JToggleButton jToggleButton_tilbage;
    // End of variables declaration//GEN-END:variables
}
