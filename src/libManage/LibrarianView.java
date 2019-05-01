package libManage;

import Views.BookDatabaseView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * This class allows the librarian to search the book database and to check the
 * books they have checked out, in addition to searching for and creating new
 * customers
 *
 * Last updated 2/23
 */
public class LibrarianView extends javax.swing.JPanel {

    /**
     * Creates new form librarianView1
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

        jFrame1 = new javax.swing.JFrame();
        libBookSearchLbl = new javax.swing.JLabel();
        libCustomerSearchLbl = new javax.swing.JLabel();
        libBookSearchTxtFld = new javax.swing.JTextField();
        libCustomerSearchTxtFld = new javax.swing.JTextField();
        libViewLbl = new javax.swing.JLabel();
        libBookSearchButton = new javax.swing.JButton();
        libCustomerSearchButton = new javax.swing.JButton();
        libCreateNewCustomerLbl = new javax.swing.JLabel();
        libCreateNewCustomerTxtFld = new javax.swing.JTextField();
        libCreateNewCustomerButton = new javax.swing.JButton();
        libViewExitButton = new javax.swing.JButton();
        libViewLbl1 = new javax.swing.JLabel();
        libBookSearchButton1 = new javax.swing.JButton();
        libCustomerSearchButton1 = new javax.swing.JButton();
        libCreateNewCustomerLbl1 = new javax.swing.JLabel();
        libCreateNewCustomerTxtFld1 = new javax.swing.JTextField();
        libCreateNewCustomerButton1 = new javax.swing.JButton();
        libViewExitButton1 = new javax.swing.JButton();
        libBookSearchLbl1 = new javax.swing.JLabel();
        libCustomerSearchLbl1 = new javax.swing.JLabel();
        libCustomerSearchTxtFld1 = new javax.swing.JTextField();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        libBookSearchLbl.setText("Book search:");

        libCustomerSearchLbl.setText("Customer search:");

        libBookSearchTxtFld.setText("Book search");

        libCustomerSearchTxtFld.setText("Customer search");
        libCustomerSearchTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libCustomerSearchTxtFldActionPerformed(evt);
            }
        });

        libViewLbl.setText("Librarian View");

        libBookSearchButton.setText("Book Search");
        libBookSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libBookSearchButtonActionPerformed(evt);
            }
        });

        libCustomerSearchButton.setText("Customer Search");
        libCustomerSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libCustomerSearchButtonActionPerformed(evt);
            }
        });

        libCreateNewCustomerLbl.setText("Create new Customer:");

        libCreateNewCustomerTxtFld.setText("Create Customer");

        libCreateNewCustomerButton.setText("Create Customer");

        libViewExitButton.setText("Exit Program");
        libViewExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libViewExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(libCustomerSearchLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libCustomerSearchTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libCustomerSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(libCreateNewCustomerLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libCreateNewCustomerTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libCreateNewCustomerButton))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(libViewLbl))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(libBookSearchLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libBookSearchTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libBookSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(libViewExitButton)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(libViewLbl)
                .addGap(22, 22, 22)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libBookSearchLbl)
                    .addComponent(libBookSearchTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libBookSearchButton))
                .addGap(10, 10, 10)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libCustomerSearchLbl)
                    .addComponent(libCustomerSearchTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libCustomerSearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libCreateNewCustomerLbl)
                    .addComponent(libCreateNewCustomerTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libCreateNewCustomerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(libViewExitButton)
                .addContainerGap())
        );

        libViewLbl1.setText("Librarian View");

        libBookSearchButton1.setText("Open Database");
        libBookSearchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libBookSearchButton1ActionPerformed(evt);
            }
        });

        libCustomerSearchButton1.setText("Customer Search");
        libCustomerSearchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libCustomerSearchButton1ActionPerformed(evt);
            }
        });

        libCreateNewCustomerLbl1.setText("Create new Customer:");

        libCreateNewCustomerTxtFld1.setText("Create Customer");

        libCreateNewCustomerButton1.setText("Create Customer");

        libViewExitButton1.setText("Exit Program");
        libViewExitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libViewExitButton1ActionPerformed(evt);
            }
        });

        libBookSearchLbl1.setText("Book search:");

        libCustomerSearchLbl1.setText("Customer search:");

        libCustomerSearchTxtFld1.setText("Customer search");
        libCustomerSearchTxtFld1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libCustomerSearchTxtFld1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(libCustomerSearchLbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libCustomerSearchTxtFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libCustomerSearchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(libCreateNewCustomerLbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libCreateNewCustomerTxtFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libCreateNewCustomerButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(libViewLbl1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(libBookSearchLbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(libBookSearchButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(libViewExitButton1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(libViewLbl1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libBookSearchLbl1)
                    .addComponent(libBookSearchButton1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libCustomerSearchLbl1)
                    .addComponent(libCustomerSearchTxtFld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libCustomerSearchButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libCreateNewCustomerLbl1)
                    .addComponent(libCreateNewCustomerTxtFld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libCreateNewCustomerButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(libViewExitButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void libCustomerSearchTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libCustomerSearchTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libCustomerSearchTxtFldActionPerformed

    private void libBookSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libBookSearchButtonActionPerformed


    }//GEN-LAST:event_libBookSearchButtonActionPerformed

    private void libCustomerSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libCustomerSearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libCustomerSearchButtonActionPerformed

    private void libViewExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libViewExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_libViewExitButtonActionPerformed

    private void libBookSearchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libBookSearchButton1ActionPerformed
        JFrame frame = new JFrame("Book DB view");
        BookDatabaseView BookDBView = new BookDatabaseView();
        frame.add(BorderLayout.CENTER, BookDBView);
        BookDBView.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setVisible(true);

        BookDBView.setVisible(true);

    }//GEN-LAST:event_libBookSearchButton1ActionPerformed

    private void libCustomerSearchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libCustomerSearchButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libCustomerSearchButton1ActionPerformed

    private void libViewExitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libViewExitButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_libViewExitButton1ActionPerformed

    private void libCustomerSearchTxtFld1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libCustomerSearchTxtFld1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libCustomerSearchTxtFld1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JButton libBookSearchButton;
    private javax.swing.JButton libBookSearchButton1;
    private javax.swing.JLabel libBookSearchLbl;
    private javax.swing.JLabel libBookSearchLbl1;
    private javax.swing.JTextField libBookSearchTxtFld;
    private javax.swing.JButton libCreateNewCustomerButton;
    private javax.swing.JButton libCreateNewCustomerButton1;
    private javax.swing.JLabel libCreateNewCustomerLbl;
    private javax.swing.JLabel libCreateNewCustomerLbl1;
    private javax.swing.JTextField libCreateNewCustomerTxtFld;
    private javax.swing.JTextField libCreateNewCustomerTxtFld1;
    private javax.swing.JButton libCustomerSearchButton;
    private javax.swing.JButton libCustomerSearchButton1;
    private javax.swing.JLabel libCustomerSearchLbl;
    private javax.swing.JLabel libCustomerSearchLbl1;
    private javax.swing.JTextField libCustomerSearchTxtFld;
    private javax.swing.JTextField libCustomerSearchTxtFld1;
    private javax.swing.JButton libViewExitButton;
    private javax.swing.JButton libViewExitButton1;
    private javax.swing.JLabel libViewLbl;
    private javax.swing.JLabel libViewLbl1;
    // End of variables declaration//GEN-END:variables
}