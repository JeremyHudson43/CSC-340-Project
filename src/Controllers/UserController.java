package Controllers;

import Models.Printer;
import Models.UserModel;
import Views.LibraryCardView;
import Views.LoginView;
import Views.RegisterView;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last updated 4-22-2019
 */
public class UserController {

    private final UserModel userModel = new UserModel();
    private RegisterView registerView = new RegisterView();
    private LoginView loginView = new LoginView();
    LibraryCardView libraryCardView = new LibraryCardView();

    //This opens the register view and registers a user if their info is valid.
    public void displayRegister(String _usertype) {
        String name = registerView.getName();
        String userId = registerView.getUserID();
        String password = registerView.getUserPassword();
        String userEmail = registerView.getUserEmail();

        this.registerView.setVisible(true);
        this.registerView.registerButton().addActionListener(e -> {
            try {
                checkRegister(_usertype, name, userId, password, userEmail);

            } catch (Exception ex) {
                Logger.getLogger(UserController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    //This displays the login view and logs the relevant user type in.
    public void displayLogin() {
        
        String username = loginView.username();
        String password = loginView.password();
        this.loginView.setVisible(true);
        this.loginView.loginButton().addActionListener(e -> checkLogin(username, password));
    }

    public void displayLibraryCard(UserModel _user) throws OutputException {
        libraryCardView.setVisible(true);
        libraryCardView.printListener(e -> printCard(libraryCardView));

    }

    public void printCard(LibraryCardView _libraryCardView) {
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat format = job.defaultPage();
        job.setPrintable(new Printer(_libraryCardView, 0.75));
        if (job.printDialog()) {
            try {
                job.print();
                _libraryCardView.dispose();
            } catch (PrinterException ex) {
                Logger.getLogger(LibraryCardView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    public void checkRegister(String _usertype, String _name, String _userID,
            String _password, String _email) throws Exception {
        userModel.checkRegister(_usertype, _name, _password, _userID, _email);
    }

}
