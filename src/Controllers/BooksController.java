package Controllers;

import Models.BooksModel;
import Views.AddBookView;
import Views.BookDatabaseView;
import Views.CheckinView;
import Views.CheckoutView;
import Views.CustomerView;
import Views.LibrarianView;
import Views.LibraryManagementGUI;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last Updated 4/5
 *
 * This is the controller for the books class
 */
public class BooksController extends MasterController {

    private BooksModel bookModel;
    private BookDatabaseView bookDBView;
    private AddBookView addBookView;
    private CheckoutView checkoutView;
    private CheckinView checkinView;

    public BooksController(LibrarianView librarianView,
            CustomerView customerView,
            LibraryManagementGUI libraryManagement, BooksModel bookModel,
            BookDatabaseView bookDBview, AddBookView addBookView,
            CheckinView checkinview, CheckoutView checkoutview) {

        super(librarianView, customerView, libraryManagement);

        this.bookModel = bookModel;
        this.bookDBView = bookDBview;
        this.checkinView = checkinview;
        this.checkoutView = checkoutview;
    }

    public BooksController(LibrarianView librarianView) throws SQLException {
        this.librarianView = librarianView;
        initController();
    }

    public BooksController(CustomerView customerView) throws SQLException {
        this.customerView = customerView;
        initController();
    }

    public void initController()
            throws SQLException {

        librarianView.databaseListener(e -> displayBookDB());
//        librarianView.bookAddListener(e -> displayAddBookView());
        librarianView.checkInListener(e -> displayCheckinView());
        librarianView.checkOutListener(e -> displayCheckoutView());
        librarianView.goToBookListener(e -> displayBookDB());
        customerView.databaseListener(e -> displayBookDB());
        customerView.goToBookListener(e -> displayBookDB());
    }

    public void displayBookDB() {
        bookDBView.setVisible(true);
//          bookModel.setAuthor(_author);
//        bookModel.setTitle(_bookTitle);
//        bookModel.setISBN(_ISBN);
    }

//    private void displayAddBookView(String _author, String _bookTitle, String _ISBN)
//            throws SQLException, Exception {
//        if (_ISBN.equals("")) {
//            bookModel.loadBookNameByAuthorAndTitle(_author, _bookTitle);
//        } else {
//            bookModel.loadBookByISBN(_ISBN);
//        }
//    }


    private void displayIndividualBookView() throws SQLException {
        bookModel.bookDBMethod(bookModel.getAuthor(), bookModel.getTitle(),
                bookModel.getISBN());
    }

    private void displayCheckinView() {
        checkinView.setVisible(true);
        checkinView.CheckinButton.addActionListener(e -> {
            String[] checkinIsbn = checkinView.getISBN();
            String checkinUserID = checkinView.getUserID();
            bookModel.checkInBooksByISBN(checkinIsbn, checkinUserID);
        });
    }

    private void displayCheckoutView() {
        checkoutView.setVisible(true);
        checkoutView.checkoutButton().addActionListener(e -> {
            String[] checkoutIsbn = checkoutView.getISBN();
            String checkoutUserID = checkoutView.getUserID();
            bookModel.checkOutBooksByISBN(checkoutIsbn, checkoutUserID);
        });

    }

}
