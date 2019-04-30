package Controllers;

import BarcodeTranslator.BarcodeTranslator;
import Models.PrinterModel;
import Models.UserModel;
import Views.LibraryCardView;
import Views.LoginView;
import Views.RegisterView;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Printer;
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

    private static final String LIBRARIAN = "librarian";
    private static final String CUSTOMER = "customer";

    private final UserModel userModel = new UserModel();
    private RegisterView registerView = new RegisterView();
    private LoginView loginView = new LoginView();
    LibraryCardView libraryCardView = new LibraryCardView();

    /* This opens the register view and registers a user if their info is valid.
     *
     *
     *
     */
    public void displayRegister(String _usertype) {

        this.registerView.setVisible(true);
        this.registerView.registerListener(e -> checkRegister(_usertype, this.registerView.getName(),
                this.registerView.getUserID(), this.registerView.getUserPassword(), this.registerView.getUserEmail()));
    }

    /** This displays the login view and logs the relevant user type in.
    *
    *
    *
     */
    public void displayLogin() {
        this.loginView.setVisible(true);
        this.loginView.loginListener(e -> checkLogin(this.loginView.getUsername(), this.loginView.getPassword()));
    }

    /** This opens the library card view and prints the barcode when the print button is clicked
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

    /** This prints out a bardcode with user information to the library card view.
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

    /** This checks for customer or librarian user type.
    *
    *
    */
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

    /** This is a helper method for the register view.
    *
    *
    */
    public void checkRegister(String _usertype, String _name, String _userID,
            String _password, String _email) {

        this.userModel.checkRegister(_usertype, _name, _password, _userID, _email);
        displayLibraryCard(_userID, _name);
    }

//    public void testCase() {
//        UserModel testUser1 = new UserModel();
//        UserModel testUser2 = new UserModel();
//        UserModel testUser3 = new UserModel();
//        UserModel testUser4 = new UserModel();
//
//        int test1 = 0;
//        int test2 = 0;
//        int test3 = 0;
//        int test4 = 0;
//
//        testUser1.setName("Michael");
//        testUser1.setId("23456789");
//        testUser1.setPassword("angelo");
//        testUser1.setUserType(CUSTOMER);
//
//        testUser2.setName("2343");
//        testUser2.setId("11122233");
//        testUser2.setPassword("324");
//        testUser2.setUserType(CUSTOMER);
//
//        testUser3.setName("Billy");
//        testUser3.setId("4");
//        testUser3.setPassword("sink");
//        testUser3.setUserType(LIBRARIAN);
//
//        testUser4.setName("");
//        testUser4.setId("");
//        testUser4.setPassword("");
//        testUser4.setUserType("");
//
//        test1 = UserModel.createAccount(testUser1);
//        test2 = UserModel.createAccount(testUser2);
//        test3 = UserModel.createAccount(testUser3);
//        test4 = UserModel.createAccount(testUser4);
//
//        if (test1 > 0) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//        }
//
//        if (test2 > 0) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//        }
//
//        if (test3 > 0) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//        }
//
//        if (test4 > 0) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//        }
//
//    }
}
