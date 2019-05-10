package Controllers;

import BarcodeTranslator.BarcodeTranslator;
import Models.PrinterModel;
import Models.UserModel;
import Views.LibraryCardView;
import Views.LoginView;
import Views.NotificationPopupView;
import Views.RegisterView;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last updated 5-3-2019
 *
 * This class routes the logic to display the registerView for a certain user
 * type, display the login view, display the library card view, and check the
 * validity of a user login or registration to the UserModel.
 */
public class UserController {

    private static final String LIBRARIAN = "librarian";
    private static final String CUSTOMER = "customer";

    private LibraryCardView libraryCardView = new LibraryCardView();

    /**
     * This opens the register view and registers a user if their info is valid.
     *
     *
     *
     */
    public void displayRegister(String _usertype) {

        RegisterView registerView = new RegisterView();

        registerView.setVisible(true);
        registerView.registerListener(e -> checkRegister(_usertype, registerView.getName(),
        registerView.getUserID(), registerView.getUserPassword(), registerView.getUserEmail()));
        
        registerView.registerListener(e -> registerView.dispose());
    }

    /**
     * This displays the login view and logs the relevant user type in.
     *
     *
     *
     */
    public void displayLogin() {
        LoginView loginView = new LoginView();

        loginView.setVisible(true);
        loginView.loginListener(e -> checkLogin(loginView.getUsername(), loginView.getPassword()));
        
        loginView.loginListener(e -> loginView.dispose());
        
        
    }

    /**
     * This opens the library card view and prints the bar code when the print
     * button is clicked.
     *
     *
     *
     */
    public void displayLibraryCard(String _id, String _name) {
        this.libraryCardView.setVisible(true);
        try {
            this.printCard(_id, _name);
        } catch (OutputException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.libraryCardView.printListener(e -> {

            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(new PrinterModel(this.libraryCardView, 0.75));
            if (job.printDialog()) {

                try {
                    job.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(LibraryCardView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * This prints out a bar code with user information to the library card
     * view.
     *
     *
     */
    public void printCard(String _userID, String _name) throws OutputException {

        try {
            BarcodeTranslator translator = new BarcodeTranslator();
                Barcode barcode = translator.createBarcode(_userID, _name);
                BufferedImage image = BarcodeImageHandler.getImage(barcode);
                this.libraryCardView.setBarCode(new ImageIcon(image));
                this.libraryCardView.setNameField(_name);
            
        } catch (BarcodeException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This checks for customer or librarian user type.
     *
     *
     */
    public void checkLogin(String _username, String _password) {

        UserModel userModel = new UserModel();
        String userType = userModel.checkLogin(_username, _password);
        
        if (userType.equals(this.CUSTOMER)) {
            CustomerController customerController = new CustomerController();
            customerController.initCustomerController();
            
        } else if (userType.equals(this.LIBRARIAN)) {
            LibrarianController librarianController = new LibrarianController();
            librarianController.initLibrarianController();
            
        } else {
            NotificationPopupView popUp = new NotificationPopupView();
            popUp.setMessage("Invalid login credentials.");
            popUp.setVisible(true);
        }
    }

    /**
     * This is a helper method for the register view.
     *
     *
     */
    public void checkRegister(String _usertype, String _name, String _userID,
            String _password, String _email) {

        UserModel userModel = new UserModel();

        int result = userModel.checkRegister(_usertype, _name, _password, _userID, _email);
        
        NotificationPopupView popUp = new NotificationPopupView();
        if (result > 0) {
            popUp.setMessage("Account created");
            popUp.setVisible(true);
            displayLibraryCard(_userID, _name);
        } else {
            popUp.setMessage("Unable to create account, please check that all fields have been entered and that you have entered a valid email address.");
            popUp.setVisible(true);
        }


    }
}
