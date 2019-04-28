package Views;

import java.awt.event.ActionListener;

/**
 *
 * @author Jeremy Hudson
 * @author Charles Brady
 *
 This class adds a listener to the login button and returns login info
 * to the UserController
 *
 * Last updated 3/5
 */
public class LoginView extends javax.swing.JFrame {


    public LoginView() {
        initComponents();
        this.pack();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameTxtfield = new javax.swing.JTextField();
        LoginLbl = new javax.swing.JLabel();
        Username_label = new javax.swing.JLabel();
        Password_label = new javax.swing.JLabel();
        passwordTxtField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LoginLbl.setText("Login");

        Username_label.setText("Username");

        Password_label.setText("Password");

        loginButton.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Password_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordTxtField))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Username_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(usernameTxtfield, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(LoginLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginLbl)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username_label)
                    .addComponent(usernameTxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password_label)
                    .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getUsername() {
        return this.usernameTxtfield.getText();
    }

    public String getPassword() {
        return this.passwordTxtField.getText();
    }

    public void loginListener(ActionListener _listenForLogin) {

        this.loginButton.addActionListener(_listenForLogin);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginLbl;
    private javax.swing.JLabel Password_label;
    private javax.swing.JLabel Username_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordTxtField;
    private javax.swing.JTextField usernameTxtfield;
    // End of variables declaration//GEN-END:variables

}
