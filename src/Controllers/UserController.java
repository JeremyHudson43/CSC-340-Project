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
public class UserController  {

    private final UserModel userModel = new UserModel();
    private RegisterView registerView = new RegisterView();
    private LoginView loginView = new LoginView();
    private LibrarianView librarianView = new LibrarianView();
    private CustomerView customerView = new CustomerView();
    private LibraryManagementGUI libraryManagement = new LibraryManagementGUI();



    
    //This adds listeners to the main login and register buttons.
    public void initUserController() {

        this.libraryManagement.setVisible(true);
        this.libraryManagement.addLoginListener(e -> displayLogin());
        this.libraryManagement.addRegisterListener(e -> displayRegister());
        //librarianView.customerSearchListener(e -> displayBookDB());

    }

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
        this.loginView.loginButton().addActionListener(e ->
                checkLogin(loginView.username(), loginView.password()));
    }

    //This checks for customer or librarian user type.
    public void checkLogin(String _username, String _password) {

        BooksController bookController = new BooksController();
        
        String userType = userModel.checkLogin(_username, _password);
        if (userType.equals("customer")) {
            bookController.initControllerForCustomer();
            //customerView.setVisible(true);
        } else if (userType.equals("librarian")) {
                        bookController.initControllerForLibrarian();

            //librarianView.setVisible(true);

        }

    }

    //This is a helper method for the register view.
    public void checkRegister(UserModel _user, String _name, String _userID,
            String _password, String _email) throws Exception {
        userModel.checkRegister(_user, _name, _password, _userID, _email);
    }

}