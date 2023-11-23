/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.libmngmsys.librarysystem;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class userdbform extends javax.swing.JFrame {

    /**
     * Creates new form userdbform
     */
    com.libmngmsys.librarysystem.Books books = new com.libmngmsys.librarysystem.Books();
    
    Mssql_connection connectionManager = new Mssql_connection();
    Connection conn = connectionManager.establishConnection();
    
    private static final int columnIndexForFilename = 5;
    
    public userdbform() {
        initComponents();
        
       populateJtablewithBooks();
       
       //display image
jTable_books.getSelectionModel().addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting()) {
        int selectedRow = jTable_books.getSelectedRow();
        if (selectedRow != -1) {
            // Get the filename from the bookList based on the selected row
            String filename = books.bookListuser().get(selectedRow).getFilename();

            // Assuming you have the file path available
            String imagePathForSelectedRow = "E:\\NetBeansProjects\\librarysystem\\src\\main\\java\\Image_resources\\" + filename;

            // Display the image based on the new file path
            displayImage(imagePathForSelectedRow);
        }
    }
});  
//        jTable_books.getSelectionModel().addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting()) {
//                int selectedRow = jTable_books.getSelectedRow();
//                if (selectedRow != -1) {
//                    // Get the filename from the selected row in the table model
//                    String filename = jTable_books.getValueAt(selectedRow, columnIndexForFilename).toString();
//
//                    // Assuming you have the file path available
//                    String imagePathForSelectedRow = "E:\\NetBeansProjects\\librarysystem\\src\\main\\java\\Image_resources\\" + filename;
//
//
//                    // Display the image based on the new file path
//                    displayImage(imagePathForSelectedRow);
//                }
//            }
//        });
    }
    
    public void displayImage(String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon ImgIco = new ImageIcon(imagePath);
            Image image = ImgIco.getImage().getScaledInstance(jLabel2_photo.getWidth(), jLabel2_photo.getHeight(), Image.SCALE_SMOOTH);    
            jLabel2_photo.setIcon(new ImageIcon(image));
        } else {
            System.out.println("Invalid Image path");
        }

        
       
    }
    private void populateJtablewithBooks() {
        ArrayList<com.libmngmsys.librarysystem.Books> bookList = books.bookListuser();
        
        //jtablecolumns
        String[] colNames = {"ID", "bookname", "Main Class", "Sub Class", "Location"};
        
       DefaultTableModel model = new DefaultTableModel(colNames, 0); // Initialize model without data
        //row
     for (com.libmngmsys.librarysystem.Books book : bookList) {
        Object[] row = {
            book.getId(),
            book.getBookname(),
            book.getMainclass(),
            book.getSubclass(),
            book.getLocation(),
            //book.getFilename()
        };
        model.addRow(row);
    }

    jTable_books.setModel(model);
    }
    
    private void updateTable(ArrayList<Books> booksListuser) {
        DefaultTableModel model = (DefaultTableModel) jTable_books.getModel();
        model.setRowCount(0);
        
        for (Books book : booksListuser) {
            Object[] row = {book.getId(), book.getBookname(), book.getMainclass(), book.getSubclass(), book.getLocation(), book.getFilename()};
            model.addRow(row);
            
            jTable_books.setModel(model);
        }
    }
    
//    private void clearTable() {
//        DefaultTableModel model = (DefaultTableModel) jTable_books.getModel();
//        model.setRowCount(0);
//    }
    private ArrayList<Books> fetchSortedListBasedOnCategory(String category) {
        ArrayList<Books> sortedList = new ArrayList<>();
        String selectQuery = "";
        
        switch (category) {
            case "ID":
                selectQuery = "SELECT * FROM Books ORDER BY id";
                break;
            case "Book Name":
                selectQuery = "SELECT * FROM Books ORDER BY bookname";
                break;
            case "Main Class":
                selectQuery = "SELECT * FROM Books ORDER BY mainclass";
                break;
            default:
                System.out.println("ERrir");
                break;
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String bookname = rs.getString("bookname");
                String mainclass = rs.getString("mainclass");
                String subclass = rs.getString("subclass");
                String location = rs.getString("location");
                String filename = rs.getString("filename");
                
                Books book = new Books(id, bookname, mainclass, subclass, location, filename);
                sortedList.add(book);
            }
        } catch(SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sortedList;
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
        jTable_books = new javax.swing.JTable();
        jTextField_search = new javax.swing.JTextField();
        jButton_search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_categorypick = new javax.swing.JComboBox<>();
        jLabel_result = new javax.swing.JLabel();
        jLabel2_photo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTable_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_books);

        jButton_search.setText("Search");
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        jLabel1.setText("Sort by Category:");

        jComboBox_categorypick.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ID", "Book Name", "Main Class" }));

        jLabel_result.setText("   ");

        jLabel2_photo.setText("   ");

        jLabel2.setText("Search:");

        jLabel3.setText("               Results");

        jLabel4.setText("           Book Photo");

        jButton_back.setText("Back");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_categorypick, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_search)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2_photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jLabel_result, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel_result)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(jComboBox_categorypick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jButton_search)
                                .addGap(33, 33, 33)
                                .addComponent(jButton_back))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        String selectedCategory = (String) jComboBox_categorypick.getSelectedItem();
        String searchTerm = jTextField_search.getText();
        
        if(selectedCategory != null && !searchTerm.isEmpty()) {
            ArrayList<Books> sortedList = fetchSortedListBasedOnCategory(selectedCategory);
            Books searchResults = books.bookbinarysearch(sortedList, selectedCategory, searchTerm);
            //int index = books.bookbinarysearch(sortedList, selectedCategory, searchTerm);
            
            if (searchResults != null) {
                
                jLabel_result.setText("Book found " + searchResults.getBookname());
                
                ArrayList<Books> searchResultsList = new ArrayList<>();
                searchResultsList.add(searchResults);
                updateTable(searchResultsList);
                
            } else {
                jLabel_result.setText("Book Not found");
                 
                populateJtablewithBooks();
        }
        } else {
            jLabel_result.setText("Select a category");
            //populateJtablewithBooks();
        }
    }//GEN-LAST:event_jButton_searchActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

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
            java.util.logging.Logger.getLogger(userdbform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userdbform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userdbform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userdbform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userdbform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_search;
    private javax.swing.JComboBox<String> jComboBox_categorypick;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2_photo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_result;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_books;
    private javax.swing.JTextField jTextField_search;
    // End of variables declaration//GEN-END:variables
}
