package Models;

import API.APITranslator;
import API.ApiConnector;
import Views.CheckoutView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jeremy Hudson
 * @author Charles Brady
 *
 * Last updated 5-3-2019
 *
 * This class provides the logic that allows a librarian to checkout books by
 * ISBN, check-in books by ISBN, add a book to the SQL database and to contact
 * the API with an ISBN or by author/title to add a book to the local database.
 *
 */
public class LibrarianModel extends BooksModel {

    protected final static ApiConnector myAPI = new APITranslator();

    /**
     * This method checks out a book and links it to the user.
     *
     * @param _isbn
     * @param _userID
     */
       public int checkOutBooksByISBN(List<String> _isbn, String _userID) {
        try {
            int result = this.sqlCaller.checkoutBooks(_isbn, _userID);
            if (result > 0) {
                return result;
            } else {
                return result;
            }
        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * This checks in a book and changes the status checked in user's account.
     *
     * @param _isbn
     * @param _userID
     */
     public int checkInBooksByISBN(List<String> _isbn, String _userID) {
        try {
           int result = this.sqlCaller.checkinBooks(_isbn, _userID);
            return result;
        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * This method add a book to the database.
     *
     * @param _b
     */
    public void addBook(BooksModel _b) {
        int result = 0;
        result = this.sqlCaller.addBooks(_b);

    }

    /**
     * This method loads the information of the book by ISBN.
     *
     * @param _isbn
     * @throws Exception
     */
    public void callForBookByISBN(String _isbn) {

        String bookData[][] = this.myAPI.loadBookNameByISBN(_isbn);

        for (int i = 0; i < bookData.length; i++) {
            try {
                BooksModel book = buildBook(bookData[i][1], bookData[i][0], bookData[i][2], bookData[i][3], bookData[i][4]);
                addBook(book);
            } catch (Exception ex) {
                Logger.getLogger(LibrarianModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method searches the API for a book by the title and/or author.
     *
     * @param _author
     * @param _title
     * @throws Exception
     */
    public void callForBookNameByAuthorAndTitle(String _author, String _title) {

        String bookData[][] = this.myAPI.loadBookNameByAuthorAndTitle(_author, _title);

        for (int i = 0; i < bookData.length; i++) {
            try {
                BooksModel book = buildBook(bookData[i][1], bookData[i][0], bookData[i][2], bookData[i][3], bookData[i][4]);
                addBook(book);
            } catch (Exception ex) {
                Logger.getLogger(LibrarianModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
