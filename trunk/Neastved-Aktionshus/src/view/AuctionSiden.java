/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Auction;
import model.Bid;
import model.Furniture;
import model.Jewellery;
import model.Painting;
import model.Product;
import model.User;
import model.Wine;

/**
 *
 * @author markh_000
 */
public class AuctionSiden extends javax.swing.JPanel {

    private Product product;
    private Auction akt;
    private User user;
    private int size;
    private MainFrame1 mf;

    /**
     * Creates new form AuctionSide
     */
    public AuctionSiden(User user, MainFrame1 mf) {
        initComponents();
        this.mf = mf;
        this.user = user;
        setSize(new Dimension(600, 500));
    }

    public void startAuction(Auction akt) {
        this.akt = akt;
        product = akt.getProduct();
        size = 5;
        fillLabels();
    }

    private void removeLabels() {
        if (product instanceof Painting) {
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);

        } else if (product instanceof Furniture) {
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);

        } else if (product instanceof Jewellery) {
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);
        }
    }

    private void fillLabels() {
        removeLabels();
        setLatestBid();
        jLabel_sælger.setText("Sælger: " + akt.getUser().getName());
        jLabel_sælgerAdresse.setText("Adresse: " + akt.getUser().getAddress());
        jLabel_sælgerNummer.setText("Nummer: " + akt.getUser().getPhoneNumber());
        jLabel2.setText("Title: " + product.getTitle());
        String ntime = dateFormat(akt.getTime());
        jLabel1_Sluttidspunkt.setText("Ends: " + ntime);
        jLabel_Estimere.setText("Estimated Value: " + product.getEstimatedPrice());
        jLabel11.setText("Man skal byde 50 Kr. eller mere over det nuværende bud:");

        Image img = (new ImageIcon(product.getPicturePath())).getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), 0);
        ImageIcon icon = new ImageIcon(img);

        if (icon.getIconHeight() < icon.getIconWidth()) {
            img = (new ImageIcon(product.getPicturePath())).getImage().getScaledInstance(-1, jLabel1.getHeight(), 0);
            icon = new ImageIcon(img);
            jLabel1.setIcon(icon);

        } else {
            img = (new ImageIcon(product.getPicturePath())).getImage().getScaledInstance(jLabel1.getWidth(), -1, 0);
            icon = new ImageIcon(img);
            jLabel1.setIcon(icon);
        }

        if (product instanceof Painting) {
            Painting p = (Painting) product;
            jLabel3.setText("Artist: " + p.getArtist());
            jLabel4.setText("Year: " + p.getYear());
            jLabel5.setText("Stilart: " + p.getStyle());
            jLabel6.setText("Størrelse: " + p.getSize());
            jLabel7.setText("Beskrivelse: " + p.getDescription());

        } else if (product instanceof Wine) {
            Wine w = (Wine) product;

            jLabel2.setText("Navn: " + w.getTitle());
            jLabel3.setText("Producent: " + w.getManufacturer());
            jLabel4.setText("Land: " + w.getCountry());
            jLabel5.setText("Year: " + w.getYearOfProduction());
            jLabel6.setText("Druer: " + w.getGrapes());
            jLabel7.setText("Procent: " + w.getPercent());
            jLabel8.setText("Bottle Size: " + w.getBottleSize() + "L.");
            jLabel9.setText("Quantity: " + w.getQuantity());
            jLabel10.setText("Beskrivelse: " + w.getDescription());

        } else if (product instanceof Jewellery) {

            Jewellery j = (Jewellery) product;

            jLabel2.setText("Navn: " + j.getTitle());
            jLabel3.setText("Metal: " + j.getMetal());
            jLabel4.setText("Ædelsten: " + j.getGemstone());
            jLabel5.setText("Stempel: " + j.getStamp());
            jLabel6.setText("Beskrivelse: " + j.getDescription());

        } else if (product instanceof Furniture) {
            Furniture f = (Furniture) product;

            jLabel2.setText("Navn: " + f.getTitle());
            jLabel3.setText("Matrialer: " + f.getMaterials());
            jLabel4.setText("Dimensioner: " + f.getDimensions());
            jLabel5.setText("Beskrivelse: " + f.getDescription());
        }
    }

    public void setLatestBid() {
        size = akt.getBidingHistory().size() - 5;
        jTextArea1.setText("");
        if (akt.getBidingHistory().isEmpty()) {
            jTextArea1.append("Start bud: " + akt.getLatestBid());
        } else if (akt.getBidingHistory().size() <= 5) {
            for (int i = 0; i < akt.getBidingHistory().size(); i++) {
                jTextArea1.append("Der er bud:  " + akt.getBidingHistory().get(i).getAmount() + "  Af bruger:  " + akt.getBidingHistory().get(i).getUser().getName() + "\n");
            }
        } else if (akt.getBidingHistory().size() > 5) {
            for (int i = size; i < akt.getBidingHistory().size(); i++) {
                jTextArea1.append("Der er bud:  " + akt.getBidingHistory().get(i).getAmount() + "  Af bruger:  " + akt.getBidingHistory().get(i).getUser().getName() + "\n");
            }
        }
    }

    private String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM-YYYY HH:mm");
        String str = sdf.format(date);
        return str;
    }

//    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1_Sluttidspunkt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_sælger = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Estimere = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton_byd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel_sælgerAdresse = new javax.swing.JLabel();
        jLabel_sælgerNummer = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel9.setText("jLabel9");

        jLabel8.setText("jLabel8");

        jLabel5.setText("jLabel5");

        jLabel4.setText("jLabel4");

        jLabel1_Sluttidspunkt.setText("Sluttidspunkt:");

        jLabel7.setText("jLabel7");

        jLabel_sælger.setText("Sælger: kurt hansen jensen");

        jLabel6.setText("jLabel6");

        jLabel3.setText("Desciption");

        jLabel2.setText("Title");

        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 200));
        jLabel1.setRequestFocusEnabled(false);

        jLabel_Estimere.setText("jLabel_Estimere");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton_byd.setText("Byd");
        jButton_byd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_bydActionPerformed(evt);
            }
        });

        jLabel10.setText("jLabel10");

        jButton1.setText("Tilbage");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel_sælgerAdresse.setText("Adresse: parkvej 170 4700 næstved");

        jLabel_sælgerNummer.setText("Nummer: 24 24 24 24 ");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel11.setText("jLabel11");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel_Estimere, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_sælger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1_Sluttidspunkt, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton_byd)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_sælgerAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_sælgerNummer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_sælger)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_sælgerAdresse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_sælgerNummer)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1_Sluttidspunkt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)))
                .addGap(31, 31, 31)
                .addComponent(jLabel_Estimere)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_byd)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_bydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_bydActionPerformed
        try {
            int bid = Integer.parseInt(jTextField1.getText());
            int currentBid = (int) akt.getLatestBid();
            if (bid >= 50 + currentBid) {
                akt.setLatesBid(new Bid(user, Calendar.getInstance().getTime(), bid));
                mf.notifyListeners("New Bid");
            } else {
                JOptionPane.showMessageDialog(this, "Buddet er for lavt. Fedterøv!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ikke bogstaver");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButton_bydActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mf.getCardHandler().show(MainFrame1.HOVEDPANEL);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_byd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel1_Sluttidspunkt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Estimere;
    private javax.swing.JLabel jLabel_sælger;
    private javax.swing.JLabel jLabel_sælgerAdresse;
    private javax.swing.JLabel jLabel_sælgerNummer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
