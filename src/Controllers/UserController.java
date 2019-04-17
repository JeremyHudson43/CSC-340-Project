package Controllers;

import Models.UserModel;
import Views.LoginView;
import Views.RegisterView;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last updated 4/5
 */
public class UserController {

    private final UserModel userModel = new UserModel();
    private RegisterView registerView = new RegisterView();
    private LoginView loginView = new LoginView();


    //This opens the register view and registers a user if their info is valid.
    public void displayRegister() {
        this.registerView.setVisible(true);
        this.registerView.registerButton().addActionListener(e -> {
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

    //This displays the login view and logs the relevant user type in.
    public void displayLogin() {
        this.loginView.setVisible(true);
        this.loginView.loginButton().addActionListener(e
                -> checkLogin(loginView.username(), loginView.password()));
    }

    //This checks for customer or librarian user type.
    public void checkLogin(String _username, String _password) {

        LibrarianController librarianController = new LibrarianController();
        CustomerController customerController = new CustomerController();

        String userType = userModel.checkLogin(_username, _password);
        if (userType.equals("customer")) {
            customerController.initCustomerController();

        } else if (userType.equals("librarian")) {
            librarianController.initLibrarianController();

        }

    }

    //This is a helper method for the register view.
    public void checkRegister(UserModel _user, String _name, String _userID,
            String _password, String _email) throws Exception {
        userModel.checkRegister(_user, _name, _password, _userID, _email);
    }

}
