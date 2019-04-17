
package Models;

import Views.CheckoutView;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


public class LibrarianModel extends BooksModel {
        
         //placeholder method for checkout logic
    public void checkOutBooksByISBN(String[] _isbn, String _userID) {

        try {
            sqlCaller.checkoutBooks(_isbn, _userID);

        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    public void checkInBooksByISBN(String[] _isbn, String _userID) {

        try {
            sqlCaller.checkinBooks(_isbn, _userID);

        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }


    //Add a book to the database.
    public int addBook(BooksModel _b) {
        int res = sqlCaller.addBooks(_b);
        return res;
    }

    //Remove a book from the database.
    public int removeBook(BooksModel _b) {
        int res = sqlCaller.removeBooks(_b.getISBN());
        return res;
    }


    public void loadBookByISBN(String _isbn) throws Exception {
        BooksModel book = new BooksModel();
        book.setISBN(_isbn);
        String bookData = book.myAPI.loadBookNameByISBN(_isbn);
        parseBookFromAPI(bookData);
    }

    public void loadBookNameByAuthorAndTitle(String _author,
            String _title) throws Exception {
        BooksModel book = new BooksModel();
        String bookData = book.myAPI.loadBookNameByAuthorAndTitle(_author, _title);
        parseBookFromAPI(bookData);
    }

    public void parseBookFromAPI(String _responseString) {

        try {

            JSONObject root = new JSONObject(_responseString);
            JSONArray books = root.getJSONArray("items");

            for (int i = 0; i < books.length(); i++) {
                JSONObject book = books.getJSONObject(i);

                JSONObject info = book.getJSONObject("volumeInfo");
                String bookTitle = info.getString("title");

                JSONArray authors = info.getJSONArray("authors");

                String bookAuthor = authors.getString(0);
                JSONObject imageLinks = info.getJSONObject("imageLinks");
                String bookImageLink = imageLinks.getString("smallThumbnail");

                String bookISBN = generateNumber();

                BooksModel bookObject
                        = buildBook(bookAuthor, bookTitle, "", bookISBN,
                                bookImageLink);

                sqlCaller.addBooks(bookObject);
            }
        } catch (Exception e) {

        }
    }

    public static String generateNumber() {
        String ISBN = "978-";
        for (int i = 0; i < 10; i++) {
            ISBN += (int) (Math.random() * 9 + 1);
        }
        return ISBN;
    }

}
