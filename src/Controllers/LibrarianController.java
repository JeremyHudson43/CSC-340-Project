package Controllers;

import Models.LibrarianModel;
import Models.UserModel;
import Views.AddBookView;
import Views.CheckinView;
import Views.CheckoutView;
import Views.IndividualUserView;
import Views.LibrarianView;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Jeremy Hudson

   Last updated 4-22-2019
    
   This class routes the logic for book checkouts, book checkins, addBooks and 
   individual user display to the LibrarianModel. In addition it displays the 
   checkout, checkin, addbooks and individual user display views themselves, 
 */
public class LibrarianController extends BooksController {

    private LibrarianView librarianView = new LibrarianView();
    private LibrarianModel librarianModel = new LibrarianModel();
    private UserController userController = new UserController();
    private UserModel user = new UserModel();
    private CheckinView checkInView = new CheckinView();
    private AddBookView addBookView = new AddBookView();
    private CheckoutView checkoutView = new CheckoutView();
    private IndividualUserView individualUserView = new IndividualUserView();

    //This tells the librarian view buttons what method to call when pressed
    public void initLibrarianController() {
        this.librarianView.setVisible(true);

        this.librarianView.databaseListener(e -> displayBookDB());
        this.librarianView.bookAddListener(e -> displayAddBookView());
        this.librarianView.librarianAddListener(e -> userController.displayRegister("librarian"));
        this.librarianView.userSearchListener(e -> userDisplay());
        this.librarianView.checkInListener(e -> displayCheckInView());
        this.librarianView.checkOutListener(e -> displayCheckOutView());
    }

    /**This gets the userID and ISBNs from checkoutView and contacts the model to
    checkout the books in the database
    * 
    * 
    */
    private void checkOut() {
        String userID = this.checkoutView.getUserID();
        String isbn1 = this.checkoutView.getISBN1();
        String isbn2 = this.checkoutView.getISBN2();
        String isbn3 = this.checkoutView.getISBN2();
        String isbn4 = this.checkoutView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};

        this.librarianModel.checkOutBooksByISBN(isbn, userID);

    }

    /**This displays the checkin view.
    *
    *
    */
    private void displayCheckInView() {
        this.checkInView.setVisible(true);
        this.checkInView.checkinListener(e -> checkIn());
    }

    /** This checks book back into the database from the librarian model.
    *
    *
    */
    private void checkIn() {
        String userID = this.checkInView.getUserID();
        String isbn1 = this.checkInView.getISBN1();
        String isbn2 = this.checkInView.getISBN2();
        String isbn3 = this.checkInView.getISBN2();
        String isbn4 = this.checkInView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};
        this.librarianModel.checkInBooksByISBN(isbn, userID);

    }

    /** This displays the checkout view.
    *
    *
     */
    private void displayCheckOutView() {
        this.checkoutView.setVisible(true);
        this.checkoutView.checkOutListener(e -> checkOut());
    }

    /** This displays the add book view.
     *
     *
     *
     */
    private void displayAddBookView() {
        this.addBookView.setVisible(true);
        this.addBookView.addBookListener(e -> addBooks());
    }

    /** This gets book info from the API by title and author or by ISBN.
    *
    *
    */
    private void addBooks() {
        String author = this.addBookView.getAuthor();
        String title = this.addBookView.getTitle();
        String ISBN = this.addBookView.getISBN();

        try {
            if (ISBN.equals("")) {
                this.librarianModel.loadBookNameByAuthorAndTitle(author, title);

            } else {
                this.librarianModel.loadBookByISBN(ISBN);
            }
        } catch (Exception ex) {
            Logger.getLogger(LibrarianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This displays individual customer information.
    *
    *
    */
    private void userDisplay() {

        this.user = this.userModel.searchUser(this.librarianView.getUserSearchTextField());

        this.individualUserView.setUsersName(user.getName());
        this.individualUserView.setUserEmail(user.getEmail());
        this.individualUserView.setUserID(user.getUserId());
        this.individualUserView.setUserType(user.getUserType());
        this.individualUserView.setVisible(true);

    }
}
