package Models;

import API.APITranslator;
import API.ApiConnector;
import Views.CheckoutView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Jeremy Hudson
 * @author Charles Brady Last updated 4-22-2019
 */
public class LibrarianModel extends BooksModel {

    protected final static ApiConnector myAPI = new APITranslator();

    /**
     * This method checks out a book and links it to the user.
     *
     * @param _isbn
     * @param _userID
     */
    public void checkOutBooksByISBN(String[] _isbn, String _userID) {
        int result = 0;
        try {
            result = this.sqlCaller.checkoutBooks(_isbn, _userID);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Book(s) checked out");

            } else {
                JOptionPane.showMessageDialog(null, "Unable to checkout");
            }
        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This checks in a book and changes the status checked in user's account.
     *
     * @param _isbn
     * @param _userID
     */
    public void checkInBooksByISBN(String[] _isbn, String _userID) {
        int result = 0;
        try {
            result = this.sqlCaller.checkinBooks(_isbn, _userID);
            JOptionPane.showMessageDialog(null, "Book(s) checked in");
        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method add a book to the database.
     *
     * @param _b
     */
    public void addBook(BooksModel _b) {
        int result = 0;
        result = this.sqlCaller.addBooks(_b);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Book(s) added to database");

        } else {
            JOptionPane.showMessageDialog(null, "Error: Book may not be in API");
        }
    }

    /**
     * This method removes a book from the database.
     *
     * @param _b
     * @return
     */
    public void removeBook(BooksModel _b) {
        int result = this.sqlCaller.removeBooks(_b.getISBN());
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Book(s) removed to database");

        } else {
            JOptionPane.showMessageDialog(null, "Error: Book may not be in database");
        }
    }

    /**
     * This method loads the information of the book by ISBN.
     *
     * @param _isbn
     * @throws Exception
     */
    public void loadBookByISBN(String _isbn) throws Exception {

        String bookData[] = this.myAPI.loadBookNameByISBN(_isbn);

        BooksModel book = buildBook(bookData[1], bookData[0], "", bookData[2], "");
        addBook(book);
    }

    /**
     * This method searches the API for a book by the title and/or author.
     *
     * @param _author
     * @param _title
     * @throws Exception
     */
    public void loadBookNameByAuthorAndTitle(String _author, String _title) throws Exception {

        String bookData[] = this.myAPI.loadBookNameByAuthorAndTitle(_author, _title);

        BooksModel book = buildBook(bookData[1], bookData[0], "", bookData[2], "");
        addBook(book);

    }

}
