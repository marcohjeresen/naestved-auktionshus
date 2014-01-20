/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.*;

/**
 *
 * @author markh_000
 */
public class AuctionPanel extends javax.swing.JPanel {
    private Auction akt;
    private Product product;
    private MainFrame mf;

    /**
     * Creates new form AuctionPanel
     */
    public AuctionPanel(Auction akt, MainFrame mf) {
        
        initComponents();
        this.akt = akt;
        this.mf = mf;
        product = akt.getProduct();
        this.setSize(535, 138);
        fillLabels();
        
    }
    
    private void removeLabels(){
        if (product instanceof Painting) {
            jLabel_flaksestøøresle.setVisible(false);
            
        }else if(product instanceof Furniture || product instanceof Jewellery ){
            jLabel_Artist.setVisible(false);
            jLabel_flaksestøøresle.setVisible(false);
            jLabel_year.setVisible(false);
            
        }
        
    }
    private void fillLabels(){
        removeLabels();
        setLatestBid();
        jLabel_Titel.setText("Title: " + product.getTitle());
        String ntime = dateFormat(akt.getTime());
        jLabel_Ends.setText("Ends: " + ntime);
        jLabel_Estimere.setText("Estimated Value: "+ product.getEstimatedPrice());
        if (product instanceof Painting) {
            Painting p = (Painting)product;
            jLabel_Artist.setText("Artist: "+ p.getArtist());
            jLabel_year.setText("Year: "+ p.getYear());
            
         
        }else if(product instanceof Wine){
            Wine w = (Wine)product;
            jLabel_Artist.setText("Quantity: " + w.getQuantity());
            jLabel_flaksestøøresle.setText("Bottle Size: "+ w.getBottleSize() + "L.");
            jLabel_year.setText("Year: "+ w.getYearOfProduction());
            
        }
        
        
    }
    public void setLatestBid(){
        jLabel_sisdtebud.setText("Latest Bid: "+ akt.getLatestBid());
    }
    
    private String dateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM-YYYY HH:mm");
        String str = sdf.format(date);
        return str;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Titel = new javax.swing.JLabel();
        jLabel_Ends = new javax.swing.JLabel();
        jLabel_Artist = new javax.swing.JLabel();
        jLabel_year = new javax.swing.JLabel();
        jLabel_Estimere = new javax.swing.JLabel();
        jLabel_sisdtebud = new javax.swing.JLabel();
        jLabel_flaksestøøresle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel6.setText("jLabel6");

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Auction");

        jLabel_Titel.setText("Titel: Auction");

        jLabel_Ends.setText("Ends: 23987532875285235");

        jLabel_Artist.setText("Artist: jens andersen");

        jLabel_year.setText("Year: 4567");

        jLabel_Estimere.setText("Estimeret værdi: 1500000");

        jLabel_sisdtebud.setText("Sidste bud: 9000000000");

        jLabel_flaksestøøresle.setText("Flaskestørrelse: 4435");

        jButton1.setText("Enter Auction");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_year)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Ends, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Artist)
                            .addComponent(jLabel_Titel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_flaksestøøresle)
                            .addComponent(jLabel_sisdtebud)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Estimere)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Titel)
                    .addComponent(jLabel_Estimere)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Ends)
                    .addComponent(jLabel_sisdtebud))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Artist)
                    .addComponent(jLabel_flaksestøøresle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_year)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AuctionSide as = new AuctionSide(akt , mf.getBuyer());
        as.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Artist;
    private javax.swing.JLabel jLabel_Ends;
    private javax.swing.JLabel jLabel_Estimere;
    private javax.swing.JLabel jLabel_Titel;
    private javax.swing.JLabel jLabel_flaksestøøresle;
    private javax.swing.JLabel jLabel_sisdtebud;
    private javax.swing.JLabel jLabel_year;
    // End of variables declaration//GEN-END:variables
}
