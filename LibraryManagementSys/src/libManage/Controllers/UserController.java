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
 * @author Charles Bradcy
 * @author Jeremy Hudson
 *
 * Last updated 4/5
 */
public class UserController {

    private final UserModel userModel = new UserModel();
    private RegisterView registerView = new RegisterView();
    private LoginView loginView = new LoginView();

    //This opens the register view and registers a user if their info is valid.
    public void displayRegister(String _userType) {
        this.registerView.setVisible(true);
        this.registerView.registerButton().addActionListener(e -> {
            try {
                checkRegister(_userType,
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

    public void displayLibraryCard(UserModel _user) throws OutputException {
        LibraryCardView libraryCardView = new LibraryCardView(_user);
        libraryCardView.setVisible(true);
        libraryCardView.printButton().addActionListener(e
                -> printCard(libraryCardView));

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
    public void checkRegister(String _userType, String _name, String _userID,
            String _password, String _email) throws Exception {

        userModel.checkRegister(_userType, _name, _password, _userID, _email);
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
}
