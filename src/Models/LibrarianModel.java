package Models;

import API.APITranslator;
import API.ApiConnector;
import Views.CheckoutView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/* @author Jeremy Hudson
   @author Charles Brady

   Last updated 4-22-2019

   This class provides the logic that allows a librarian to checkout books by 
   ISBN, checkin books by ISBN, add a book to the SQL database and to contact
   the API with an ISBN or by author/title to add a book to the local database.

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
     public void loadBookByISBN(String _isbn)  {

        String bookData[][] = this.myAPI.loadBookNameByISBN(_isbn);

        for (int i = 0; i < bookData.length; i++) {
            try {
                BooksModel book = buildBook(bookData[i][1], bookData[i][0], bookData[i][2], bookData[i][3]);
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
   //This searches the API by book title and or author.
    public void loadBookNameByAuthorAndTitle(String _author, String _title) {

        String bookData[][] = this.myAPI.loadBookNameByAuthorAndTitle(_author, _title);
        
        for (int i = 0; i < bookData.length; i++) {
            try {
                BooksModel book = buildBook(bookData[i][1], bookData[i][0],  bookData[i][2], bookData[i][3]);
                addBook(book);
            } catch (Exception ex) {
                Logger.getLogger(LibrarianModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
