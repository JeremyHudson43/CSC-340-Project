package Views;

import Views.BookDatabaseView;


/**
 * @author Jeremy Hudson
 * @author Charles Brady
 *
 * Last updated 3/13
 *
 * This class is the view that the customer will see.
 * This allows the customer to search the book database and to check the
 * books they have checked out
 */
public class CustomerView extends javax.swing.JPanel {

    /**
     * Creates new form CustomerView
     */
    public CustomerView() {
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

        custBookSearchLbl = new javax.swing.JLabel();
        custViewLabel = new javax.swing.JLabel();
        custShowCheckoutsLbl = new javax.swing.JLabel();
        custShowCheckoutsButton = new javax.swing.JButton();
        custSearchDatabaseButton = new javax.swing.JButton();
        custViewExitButton = new javax.swing.JButton();

        custBookSearchLbl.setText("Search book database:");

        custViewLabel.setText("Customer View");

        custShowCheckoutsLbl.setText("Show checked out books:");

        custShowCheckoutsButton.setText("Show my checked out books");

        custSearchDatabaseButton.setText("Open Database");
        custSearchDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custSearchDatabaseButtonActionPerformed(evt);
            }
        });

        custViewExitButton.setText("Exit Program");
        custViewExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custViewExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(custViewLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(custShowCheckoutsLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custShowCheckoutsButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(custBookSearchLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custSearchDatabaseButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(custViewExitButton)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(custViewLabel)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custBookSearchLbl)
                    .addComponent(custSearchDatabaseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custShowCheckoutsLbl)
                    .addComponent(custShowCheckoutsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(custViewExitButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //Open the Book Database View
    private void custSearchDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custSearchDatabaseButtonActionPerformed

        BookDatabaseView BookDBView = new BookDatabaseView();
        BookDBView.setVisible(true);

    }//GEN-LAST:event_custSearchDatabaseButtonActionPerformed

    private void custViewExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custViewExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_custViewExitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel custBookSearchLbl;
    private javax.swing.JButton custSearchDatabaseButton;
    private javax.swing.JButton custShowCheckoutsButton;
    private javax.swing.JLabel custShowCheckoutsLbl;
    private javax.swing.JButton custViewExitButton;
    private javax.swing.JLabel custViewLabel;
    // End of variables declaration//GEN-END:variables
}