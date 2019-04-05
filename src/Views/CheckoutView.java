package Views;

import Models.BooksModel;
import Models.UserModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import SQL_Translator.MySQLDBTranslator;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/31
 *
 * This is the view for librarians to check out a customers book
 */
public class CheckoutView extends javax.swing.JFrame {

    /**
     * Creates new form CheckoutView
     */
    public CheckoutView() {
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

        CustomerTextField = new javax.swing.JTextField();
        ISBNTextField = new javax.swing.JTextField();
        CustomerLabel = new javax.swing.JLabel();
        BookISBNLabel = new javax.swing.JLabel();
        CheckoutButton = new javax.swing.JToggleButton();
        ISBNTextField1 = new javax.swing.JTextField();
        ISBNTextField2 = new javax.swing.JTextField();
        ISBNTextField3 = new javax.swing.JTextField();
        ISBNTextField4 = new javax.swing.JTextField();
        ISBNTextField5 = new javax.swing.JTextField();
        ISBNTextField6 = new javax.swing.JTextField();
        ISBNTextField7 = new javax.swing.JTextField();
        ISBNTextField8 = new javax.swing.JTextField();
        ISBNTextField9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        CustomerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerTextFieldActionPerformed(evt);
            }
        });

        ISBNTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextFieldActionPerformed(evt);
            }
        });

        CustomerLabel.setText("Customer ID:");

        BookISBNLabel.setText("Enter books to checkout by ISBN:");

        CheckoutButton.setText("Checkout");
        CheckoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutButtonActionPerformed(evt);
            }
        });

        ISBNTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextField1ActionPerformed(evt);
            }
        });

        ISBNTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextField2ActionPerformed(evt);
            }
        });

        ISBNTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextField3ActionPerformed(evt);
            }
        });

        ISBNTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextField4ActionPerformed(evt);
            }
        });

        ISBNTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextField5ActionPerformed(evt);
            }
        });

        ISBNTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextField6ActionPerformed(evt);
            }
        });

        ISBNTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextField7ActionPerformed(evt);
            }
        });

        ISBNTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextField8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ISBNTextField)
                                    .addComponent(ISBNTextField1)
                                    .addComponent(ISBNTextField2)
                                    .addComponent(ISBNTextField3)
                                    .addComponent(ISBNTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(221, 221, 221)
                                        .addComponent(CheckoutButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ISBNTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ISBNTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ISBNTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ISBNTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ISBNTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(CustomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CustomerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookISBNLabel))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerLabel))
                .addGap(31, 31, 31)
                .addComponent(BookISBNLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ISBNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ISBNTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ISBNTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ISBNTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ISBNTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ISBNTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ISBNTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ISBNTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ISBNTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ISBNTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(CheckoutButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutButtonActionPerformed

        String[] isbn = new String[] {"", "", "", "", "", "", "", "", "", ""};
        isbn[0] = ISBNTextField.getText();
        isbn[1] = ISBNTextField1.getText();
        isbn[2] = ISBNTextField2.getText();
        isbn[3] = ISBNTextField3.getText();
        isbn[4] = ISBNTextField4.getText();
        isbn[5] = ISBNTextField5.getText();
        isbn[6] = ISBNTextField6.getText();
        isbn[7] = ISBNTextField7.getText();
        isbn[8] = ISBNTextField8.getText();
        isbn[9] = ISBNTextField9.getText();

        String userID = CustomerTextField.getText();
        int id = Integer.valueOf(userID);
        
        try {
            MySQLDBTranslator translator = new MySQLDBTranslator();
            translator.checkoutBooks(isbn, id);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_CheckoutButtonActionPerformed

    private void CustomerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerTextFieldActionPerformed
        ISBNTextField.requestFocus();
    }//GEN-LAST:event_CustomerTextFieldActionPerformed

    private void ISBNTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextField1ActionPerformed
        ISBNTextField2.requestFocus();
    }//GEN-LAST:event_ISBNTextField1ActionPerformed

    private void ISBNTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextField2ActionPerformed
        ISBNTextField3.requestFocus();
    }//GEN-LAST:event_ISBNTextField2ActionPerformed

    private void ISBNTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextField3ActionPerformed
        ISBNTextField4.requestFocus();
    }//GEN-LAST:event_ISBNTextField3ActionPerformed

    private void ISBNTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextFieldActionPerformed
        ISBNTextField1.requestFocus();
    }//GEN-LAST:event_ISBNTextFieldActionPerformed

    private void ISBNTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextField5ActionPerformed
       ISBNTextField6.requestFocus();
    }//GEN-LAST:event_ISBNTextField5ActionPerformed

    private void ISBNTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextField4ActionPerformed
        ISBNTextField5.requestFocus();
    }//GEN-LAST:event_ISBNTextField4ActionPerformed

    private void ISBNTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextField6ActionPerformed
        ISBNTextField7.requestFocus();
    }//GEN-LAST:event_ISBNTextField6ActionPerformed

    private void ISBNTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextField7ActionPerformed
        ISBNTextField8.requestFocus();
    }//GEN-LAST:event_ISBNTextField7ActionPerformed

    private void ISBNTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextField8ActionPerformed
        ISBNTextField9.requestFocus();
    }//GEN-LAST:event_ISBNTextField8ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookISBNLabel;
    private javax.swing.JToggleButton CheckoutButton;
    private javax.swing.JLabel CustomerLabel;
    private javax.swing.JTextField CustomerTextField;
    private javax.swing.JTextField ISBNTextField;
    private javax.swing.JTextField ISBNTextField1;
    private javax.swing.JTextField ISBNTextField2;
    private javax.swing.JTextField ISBNTextField3;
    private javax.swing.JTextField ISBNTextField4;
    private javax.swing.JTextField ISBNTextField5;
    private javax.swing.JTextField ISBNTextField6;
    private javax.swing.JTextField ISBNTextField7;
    private javax.swing.JTextField ISBNTextField8;
    private javax.swing.JTextField ISBNTextField9;
    // End of variables declaration//GEN-END:variables
}
