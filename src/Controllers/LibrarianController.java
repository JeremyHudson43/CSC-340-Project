package Controllers;

import Models.LibrarianModel;
import Models.UserModel;
import Views.AddBookView;
import Views.CheckinView;
import Views.CheckoutView;
import Views.IndividualUserView;
import Views.LibrarianView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jeremy Hudson
 *
 * Last updated 4-22-2019
 *
 * This class routes the logic for book checkouts, book check-ins, addBooks and
 * individual user display to the LibrarianModel. In addition it displays the
 * checkout, check-in, addBooks and individualUserDisplay views themselves,
 */
public class LibrarianController extends BooksController {

    private LibrarianView librarianView = new LibrarianView();
    private LibrarianModel librarianModel = new LibrarianModel();
    private UserController userController = new UserController();
    private UserModel user = new UserModel();
    private IndividualUserView individualUserView = new IndividualUserView();

    /**
     * This tells the librarian view buttons what method to call when pressed.
     *
     *
     *
     */
    public void initLibrarianController() {
        this.librarianView.setVisible(true);

        this.librarianView.databaseListener(e -> displayAndSearchBookDB());
        this.librarianView.bookAddListener(e -> displayAddBookView());
        this.librarianView.librarianAddListener(e -> userController.displayRegister("librarian"));
        this.librarianView.userSearchListener(e -> userDisplay());
        this.librarianView.checkInListener(e -> displayCheckInView());
        this.librarianView.checkOutListener(e -> displayCheckOutView());
    }

    /**
     * This displays the check-in view.
     *
     *
     */
    private void displayCheckInView() {
        CheckinView checkInView = new CheckinView();

        checkInView.setVisible(true);
        checkInView.checkinListener(e -> checkIn(checkInView.getISBN(), checkInView.getUserID()));
    }

    /**
     * This checks book back into the database from the librarian model.
     *
     *
     */
    private void checkIn(List<String> _isbn, String _userID) {
        this.librarianModel.checkInBooksByISBN(_isbn, _userID);
    }

    /**
     * This displays the checkout view.
     *
     *
     */
    private void displayCheckOutView() {
        CheckoutView checkOutView = new CheckoutView();

        checkOutView.setVisible(true);
        checkOutView.checkOutListener(e -> checkOut(checkOutView.getISBN(), checkOutView.getUserID()));
    }

    /**
     * This gets the userID and ISBNs from checkoutView and contacts the mode to
     * checkout the books in the database
     *
     *
     */
    private void checkOut(List<String> _isbn, String _userID) {
        this.librarianModel.checkOutBooksByISBN(_isbn, _userID);
    }

    /**
     * This displays the add book view.
     *
     *
     *
     */
    private void displayAddBookView() {
        AddBookView addBookView = new AddBookView();
        addBookView.setVisible(true);
        
        addBookView.addBookListener(e -> addBooks(addBookView.getAuthor(),addBookView.getBookTitle(), addBookView.getISBN()));
    }

    /**
     * This gets book info from the API by title and author or by ISBN.
     *
     *
     */
    private void addBooks(String _author, String _title, String _isbn) {
        try {
            if (_isbn.equals("")) {
                this.librarianModel.callForBookNameByAuthorAndTitle(_author, _title);

            } else {
                this.librarianModel.callForBookByISBN(_isbn);
            }
        } catch (Exception ex) {
            Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This displays individual customer information.
     *
     *
     */
    private void userDisplay() {

        this.user = this.user.searchUser(this.librarianView.getUserSearchTextField());

        this.individualUserView.setUsersName(user.getName());
        this.individualUserView.setUserEmail(user.getEmail());
        this.individualUserView.setUserID(user.getUserId());
        this.individualUserView.setUserType(user.getUserType());
        
        this.individualUserView.setVisible(true);

    }
}
