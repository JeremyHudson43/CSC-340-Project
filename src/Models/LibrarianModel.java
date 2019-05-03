package Models;

import API.APITranslator;
import API.ApiConnector;
import Views.CheckoutView;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 * @author Jeremy Hudson
 * @author Charles Brady Last updated 5-1-2019
 */
public class LibrarianModel extends BooksModel {

    protected final static ApiConnector myAPI = new APITranslator();

    /**
     * This method checks out a book and links it to the user.
     *
     * @param _isbn
     * @param _userID
     */
    public void checkOutBooksByISBN(List<String> _isbn, String _userID) {

        try {

            this.sqlCaller.checkoutBooks(_isbn, _userID);
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
    public void checkInBooksByISBN(List<String> _isbn, String _userID) {

        try {

            this.sqlCaller.checkinBooks(_isbn, _userID);
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

        this.sqlCaller.addBooks(_b);

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
