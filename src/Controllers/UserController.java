package Controllers;

import BarcodeTranslator.BarcodeTranslator;
import Models.UserModel;
import Views.LibraryCardView;
import Views.LoginView;
import Views.RegisterView;
import java.awt.image.BufferedImage;
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
 * Last updated 4-22-2019
 *
 * This class routes the logic to display the registerView for a certain user
 * type, display the login view, display the library card view, and check the
 * validity of a user login or registration to the UserModel.
 */
public class UserController {

    private final UserModel userModel = new UserModel();
    private RegisterView registerView = new RegisterView();
    private LoginView loginView = new LoginView();
    LibraryCardView libraryCardView = new LibraryCardView();

    //This opens the register view and registers a user if their info is valid.
    public void displayRegister(String _usertype) {

        this.registerView.setVisible(true);
        this.registerView.registerListener((e -> {
            try {
                checkRegister(_usertype, this.registerView.getName(), this.registerView.getUserID(),
                        this.registerView.getUserPassword(), this.registerView.getUserEmail());

            } catch (Exception ex) {
                Logger.getLogger(UserController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }));
    }

    //This displays the login view and logs the relevant user type in.
    public void displayLogin() {

        this.loginView.setVisible(true);
        this.loginView.loginListener(e -> checkLogin(this.loginView.getUsername(), this.loginView.getPassword()));
    }

    public void displayLibraryCard(String _username, String _password) {
        this.libraryCardView.setVisible(true);

        this.libraryCardView.printListener(e -> {
            try {
                printCard(_username, _password);
            } catch (OutputException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

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

    //This checks for customer or librarian user type.
    public void checkLogin(String _username, String _password) {

        String userType = this.userModel.checkLogin(_username, _password);
        if (userType.equals("customer")) {
            CustomerController customerController = new CustomerController();
            customerController.initCustomerController();

        } else if (userType.equals("librarian")) {
            LibrarianController librarianController = new LibrarianController();
            librarianController.initLibrarianController();

        }

    }

    //This is a helper method for the register view.
    public void checkRegister(String _usertype, String _name, String _userID,
            String _password, String _email) throws Exception {

        this.userModel.checkRegister(_usertype, _name, _password, _userID, _email);
        displayLibraryCard(_userID, _name);
    }

}
