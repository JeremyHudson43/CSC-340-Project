package Views;

/**
 *
 * @author Jeremy Hudson
 * 
 * Last Updated 4-24-2019
 * 
 * This class simply displays the info for an individual user after being
 * passed data from the LibrarianController
 */
public class IndividualUserView extends javax.swing.JFrame {

    
    public IndividualUserView() {
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

        individualUserViewIDNumberTxtLbl = new javax.swing.JLabel();
        customerIDNumberPlaceholderTxtLbl = new javax.swing.JLabel();
        individualUserViewTxtLbl = new javax.swing.JLabel();
        individualUserViewNameTxtLbl = new javax.swing.JLabel();
        individualUserViewEmailTxtLbl = new javax.swing.JLabel();
        namePlaceholderTxtLbl = new javax.swing.JLabel();
        emailAddressPlaceholderTxtLbl = new javax.swing.JLabel();
        UserTypeLbl = new javax.swing.JLabel();
        individualUserViewUserTypePlaceholderLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        individualUserViewIDNumberTxtLbl.setText("User ID Number:");

        customerIDNumberPlaceholderTxtLbl.setText("User ID Number Placeholder");

        individualUserViewTxtLbl.setText("Individual User View");

        individualUserViewNameTxtLbl.setText("User's Name:");

        individualUserViewEmailTxtLbl.setText("User Email Address:");

        namePlaceholderTxtLbl.setText("User Name Placeholder");

        emailAddressPlaceholderTxtLbl.setText("User Email Address Placeholder");

        UserTypeLbl.setText("User Type:");

        individualUserViewUserTypePlaceholderLbl.setText("User Type Placeholder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(individualUserViewTxtLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(individualUserViewEmailTxtLbl)
                            .addComponent(individualUserViewNameTxtLbl))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namePlaceholderTxtLbl)
                            .addComponent(emailAddressPlaceholderTxtLbl)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(individualUserViewIDNumberTxtLbl)
                            .addComponent(UserTypeLbl))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(individualUserViewUserTypePlaceholderLbl)
                            .addComponent(customerIDNumberPlaceholderTxtLbl))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(individualUserViewTxtLbl)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualUserViewNameTxtLbl)
                    .addComponent(namePlaceholderTxtLbl))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualUserViewEmailTxtLbl)
                    .addComponent(emailAddressPlaceholderTxtLbl))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualUserViewIDNumberTxtLbl)
                    .addComponent(customerIDNumberPlaceholderTxtLbl))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserTypeLbl)
                    .addComponent(individualUserViewUserTypePlaceholderLbl))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setUsersName(String _customerName) {
        this.namePlaceholderTxtLbl.setText(_customerName);
    }

    public void setUserEmail(String _customerEmail) {
        this.emailAddressPlaceholderTxtLbl.setText(_customerEmail);
    }

    public void setUserID(String _customerID) {
        this.customerIDNumberPlaceholderTxtLbl.setText(_customerID);
    }

    public void setUserType(String _userType) {
        this.customerIDNumberPlaceholderTxtLbl.setText(_userType);
    }

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
            java.util.logging.Logger.getLogger(IndividualUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndividualUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndividualUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndividualUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndividualUserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserTypeLbl;
    private javax.swing.JLabel customerIDNumberPlaceholderTxtLbl;
    private javax.swing.JLabel emailAddressPlaceholderTxtLbl;
    private javax.swing.JLabel individualUserViewEmailTxtLbl;
    private javax.swing.JLabel individualUserViewIDNumberTxtLbl;
    private javax.swing.JLabel individualUserViewNameTxtLbl;
    private javax.swing.JLabel individualUserViewTxtLbl;
    private javax.swing.JLabel individualUserViewUserTypePlaceholderLbl;
    private javax.swing.JLabel namePlaceholderTxtLbl;
    // End of variables declaration//GEN-END:variables
}
