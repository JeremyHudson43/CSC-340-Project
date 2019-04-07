package Controllers;

import Models.UserModel;
import Views.BookDatabaseView;
import Views.CustomerView;
import Views.LibrarianView;
import Views.LibraryManagementGUI;
import Views.LoginView;
import Views.RegisterView;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last updated 4/5
 */
public class UserController extends ParentController {

    private UserModel userModel;
    private RegisterView registerView;
    private LoginView loginView;


    public UserController(LibrarianView librarianView, 
               CustomerView customerView, 
               LibraryManagementGUI libraryManagement,
               UserModel userModel, 
               LoginView loginView,
            RegisterView registerView 
            ) {
        
        super(librarianView, customerView, libraryManagement);

        this.userModel = userModel;
        this.registerView = registerView;
        this.loginView = loginView;
        this.libraryManagement = libraryManagement;

    }
    



    public void initUserController() {
        
        libraryManagement.addLoginListener(e -> displayLogin());
        libraryManagement.addRegisterListener(e -> displayRegister());
        //librarianView.customerSearchListener(e -> displayBookDB());

    }

    public void displayRegister() {
        registerView.setVisible(true);
        registerView.registerButton().addActionListener(e -> {
            try {
                checkRegister(registerView.userType(userModel),
                        registerView.getName(), registerView.getUserID(),
                        registerView.getUserPassword(), 
                        registerView.getUserEmail());
            } catch (Exception ex) {
                Logger.getLogger(UserController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    public void displayLogin() {
        loginView.setVisible(true);
        loginView.loginButton().addActionListener
        (e -> {
            try {
                checkLogin(loginView.username(), loginView.password());
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    public void checkLogin(String username, String password) throws SQLException {

        String userType = userModel.checkLogin(username, password);
        if(userType.equals("customer")) {
            customerView.setVisible(true);
        }
        else if(userType.equals("librarian")) {
          librarianView.setVisible(true);


          
          
    }
        


    }

    public void checkRegister(UserModel user, String name, String userID,
            String password, String email) throws Exception {
        userModel.checkRegister(user, name, password, userID, email);
    }

}
