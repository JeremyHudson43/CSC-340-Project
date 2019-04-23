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
        this.registerView.registerListener((e -> {
            try {
                checkRegister(_usertype, registerView.getName(), registerView.getUserID(), 
                        registerView.getUserPassword(), registerView.getUserEmail());

            } catch (Exception ex) {
                Logger.getLogger(UserController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }));
    }

    //This displays the login view and logs the relevant user type in.
    public void displayLogin() {
        
        this.loginView.setVisible(true);
        this.loginView.loginListener(e -> checkLogin(loginView.username(), loginView.password()));
    }

    public void displayLibraryCard(String _username, String _password) {
        libraryCardView.setVisible(true);
        libraryCardView.printListener(e -> {
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
            Barcode barcode = translator.createBarcode(_userID, _name );
            BufferedImage image = BarcodeImageHandler.getImage(barcode);
            libraryCardView.setBarCode(new ImageIcon(image));
            libraryCardView.setNameField(_name);
        } catch (BarcodeException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
        displayLibraryCard(_userID, _name);
    }

}
