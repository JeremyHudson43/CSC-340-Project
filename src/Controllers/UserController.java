package Controllers;

import BarcodeTranslator.BarcodeTranslator;
import Models.Printer;
import Models.UserModel;
import Views.LibraryCardView;
import Views.LoginView;
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
 * Last updated 4-24-2019
 */
public class UserController {

    private static final String LIBRARIAN = "librarian";
    private static final String CUSTOMER = "customer";

    private final UserModel userModel = new UserModel();
    private RegisterView registerView = new RegisterView();
    private LoginView loginView = new LoginView();
    LibraryCardView libraryCardView = new LibraryCardView();

    /**
     * This method opens the register view and registers a user if their info is
     * valid.
     *
     * @param _usertype
     */
    public void displayRegister(String _usertype) {

        String name = this.registerView.getName();
        String userId = this.registerView.getUserID();
        String password = this.registerView.getUserPassword();
        String userEmail = this.registerView.getUserEmail();

        this.registerView.setVisible(true);
        this.registerView.registerListener((e -> {

            try {

                checkRegister(_usertype, name, userId, password, userEmail);

            } catch (Exception ex) {

                Logger.getLogger(UserController.class.getName())
                        .log(Level.SEVERE, null, ex);

            }
        }));

    }

    /**
     * This method displays the login view and logs the relevant user type in.
     */
    public void displayLogin() {

        this.loginView.setVisible(true);
        this.loginView.loginListener(e -> checkLogin(this.loginView.username(), this.loginView.password()));

    }

    /**
     * This method displays the library card view with the username and password
     * given.
     *
     * @param _username
     * @param _password
     */
    public void displayLibraryCard(String _username, String _password) {

        this.libraryCardView.setVisible(true);
        try {

            this.printCard(_username, _password);

        } catch (OutputException ex) {

            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.libraryCardView.printListener(e -> {

            PrinterJob job = PrinterJob.getPrinterJob();
            //PageFormat pf = job.defaultPage();
            job.setPrintable(new Printer(this.libraryCardView, 0.75));
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
     * This method prints the library card for the user.
     *
     * @param _userID
     * @param _name
     * @throws OutputException
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
     * This method checks the user type to see if the user's type is customer or
     * librarian
     *
     * @param _username
     * @param _password
     */
    public void checkLogin(String _username, String _password) {

        LibrarianController librarianController = new LibrarianController();
        CustomerController customerController = new CustomerController();

        String userType = this.userModel.checkLogin(_username, _password);
        if (userType.equals("customer")) {
            customerController.initCustomerController();

        } else if (userType.equals("librarian")) {
            librarianController.initLibrarianController();
        }
    }

    /**
     * This is a helper method for the register view.
     *
     * @param _usertype
     * @param _name
     * @param _userID
     * @param _password
     * @param _email
     * @throws Exception
     */
    public void checkRegister(String _usertype, String _name, String _userID,
            String _password, String _email) throws Exception {

        this.userModel.checkRegister(_usertype, _name, _password, _userID, _email);
        displayLibraryCard(_userID, _name);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        UserModel testUser1 = new UserModel();
        UserModel testUser2 = new UserModel();
        UserModel testUser3 = new UserModel();
        UserModel testUser4 = new UserModel();

        int test1 = 0;
        int test2 = 0;
        int test3 = 0;
        int test4 = 0;

        testUser1.setName("Michael");
        testUser1.setId("23456789");
        testUser1.setPassword("angelo");
        testUser1.setUserType(CUSTOMER);

        testUser2.setName("2343");
        testUser2.setId("11122233");
        testUser2.setPassword("324");
        testUser2.setUserType(CUSTOMER);

        testUser3.setName("Billy");
        testUser3.setId("4");
        testUser3.setPassword("sink");
        testUser3.setUserType(LIBRARIAN);

        testUser4.setName("");
        testUser4.setId("");
        testUser4.setPassword("");
        testUser4.setUserType("");

        test1 = UserModel.createAccount(testUser1);
        test2 = UserModel.createAccount(testUser2);
        test3 = UserModel.createAccount(testUser3);
        test4 = UserModel.createAccount(testUser4);

        if (test1 > 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        if (test2 > 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        if (test3 > 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        if (test4 > 0) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
