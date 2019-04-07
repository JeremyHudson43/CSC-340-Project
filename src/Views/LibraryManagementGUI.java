package Views;

import Controllers.UserController;
import Models.UserModel;
import java.awt.event.ActionListener;

/**
 *
 * @author DELL6420
 */
public class LibraryManagementGUI extends javax.swing.JFrame {

    /**
     * Creates new form LibraryManagementGUI2
     */
    public LibraryManagementGUI() {
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

        newUserLbl = new javax.swing.JLabel();
        returningUserLabel = new javax.swing.JLabel();
        exitProgramButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newUserLbl.setText("New User");

        returningUserLabel.setText("Returning User");

        exitProgramButton.setText("Exit Program");
        exitProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitProgramButtonActionPerformed(evt);
            }
        });

        registerButton.setText("Register");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returningUserLabel)
                    .addComponent(newUserLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(exitProgramButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returningUserLabel)
                    .addComponent(loginButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUserLbl)
                    .addComponent(registerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(exitProgramButton)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitProgramButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

    }//GEN-LAST:event_loginButtonActionPerformed

    public void addLoginListener(ActionListener listenForLogin) {

        loginButton.addActionListener(listenForLogin);

    }

    public void addRegisterListener(ActionListener listenForLogin) {

        registerButton.addActionListener(listenForLogin);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        LibraryManagementGUI libManage = new LibraryManagementGUI();
        UserModel userModel = new UserModel();
        LoginView loginView = new LoginView();
        RegisterView registerView = new RegisterView("customer");

        UserController userController
                = new UserController(libManage, userModel, loginView, registerView);
        userController.initController();

        libManage.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitProgramButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel newUserLbl;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel returningUserLabel;
    // End of variables declaration//GEN-END:variables
}
