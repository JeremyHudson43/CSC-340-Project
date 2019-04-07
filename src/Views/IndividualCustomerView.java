
package Views;

/**
 *
 * @author Jeremy Hudson
 *
 * Last updated 4/7
 */
public class IndividualCustomerView extends javax.swing.JPanel {

    /**
     * Creates new form IndividualCustomerView
     */
    public IndividualCustomerView() {
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

        individualCustomerViewBackButton = new javax.swing.JButton();
        individualCustomerViewExiProgramButton = new javax.swing.JButton();
        individualCustomerViewTxtLbl = new javax.swing.JLabel();
        individualCustomerViewNameTxtLbl = new javax.swing.JLabel();
        individualCustomerViewEmailTxtLbl = new javax.swing.JLabel();
        individualCustomerViewLibCardNumberTxtLbl = new javax.swing.JLabel();
        individualCustomerViewCheckoutsTxtLbl = new javax.swing.JLabel();
        namePlaceholderTxtLbl = new javax.swing.JLabel();
        emailAddressPlaceholderTxtLbl = new javax.swing.JLabel();
        libraryCardNumberPlaceholderTxtLbl = new javax.swing.JLabel();
        individualCustomerViewIDNumberTxtLbl = new javax.swing.JLabel();
        customerIDNumberPlaceholderTxtLbl = new javax.swing.JLabel();
        individualCustomerViewComboBox = new javax.swing.JComboBox<>();

        individualCustomerViewBackButton.setText("Back");

        individualCustomerViewExiProgramButton.setText("Exit Program");

        individualCustomerViewTxtLbl.setText("Individual Customer View");

        individualCustomerViewNameTxtLbl.setText("Customer Name:");

        individualCustomerViewEmailTxtLbl.setText("Customer Email Address:");

        individualCustomerViewLibCardNumberTxtLbl.setText("Customer Library Card Number:");

        individualCustomerViewCheckoutsTxtLbl.setText("Books Customer has checked out:");

        namePlaceholderTxtLbl.setText("Customer Name Placeholder");

        emailAddressPlaceholderTxtLbl.setText("Customer Email Address Placeholder");

        libraryCardNumberPlaceholderTxtLbl.setText("Library Card Number Placeholder");

        individualCustomerViewIDNumberTxtLbl.setText("Customer ID Number:");

        customerIDNumberPlaceholderTxtLbl.setText("Customer ID Number Placeholder");

        individualCustomerViewComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(individualCustomerViewExiProgramButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(individualCustomerViewBackButton)
                        .addGap(47, 47, 47)
                        .addComponent(individualCustomerViewTxtLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(individualCustomerViewLibCardNumberTxtLbl)
                            .addComponent(individualCustomerViewEmailTxtLbl)
                            .addComponent(individualCustomerViewNameTxtLbl))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namePlaceholderTxtLbl)
                            .addComponent(emailAddressPlaceholderTxtLbl)
                            .addComponent(libraryCardNumberPlaceholderTxtLbl)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(individualCustomerViewCheckoutsTxtLbl)
                            .addComponent(individualCustomerViewIDNumberTxtLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customerIDNumberPlaceholderTxtLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(individualCustomerViewComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualCustomerViewBackButton)
                    .addComponent(individualCustomerViewTxtLbl))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualCustomerViewNameTxtLbl)
                    .addComponent(namePlaceholderTxtLbl))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualCustomerViewEmailTxtLbl)
                    .addComponent(emailAddressPlaceholderTxtLbl))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualCustomerViewLibCardNumberTxtLbl)
                    .addComponent(libraryCardNumberPlaceholderTxtLbl))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualCustomerViewIDNumberTxtLbl)
                    .addComponent(customerIDNumberPlaceholderTxtLbl))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(individualCustomerViewCheckoutsTxtLbl)
                    .addComponent(individualCustomerViewComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(individualCustomerViewExiProgramButton)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerIDNumberPlaceholderTxtLbl;
    private javax.swing.JLabel emailAddressPlaceholderTxtLbl;
    private javax.swing.JButton individualCustomerViewBackButton;
    private javax.swing.JLabel individualCustomerViewCheckoutsTxtLbl;
    private javax.swing.JComboBox<String> individualCustomerViewComboBox;
    private javax.swing.JLabel individualCustomerViewEmailTxtLbl;
    private javax.swing.JButton individualCustomerViewExiProgramButton;
    private javax.swing.JLabel individualCustomerViewIDNumberTxtLbl;
    private javax.swing.JLabel individualCustomerViewLibCardNumberTxtLbl;
    private javax.swing.JLabel individualCustomerViewNameTxtLbl;
    private javax.swing.JLabel individualCustomerViewTxtLbl;
    private javax.swing.JLabel libraryCardNumberPlaceholderTxtLbl;
    private javax.swing.JLabel namePlaceholderTxtLbl;
    // End of variables declaration//GEN-END:variables
}
