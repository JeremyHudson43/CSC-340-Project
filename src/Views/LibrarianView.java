package Views;

import java.awt.event.ActionListener;

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

    public void databaseListener(ActionListener listenForDatabase) {

        openDatabaseButton.addActionListener(listenForDatabase);

    }

    public void customerSearchListener(ActionListener listenForCustomerSearch) {

        customerSearchButton.addActionListener(listenForCustomerSearch);
    }

    public void bookAddListener(ActionListener listenForAddBook) {
        addBookButton.addActionListener(listenForAddBook);
    }

    public void librarianSearchListener(ActionListener listenForAddLibrarian) {
        addBookButton.addActionListener(listenForAddLibrarian);
    }

    public void checkInListener(ActionListener listenForCheckIn) {
        addBookButton.addActionListener(listenForCheckIn);
    }

    public void checkOutListener(ActionListener listenForCheckOut) {
        checkOutButton.addActionListener(listenForCheckOut);
    }

    public void goToBookListener(ActionListener listenForGoToBook) {
        GoToSelectedBookButton.addActionListener(listenForGoToBook);
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
        jLabel1 = new javax.swing.JLabel();
        librarianViewCheckoutComboBox = new javax.swing.JComboBox<>();
        openDatabaseButton = new javax.swing.JButton();
        customerSearchButton = new javax.swing.JButton();
        addBookButton = new javax.swing.JButton();
        addLibrarianButton = new javax.swing.JButton();
        checkInButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        GoToSelectedBookButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LibrarianLabel.setText("Librarian");

        BookSearchLabel.setText("Book Search:");

        CustomerSearchLabel.setText("Customer Search (ID):");

        AddBookLabel.setText("Add Book to Library");

        AddLibrarianLabel.setText("Add New Librarian");

        CheckInLabel.setText("Check In:");

        CheckOutLabel.setText("Check Out:");

        jLabel1.setText("My Check Outs:");

        librarianViewCheckoutComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        openDatabaseButton.setText("Open Database");

        customerSearchButton.setText("Search Customer");

        addBookButton.setText("Add Book");

        addLibrarianButton.setText("Add Librarian");

        checkInButton.setText("Check in Book");

        checkOutButton.setText("Check out Book");

        GoToSelectedBookButton.setText("Go To Selected Book");

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
                            .addComponent(CheckOutLabel)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openDatabaseButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(addLibrarianButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(addBookButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CustomerSearchTextField)
                                    .addComponent(librarianViewCheckoutComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerSearchButton)
                                    .addComponent(GoToSelectedBookButton)))
                            .addComponent(checkInButton)
                            .addComponent(checkOutButton))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LibrarianLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookSearchLabel)
                    .addComponent(openDatabaseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerSearchLabel)
                    .addComponent(CustomerSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerSearchButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBookLabel)
                    .addComponent(addBookButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddLibrarianLabel)
                    .addComponent(addLibrarianButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckInLabel)
                    .addComponent(checkInButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckOutLabel)
                    .addComponent(checkOutButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(librarianViewCheckoutComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GoToSelectedBookButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddBookLabel;
    private javax.swing.JLabel AddLibrarianLabel;
    private javax.swing.JLabel BookSearchLabel;
    private javax.swing.JLabel CheckInLabel;
    private javax.swing.JLabel CheckOutLabel;
    private javax.swing.JLabel CustomerSearchLabel;
    private javax.swing.JTextField CustomerSearchTextField;
    private javax.swing.JButton GoToSelectedBookButton;
    private javax.swing.JLabel LibrarianLabel;
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton addLibrarianButton;
    private javax.swing.JButton checkInButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JButton customerSearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> librarianViewCheckoutComboBox;
    private javax.swing.JButton openDatabaseButton;
    // End of variables declaration//GEN-END:variables
}
