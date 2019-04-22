package Views;

import java.awt.event.ActionListener;

/**
 * @author Jeremy Hudson
 * @author Charles Brady
 *
 * Last updated 4/5
 *
 * This class is the view that the customer will see. This allows the customer
 * to search the book database and to check the books they have checked out
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
        showMyCheckoutsCustomerViewTxtLbl = new javax.swing.JLabel();
        CheckoutBox = new javax.swing.JComboBox<>();
        custSearchDatabaseButton = new javax.swing.JButton();
        goToSelectedBookCustomerViewButton = new javax.swing.JButton();

        custBookSearchLbl.setText("Search book database:");

        custViewLabel.setText("Customer View");

        showMyCheckoutsCustomerViewTxtLbl.setText("My checkouts:");

        CheckoutBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        custSearchDatabaseButton.setText("Search Database");

        goToSelectedBookCustomerViewButton.setText("Go to Selected Checkout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goToSelectedBookCustomerViewButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(custViewLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(showMyCheckoutsCustomerViewTxtLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CheckoutBox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(custBookSearchLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(custSearchDatabaseButton)))))
                        .addGap(0, 144, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(custViewLabel)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custBookSearchLbl)
                    .addComponent(custSearchDatabaseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showMyCheckoutsCustomerViewTxtLbl)
                    .addComponent(CheckoutBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(goToSelectedBookCustomerViewButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void databaseListener(ActionListener listenForDatabase) {

        custSearchDatabaseButton.addActionListener(listenForDatabase);

    }

    public void goToBookListener(ActionListener listenForGoToBook) {

        custSearchDatabaseButton.addActionListener(listenForGoToBook);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CheckoutBox;
    private javax.swing.JLabel custBookSearchLbl;
    private javax.swing.JButton custSearchDatabaseButton;
    private javax.swing.JLabel custViewLabel;
    private javax.swing.JButton goToSelectedBookCustomerViewButton;
    private javax.swing.JLabel showMyCheckoutsCustomerViewTxtLbl;
    // End of variables declaration//GEN-END:variables
}
