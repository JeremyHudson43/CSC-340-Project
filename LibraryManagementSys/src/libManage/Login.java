package libManage;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Models.User;
import Controllers.UserController;

/**
 *
 * @author Jeremy Hudson
 * @author Charles Brady
 *
 * This class allows a simple customer login
 *
 * Last updated 3/5
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form CustomerLogin
     */
    public Login() {
        initComponents();
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Username_txtfield = new javax.swing.JTextField();
        cust_login_button = new javax.swing.JButton();
        LoginLbl = new javax.swing.JLabel();
        custLoginExitButton = new javax.swing.JButton();
        Username_label = new javax.swing.JLabel();
        Password_label = new javax.swing.JLabel();
        Password_txtField = new javax.swing.JPasswordField();
        Register_Button = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cust_login_button.setText("Login");
        cust_login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_login_buttonActionPerformed(evt);
            }
        });

        LoginLbl.setText("Login");

        custLoginExitButton.setText("Exit Program");
        custLoginExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custLoginExitButtonActionPerformed(evt);
            }
        });

        Username_label.setText("Username");

        Password_label.setText("Password");

        Register_Button.setText("Register");
        Register_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Password_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Password_txtField))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Username_label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Username_txtfield))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(custLoginExitButton)
                            .addGap(18, 18, 18)
                            .addComponent(Register_Button))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cust_login_button)
                .addGap(46, 46, 46))
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
                    .addComponent(Username_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password_label)
                    .addComponent(Password_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custLoginExitButton)
                    .addComponent(cust_login_button)
                    .addComponent(Register_Button))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cust_login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_login_buttonActionPerformed

        String username = Username_txtfield.getText();
        String password = new String(Password_txtField.getPassword());

        String lib = "librarian";
        String cus = "customer";

        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Required fields not entered. Please try again.");
        } else {

            try {
                User u = new User();
                u.setId(username);
                u.setPassword(password);

                UserController uc = new UserController();
                String result = uc.CheckLogin(u);
                if (result == null ? lib == null : result.equals(lib)) {
                    LibrarianView lv = new LibrarianView();
                    lv.setVisible(true);
                    this.dispose();
                } else if (result == null ? cus == null : result.equals(cus)) {
                    CustomerView cv = new CustomerView();
                    cv.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, " User does not exist. Please try again.");
                }
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_cust_login_buttonActionPerformed

    private void custLoginExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custLoginExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_custLoginExitButtonActionPerformed

    private void Register_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_ButtonActionPerformed
        RegisterView rv = new RegisterView("customer");
        
        rv.setVisible(true);
    }//GEN-LAST:event_Register_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginLbl;
    private javax.swing.JLabel Password_label;
    private javax.swing.JPasswordField Password_txtField;
    private javax.swing.JToggleButton Register_Button;
    private javax.swing.JLabel Username_label;
    private javax.swing.JTextField Username_txtfield;
    private javax.swing.JButton custLoginExitButton;
    private javax.swing.JButton cust_login_button;
    // End of variables declaration//GEN-END:variables

}
