package Views;

import Controllers.UserController;
import Controllers.ViewsController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Models.UserModel;
import SQL_Translator.MySQLDBTranslator;

/**
 *
 * @author Jeremy Hudson
 * @author Charles Brady
 *
 * This class allows a user to login. It will check if the user is a librarian
 * or a customer, and direct them to the appropriate page.
 *
 * Last updated 3/5
 */
public class LoginView extends javax.swing.JFrame {

    private static final String librarian = "librarian";
    private static final String customer = "customer";
    
    ViewsController viewController = new ViewsController();

    /**
     * Creates new form CustomerLogin
     */
    public LoginView() {
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
        login_button = new javax.swing.JButton();
        LoginLbl = new javax.swing.JLabel();
        custLoginExitButton = new javax.swing.JButton();
        Username_label = new javax.swing.JLabel();
        Password_label = new javax.swing.JLabel();
        Password_txtField = new javax.swing.JPasswordField();
        register_Button = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        login_button.setText("Login");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
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

        register_Button.setText("Register");
        register_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_ButtonActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Username_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Username_txtfield))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(custLoginExitButton)
                        .addGap(18, 18, 18)
                        .addComponent(register_Button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(login_button)
                .addGap(19, 19, 19))
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
                    .addComponent(login_button)
                    .addComponent(register_Button))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed

        try {
            
            LoginView loginView = new LoginView();
            UserModel userModel = new UserModel();
            UserController userController = new UserController(userModel, loginView);
            userController.initView(Username_txtfield.getText(), 
                    Password_txtField.getText() );
            

        } catch (Exception ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   /*
        }
    }//GEN-LAST:event_login_buttonActionPerformed
*/
    // Exit the program and shut off the system
    private void custLoginExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custLoginExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_custLoginExitButtonActionPerformed

    /*This will open the registration screen so the user can sign up.
    * The usertype is set to customer because only librarians can register other librarians
     */
    private void register_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_ButtonActionPerformed
       viewController.determineView("RegisterCustomer");
    }//GEN-LAST:event_register_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginLbl;
    private javax.swing.JLabel Password_label;
    private javax.swing.JPasswordField Password_txtField;
    private javax.swing.JLabel Username_label;
    private javax.swing.JTextField Username_txtfield;
    private javax.swing.JButton custLoginExitButton;
    private javax.swing.JButton login_button;
    private javax.swing.JToggleButton register_Button;
    // End of variables declaration//GEN-END:variables

}
