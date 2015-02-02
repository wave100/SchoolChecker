/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolCheckerUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rish Shadra
 */
public class SchoolChecker extends javax.swing.JFrame implements Runnable {

    String town = "";
    String URL = "";
    Settings s = new Settings();

    /**
     * Creates new form SchoolCheckerUI
     */
    @Override
    public void run() {
        while (true) {
            try {
                String s = Checker.check(town, URL);
                lblStatus.setText(s);
                if (s.equalsIgnoreCase("closed")) {
                    this.requestFocus();
                }
                System.out.println("Fetching new data");
            } catch (IOException ex) {
                Logger.getLogger(SchoolChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SchoolChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public SchoolChecker() {
        initComponents();
        this.setTitle("School Closings");
        this.setResizable(false);

        if (!s.isFirstRun) {
            fieldTownName.setText(s.getConfigTown());
            fieldCheckingURL.setText(s.getConfigURL());
        }
        System.out.println(fieldCheckingURL.getText());
        if (fieldCheckingURL.getText().isEmpty()) {
            fieldTownName.setText("Town");
            fieldTownName.setEnabled(false);
            System.out.println("Graying out town field");
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

        lblStatus = new javax.swing.JLabel();
        btnSetTown = new javax.swing.JButton();
        fieldTownName = new javax.swing.JTextField();
        spr1 = new javax.swing.JSeparator();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        fieldCheckingURL = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        lblStatus.setText("Town Not Set");

        btnSetTown.setText("Set Town");
        btnSetTown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetTownActionPerformed(evt);
            }
        });

        fieldTownName.setText("Town");
        fieldTownName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTownNameActionPerformed(evt);
            }
        });

        spr1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel1.setText("URL");
        jLabel1.setToolTipText("The URL of your state's closings list");

        fieldCheckingURL.setToolTipText("");
        fieldCheckingURL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldCheckingURLFocusLost(evt);
            }
        });
        fieldCheckingURL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldCheckingURLKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSetTown)
                            .addComponent(fieldTownName, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spr1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus)
                            .addComponent(btnRefresh)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldCheckingURL)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus)
                            .addComponent(fieldTownName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSetTown)
                            .addComponent(btnRefresh)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spr1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldCheckingURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetTownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetTownActionPerformed
        try {
            // TODO add your handling code here:
            town = fieldTownName.getText();
            s.setConfigTown(fieldTownName.getText());
            lblStatus.setText(Checker.check(town, URL));
            //jButton1.setVisible(false);
            //jTextField1.setVisible(false);
            Thread t = new Thread(this);
            t.start();

            /*while(true) {
             System.out.println("Refreshing...");
             jLabel1.setText(Checker.check(jTextField1.getText()));
             try {
             Thread.sleep(60000);
             } catch (InterruptedException ex) {
             Logger.getLogger(SchoolCheckerUI.class.getName()).log(Level.SEVERE, null, ex);
             }
             }*/
        } catch (IOException ex) {
            Logger.getLogger(SchoolChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSetTownActionPerformed


    private void fieldTownNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTownNameActionPerformed
        // TODO Make this update town, update properties file if when focus lost
    }//GEN-LAST:event_fieldTownNameActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            // TODO add your handling code here:
            lblStatus.setText(Checker.check(town, URL));
        } catch (IOException ex) {
            Logger.getLogger(SchoolChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void fieldCheckingURLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCheckingURLFocusLost
        if (fieldCheckingURL.equals(null) || fieldCheckingURL.equals("")) {
            fieldTownName.setEnabled(false);
        } else {
            fieldTownName.setEnabled(true);
            URL = fieldCheckingURL.getText();
            s.setConfigURL(fieldCheckingURL.getText());
            try {
                Checker.check(town, URL);
            } catch (IOException ex) {
                System.out.println("Invalid URL entered: " + URL);
            }
        }
    }//GEN-LAST:event_fieldCheckingURLFocusLost

    private void fieldCheckingURLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCheckingURLKeyTyped
        if (fieldCheckingURL.equals(null) || fieldCheckingURL.equals("")) {
            fieldTownName.setEnabled(false);
        } else {
            fieldTownName.setEnabled(true);
        }
    }//GEN-LAST:event_fieldCheckingURLKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchoolChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchoolChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchoolChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchoolChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchoolChecker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSetTown;
    private javax.swing.JTextField fieldCheckingURL;
    private javax.swing.JTextField fieldTownName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JSeparator spr1;
    // End of variables declaration//GEN-END:variables
}
