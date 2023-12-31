/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.libmngmsys.librarysystem;

import java.awt.Cursor;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class loginform extends javax.swing.JFrame {

    /**
     * Creates new form loginform
     */
    Mssql_connection connectionManager = new Mssql_connection();
    Connection conn = connectionManager.establishConnection();
    
    public loginform() {
      // setUndecorated(true);
        initComponents();
        
        
        
    jLabel_singup.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabel_singup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabel_singup.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            new signupform().setVisible(true);
        }
    });
        displayImage();
    }

        public void displayImage() {
    String imagePath = "E:\\NetBeansProjects\\librarysystem\\src\\main\\java\\Image_resources\\book_logo.png"; // Replace this with the absolute path to your image

    ImageIcon imgIco = new ImageIcon(imagePath);
    Image image = imgIco.getImage().getScaledInstance(jLabel_photo.getWidth(), jLabel_photo.getHeight(), Image.SCALE_SMOOTH);

    jLabel_photo.setIcon(new ImageIcon(image));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_studid = new javax.swing.JTextField();
        jTextField_username = new javax.swing.JTextField();
        jLabel_singup = new javax.swing.JLabel();
        jLabel_photo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_login.setText("Log In");
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });

        jLabel1.setText("         Student ID");

        jLabel2.setText("          Username");

        jTextField_studid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_studidActionPerformed(evt);
            }
        });

        jLabel_singup.setText("Sign Up");
        jLabel_singup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_singupMouseClicked(evt);
            }
        });

        jLabel_photo.setText("jLabel3");

        jLabel3.setText("Don't have an account?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel_singup))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_studid, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                .addComponent(jButton_login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_username, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jTextField_studid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jTextField_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_login)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jLabel_singup)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_singupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_singupMouseClicked
        //opens the signup panel
        
        new signupform().setVisible(true);
        

    }//GEN-LAST:event_jLabel_singupMouseClicked

    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loginActionPerformed
        String studid = jTextField_studid.getText();
        String username =  jTextField_username.getText();
        
        if(studid.isEmpty()) {
            System.out.println("Error");
            JOptionPane.showMessageDialog(null, "Student ID missing", "Student ID",2);
        } else if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username is missing", "Username",2);
        } else {
            int studentid = Integer.parseInt(studid);
            try {
                String query = "SELECT usertype FROM Users WHERE studid = ? AND username = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                
                ps.setInt(1,studentid);
                ps.setString(2, username);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()) {
                    String usertype = rs.getString("usertype");
                    if(usertype.equals("Admin")) {
                        new admindbform().setVisible(true);
                    } else if(usertype.equals("User")) {
                        new userdbform().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid user type", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid ID or Username", "Error", 2);
                }
            }
            catch(SQLException ex){
                
            }
        }
        
    }//GEN-LAST:event_jButton_loginActionPerformed

    private void jTextField_studidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_studidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_studidActionPerformed

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
            java.util.logging.Logger.getLogger(loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_photo;
    private javax.swing.JLabel jLabel_singup;
    private javax.swing.JTextField jTextField_studid;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
