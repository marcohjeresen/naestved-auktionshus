/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import model.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author markh_000
 */
public class AuctionSide extends javax.swing.JFrame {

    private Product product;
    private Auction akt;
    private User user;
    private int størrelse;

    /**
     * Creates new form AuctionSide
     */
    public AuctionSide(Auction akt, User user) {
        initComponents();
        this.akt = akt;
        product = akt.getProduct();
        this.user = user;
        størrelse = 5;

        fillLabels();
        updateBid();

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
        jLabel2.setText("Title: " + product.getTitle());
        String ntime = dateFormat(akt.getTime());
        jLabel1_Sluttidspunkt.setText("Ends: " + ntime);
        jLabel_Estimere.setText("Estimated Value: " + product.getEstimatedPrice());

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
        størrelse = akt.getBidingHistory().size() - 5;
        jTextArea1.setText("");
        if (akt.getBidingHistory().size() == 0) {
            jTextArea1.append("Start bud: " + akt.getLatestBid());
        } else if (akt.getBidingHistory().size() <= 5) {
            for (int i = 0; i < akt.getBidingHistory().size(); i++) {
                jTextArea1.append("Der er bud:  " + akt.getBidingHistory().get(i).getAmount() + "  Af bruger:  " + akt.getBidingHistory().get(i).getUser().getName() + "\n");
            }
        } else if (akt.getBidingHistory().size() > 5) {
            for (int i = størrelse; i < akt.getBidingHistory().size(); i++) {
                jTextArea1.append("Der er bud:  " + akt.getBidingHistory().get(i).getAmount() + "  Af bruger:  " + akt.getBidingHistory().get(i).getUser().getName() + "\n");
            }
        }
    }

    private String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM-YYYY HH:mm");
        String str = sdf.format(date);
        return str;
    }

    public void updateBid() {
        final java.util.Timer timer;
        timer = new java.util.Timer(true);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                setLatestBid();
            }

        }, 100, 100);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel_Estimere = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton_byd = new javax.swing.JButton();
        jLabel_sælger = new javax.swing.JLabel();
        jLabel1_Sluttidspunkt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 200));
        jLabel1.setRequestFocusEnabled(false);

        jLabel2.setText("Title");

        jLabel3.setText("Desciption");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel_Estimere.setText("jLabel11");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton_byd.setText("Byd 100 Kr.");
        jButton_byd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_bydActionPerformed(evt);
            }
        });

        jLabel_sælger.setText("Sælger:");

        jLabel1_Sluttidspunkt.setText("Sluttidspunkt:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194))
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
                            .addComponent(jLabel1_Sluttidspunkt, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_byd)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_sælger)
                    .addComponent(jLabel1_Sluttidspunkt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(jLabel10))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Estimere)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_byd)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_bydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_bydActionPerformed
        try {
            double latesbid = akt.getLatestBid();
            latesbid += 100;
            akt.setLatesBid(new Bid(user, Calendar.getInstance().getTime(), latesbid));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
        }

    }//GEN-LAST:event_jButton_bydActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_byd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private AuctionSide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}