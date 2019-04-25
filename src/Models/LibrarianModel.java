package Models;

import API.APITranslator;
import API.ApiConnector;
import Views.CheckoutView;
import java.util.logging.Level;
import java.util.logging.Logger;


/* @author Jeremy Hudson
   @author Charles Brady

   Last updated 4-22-2019

   This class provides the logic that allows a librarian to checkout books by 
   ISBN, checkin books by ISBN, add a book to the SQL database and to contact
   the API with an ISBN or by author/title to add a book to the local database.

 */
public class LibrarianModel extends BooksModel {

    protected final static ApiConnector myAPI = new APITranslator();

    //This checks out a book and links the book to a user.
    public void checkOutBooksByISBN(String[] _isbn, String _userID) {

        try {
            this.sqlCaller.checkoutBooks(_isbn, _userID);

        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    //This checks in a book and removes it from the user's account.
    public void checkInBooksByISBN(String[] _isbn, String _userID) {

        try {
            this.sqlCaller.checkinBooks(_isbn, _userID);

        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    //Add a book to the database.
    public void addBook(BooksModel _b) {
        this.sqlCaller.addBooks(_b);
    }

    //Remove a book from the database.
    public int removeBook(BooksModel _b) {
        int res = this.sqlCaller.removeBooks(_b.getISBN());
        return res;
    }

    //This searches the API by ISBN.
    public void loadBookByISBN(String _isbn) throws Exception {

        String bookData[][] = this.myAPI.loadBookNameByISBN(_isbn);

        for (int i = 0; i < bookData.length; i++) {

            BooksModel book = buildBook(bookData[i][1], bookData[i][0], "", bookData[i][2], "");
            addBook(book);

        }
    }

    //This searches the API by book title and or author.
    public void loadBookNameByAuthorAndTitle(String _author, String _title) throws Exception {

        String bookData[][] = this.myAPI.loadBookNameByAuthorAndTitle(_author, _title);
        
        for (int i = 0; i < bookData.length; i++) {

            BooksModel book = buildBook(bookData[i][1], bookData[i][0], "", bookData[i][2], "");
            addBook(book);

        }
    }

}
