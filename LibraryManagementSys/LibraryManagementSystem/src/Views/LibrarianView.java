/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.UserController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last Updated 3/10
 *
 * This class allows the librarian to search the book database and to check the
 * books they have checked out, in addition to searching for and creating new
 * customers
 */
public class LibrarianView extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public LibrarianView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LibrarianLabel = new javax.swing.JLabel();
        BookSearchLabel = new javax.swing.JLabel();
        CustomerSearchLabel = new javax.swing.JLabel();
        AddBookLabel = new javax.swing.JLabel();
        AddLibrarianLabel = new javax.swing.JLabel();
        CheckInLabel = new javax.swing.JLabel();
        CheckOutLabel = new javax.swing.JLabel();
        CustomerSearchTextField = new javax.swing.JTextField();
        CheckOutButton = new javax.swing.JButton();
        OpenDatabaseButton = new javax.swing.JButton();
        CustomerSearchButton = new javax.swing.JButton();
        AddBookButton = new javax.swing.JButton();
        AddLibrarianButton = new javax.swing.JButton();
        CheckInButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LibrarianLabel.setText("Librarian");

        BookSearchLabel.setText("Book Search:");

        CustomerSearchLabel.setText("Customer Search (ID):");

        AddBookLabel.setText("Add Book to Library");

        AddLibrarianLabel.setText("Add New Librarian");

        CheckInLabel.setText("Check In:");

        CheckOutLabel.setText("Check Out:");

        CheckOutButton.setText("Check Out");
        CheckOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutButtonActionPerformed(evt);
            }
        });

        OpenDatabaseButton.setText("Open Database");
        OpenDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenDatabaseButtonActionPerformed(evt);
            }
        });

        CustomerSearchButton.setText("Customer Search");
        CustomerSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerSearchButtonActionPerformed(evt);
            }
        });

        AddBookButton.setText("Add Book");
        AddBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookButtonActionPerformed(evt);
            }
        });

        AddLibrarianButton.setText("Add Librarian");
        AddLibrarianButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLibrarianButtonActionPerformed(evt);
            }
        });

        CheckInButton.setText("Check In");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(LibrarianLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustomerSearchLabel)
                            .addComponent(BookSearchLabel)
                            .addComponent(AddBookLabel)
                            .addComponent(AddLibrarianLabel)
                            .addComponent(CheckInLabel)
                            .addComponent(CheckOutLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CustomerSearchTextField)
                            .addComponent(CheckOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OpenDatabaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddBookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddLibrarianButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CheckInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(CustomerSearchButton)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LibrarianLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookSearchLabel)
                    .addComponent(OpenDatabaseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerSearchLabel)
                    .addComponent(CustomerSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerSearchButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBookLabel)
                    .addComponent(AddBookButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddLibrarianLabel)
                    .addComponent(AddLibrarianButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckInLabel)
                    .addComponent(CheckInButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckOutLabel)
                    .addComponent(CheckOutButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookButtonActionPerformed
        AddBookView abv = new AddBookView();
        abv.setVisible(true);
    }//GEN-LAST:event_AddBookButtonActionPerformed

    private void OpenDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenDatabaseButtonActionPerformed
        // Open the Book Datbase View
        JFrame frame = new JFrame("Book DB view");
        BookDatabaseView BookDBView = new BookDatabaseView();
        frame.add(BorderLayout.CENTER, BookDBView);
        BookDBView.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setVisible(true);

        BookDBView.setVisible(true);
    }//GEN-LAST:event_OpenDatabaseButtonActionPerformed

    // Searches for customer within the database
    private void CustomerSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerSearchButtonActionPerformed
        try {
            String id = CustomerSearchTextField.getText();
            UserController userControl = new UserController();
            userControl.SearchUser(id);

            //Code to display User
        } catch (Exception ex) {
            Logger.getLogger(LibrarianView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CustomerSearchButtonActionPerformed

    // Opens the Register view with a librarian usertype in order to add a new librarian to the system
    private void AddLibrarianButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLibrarianButtonActionPerformed
        RegisterView registerview = new RegisterView("librarian");
        registerview.setVisible(true);
    }//GEN-LAST:event_AddLibrarianButtonActionPerformed

    // Opens the Checkout view so the librarian can checkout a book for the customer
    private void CheckOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutButtonActionPerformed
        CheckoutView checkoutview = new CheckoutView();
        checkoutview.setVisible(true);
    }//GEN-LAST:event_CheckOutButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBookButton;
    private javax.swing.JLabel AddBookLabel;
    private javax.swing.JButton AddLibrarianButton;
    private javax.swing.JLabel AddLibrarianLabel;
    private javax.swing.JLabel BookSearchLabel;
    private javax.swing.JButton CheckInButton;
    private javax.swing.JLabel CheckInLabel;
    private javax.swing.JButton CheckOutButton;
    private javax.swing.JLabel CheckOutLabel;
    private javax.swing.JButton CustomerSearchButton;
    private javax.swing.JLabel CustomerSearchLabel;
    private javax.swing.JTextField CustomerSearchTextField;
    private javax.swing.JLabel LibrarianLabel;
    private javax.swing.JButton OpenDatabaseButton;
    // End of variables declaration//GEN-END:variables
}
