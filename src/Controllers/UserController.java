package Controllers;

import Models.UserModel;
import Views.CustomerView;
import Views.LibrarianView;
import Views.LibraryManagementGUI;
import Views.LoginView;
import Views.RegisterView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    //adds listenres to main login and register buttons
    public void initUserController() {

        libraryManagement.addLoginListener(e -> displayLogin());
        libraryManagement.addRegisterListener(e -> displayRegister());
        //librarianView.customerSearchListener(e -> displayBookDB());

    }

    //opens register view and registers user if info is valid
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

    //displays login view and logs the relevant user type in
    public void displayLogin() {
        loginView.setVisible(true);
        loginView.loginButton().addActionListener(e -> {
            try {
                checkLogin(loginView.username(), loginView.password());
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    //checks for customer or librarian
    public void checkLogin(String username, String password) throws SQLException {

        String userType = userModel.checkLogin(username, password);
        if (userType.equals("customer")) {
            customerView.setVisible(true);
        } else if (userType.equals("librarian")) {
            librarianView.setVisible(true);

        }

    }

    //helper method for register view
    public void checkRegister(UserModel user, String name, String userID,
            String password, String email) throws Exception {
        userModel.checkRegister(user, name, password, userID, email);
    }

}
