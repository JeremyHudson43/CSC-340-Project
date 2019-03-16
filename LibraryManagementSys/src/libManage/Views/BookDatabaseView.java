package Views;

import Controllers.BooksController;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Models.ManageBookInfo;

/*
Jeremy Hudson
Charles Brady
*
* This class is used to access the database of books
*
*
Last updated 2-23-2019
 */
public class BookDatabaseView extends javax.swing.JPanel {

    /**
     * Creates new form BookDatabaseView
     */
    public BookDatabaseView() {
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

        jMenu1 = new javax.swing.JMenu();
        jButton2 = new javax.swing.JButton();
        LibManageSys = new javax.swing.JPanel();
        exitProgramButton = new javax.swing.JButton();
        searchDatabaseNoLogin = new javax.swing.JLabel();
        searchAuthorNoLoginTxtFld = new javax.swing.JTextField();
        searchLocalDatabaseNoLoginButton = new javax.swing.JButton();
        searchTitleNoLoginTxtFld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookResultsList = new javax.swing.JList<>();
        bookSearchResultsTxtLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        removeFromCheckoutButton = new javax.swing.JButton();
        checkOutBooksButton = new javax.swing.JButton();
        searchAPIForBooks = new javax.swing.JButton();
        searchISBNNoLoginTxtFld = new javax.swing.JTextField();

        jMenu1.setText("jMenu1");

        jButton2.setText("jButton2");

        LibManageSys.setBorder(javax.swing.BorderFactory.createTitledBorder("Library Management System"));

        exitProgramButton.setText("Exit Program");
        exitProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitProgramButtonActionPerformed(evt);
            }
        });

        searchDatabaseNoLogin.setText("Search database ");

        searchLocalDatabaseNoLoginButton.setText("Search Local Database");
        searchLocalDatabaseNoLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLocalDatabaseNoLoginButtonActionPerformed(evt);
            }
        });

        bookResultsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(bookResultsList);

        bookSearchResultsTxtLbl.setText("Results");

        jButton1.setText("Add to checkout list");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        removeFromCheckoutButton.setText("Remove from checkout list");

        checkOutBooksButton.setText("Checkout selected books");

        searchAPIForBooks.setText("Search API");
        searchAPIForBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAPIForBooksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LibManageSysLayout = new javax.swing.GroupLayout(LibManageSys);
        LibManageSys.setLayout(LibManageSysLayout);
        LibManageSysLayout.setHorizontalGroup(
            LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LibManageSysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LibManageSysLayout.createSequentialGroup()
                        .addComponent(exitProgramButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(LibManageSysLayout.createSequentialGroup()
                        .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchDatabaseNoLogin)
                            .addComponent(bookSearchResultsTxtLbl))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(LibManageSysLayout.createSequentialGroup()
                        .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(searchISBNNoLoginTxtFld, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchAuthorNoLoginTxtFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(searchTitleNoLoginTxtFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LibManageSysLayout.createSequentialGroup()
                                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeFromCheckoutButton)
                                    .addGroup(LibManageSysLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jButton1)))
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LibManageSysLayout.createSequentialGroup()
                                .addGap(0, 171, Short.MAX_VALUE)
                                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(checkOutBooksButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(searchLocalDatabaseNoLoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchAPIForBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(41, 41, 41))))
        );
        LibManageSysLayout.setVerticalGroup(
            LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LibManageSysLayout.createSequentialGroup()
                .addComponent(searchDatabaseNoLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchAuthorNoLoginTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchAPIForBooks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTitleNoLoginTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchLocalDatabaseNoLoginButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchISBNNoLoginTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(bookSearchResultsTxtLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LibManageSysLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(14, 14, 14)
                        .addComponent(removeFromCheckoutButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitProgramButton)
                    .addComponent(checkOutBooksButton))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LibManageSys, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(LibManageSys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitProgramButtonActionPerformed

    private void searchLocalDatabaseNoLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLocalDatabaseNoLoginButtonActionPerformed
        try {
            BooksController bc = new BooksController();
            bc.SearchBook(searchAuthorNoLoginTxtFld.getText(),
                    searchTitleNoLoginTxtFld.getText(),
                    searchISBNNoLoginTxtFld.getText());
        } catch (Exception ex) {
            Logger.getLogger(BookDatabaseView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchLocalDatabaseNoLoginButtonActionPerformed

    private void searchAPIForBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAPIForBooksActionPerformed
        ManageBookInfo MBI = new ManageBookInfo();
        try {
            MBI.getRequest(searchAuthorNoLoginTxtFld.getText(),
                    searchTitleNoLoginTxtFld.getText());
        } catch (IOException ex) {
            Logger.getLogger(BookDatabaseView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
            }//GEN-LAST:event_searchAPIForBooksActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LibManageSys;
    private javax.swing.JList<String> bookResultsList;
    private javax.swing.JLabel bookSearchResultsTxtLbl;
    private javax.swing.JButton checkOutBooksButton;
    private javax.swing.JButton exitProgramButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList<String> jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeFromCheckoutButton;
    private javax.swing.JButton searchAPIForBooks;
    private javax.swing.JTextField searchAuthorNoLoginTxtFld;
    private javax.swing.JLabel searchDatabaseNoLogin;
    private javax.swing.JTextField searchISBNNoLoginTxtFld;
    private javax.swing.JButton searchLocalDatabaseNoLoginButton;
    private javax.swing.JTextField searchTitleNoLoginTxtFld;
    // End of variables declaration//GEN-END:variables

}