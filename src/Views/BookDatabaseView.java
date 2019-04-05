package Views;

import Controllers.BooksController;
import Models.BooksModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;



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
        searchDatabaseNoLogin = new javax.swing.JLabel();
        searchAuthorNoLoginTxtFld = new javax.swing.JTextField();
        searchTitleNoLoginTxtFld = new javax.swing.JTextField();
        searchISBNNoLoginTxtFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        exitProgramButton = new javax.swing.JButton();
        searchLocalDatabaseNoLoginButton = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jButton2.setText("jButton2");

        LibManageSys.setBorder(javax.swing.BorderFactory.createTitledBorder("Library Management System"));

        searchDatabaseNoLogin.setText("Search database ");

        searchAuthorNoLoginTxtFld.setText("Author Name");

        searchTitleNoLoginTxtFld.setText("Title of Book");

        jLabel1.setText("Search by ISBN");

        javax.swing.GroupLayout LibManageSysLayout = new javax.swing.GroupLayout(LibManageSys);
        LibManageSys.setLayout(LibManageSysLayout);
        LibManageSysLayout.setHorizontalGroup(
            LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LibManageSysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LibManageSysLayout.createSequentialGroup()
                        .addComponent(searchDatabaseNoLogin)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LibManageSysLayout.createSequentialGroup()
                        .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(searchAuthorNoLoginTxtFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(searchTitleNoLoginTxtFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(searchISBNNoLoginTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 183, Short.MAX_VALUE))))
        );
        LibManageSysLayout.setVerticalGroup(
            LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LibManageSysLayout.createSequentialGroup()
                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchDatabaseNoLogin)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LibManageSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchAuthorNoLoginTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchISBNNoLoginTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTitleNoLoginTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        exitProgramButton.setText("Exit Program");
        exitProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitProgramButtonActionPerformed(evt);
            }
        });

        searchLocalDatabaseNoLoginButton.setText("Search Database");
        searchLocalDatabaseNoLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLocalDatabaseNoLoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LibManageSys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exitProgramButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchLocalDatabaseNoLoginButton)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LibManageSys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitProgramButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(searchLocalDatabaseNoLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitProgramButtonActionPerformed

    private void searchLocalDatabaseNoLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLocalDatabaseNoLoginButtonActionPerformed
             try {

            BooksModel bookModel = new BooksModel();
            BookDatabaseView bookDBView = new BookDatabaseView();
            BooksController bookController = 
                    new BooksController(bookModel, bookDBView);
            bookController.initController(searchAuthorNoLoginTxtFld.getText(), 
                    searchTitleNoLoginTxtFld.getText(), 
                    searchISBNNoLoginTxtFld.getText());


        } catch (Exception ex) {
            Logger.getLogger(BookDatabaseView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 

    }//GEN-LAST:event_searchLocalDatabaseNoLoginButtonActionPerformed


    public String getAuthorName() {
        return searchAuthorNoLoginTxtFld.getText();
    }
    
      public String getBookTitle() {
        return searchTitleNoLoginTxtFld.getText();
    }
      
       public String getISBN() {
        return searchISBNNoLoginTxtFld.getText();
    }
       

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LibManageSys;
    private javax.swing.JButton exitProgramButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JTextField searchAuthorNoLoginTxtFld;
    private javax.swing.JLabel searchDatabaseNoLogin;
    private javax.swing.JTextField searchISBNNoLoginTxtFld;
    private javax.swing.JButton searchLocalDatabaseNoLoginButton;
    private javax.swing.JTextField searchTitleNoLoginTxtFld;
    // End of variables declaration//GEN-END:variables

}
