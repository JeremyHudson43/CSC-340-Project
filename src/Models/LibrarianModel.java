
package Models;

import Views.CheckoutView;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* @author Jeremy Hudson
   @author Charles Brady
   Last updated 4-22-2019
   
 */

public class LibrarianModel extends BooksModel {
        
    //This checks out a book and links the book to a user.
    public void checkOutBooksByISBN(String[] _isbn, String _userID) {

        try {
            sqlCaller.checkoutBooks(_isbn, _userID);

        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    //This checks in a book and removes it from the user's account.
    public void checkInBooksByISBN(String[] _isbn, String _userID) {

        try {
            sqlCaller.checkinBooks(_isbn, _userID);

        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }


    //Add a book to the database.
    public void addBook(BooksModel _b) {
        sqlCaller.addBooks(_b);
    }

    //Remove a book from the database.
    public int removeBook(BooksModel _b) {
        int res = sqlCaller.removeBooks(_b.getISBN());
        return res;
    }

    //This searches the API by ISBN.
    public void loadBookByISBN(String _isbn) throws Exception {
        BooksModel book = new BooksModel();
        book.setISBN(_isbn);
        String bookData = book.myAPI.loadBookNameByISBN(_isbn);
        parseBookFromAPI(bookData);
    }

   //This searches the API by book title and or author.
    public void loadBookNameByAuthorAndTitle(String _author,  String _title) throws Exception {
        BooksModel book = new BooksModel();
        String bookData = book.myAPI.loadBookNameByAuthorAndTitle(_author, _title);
        parseBookFromAPI(bookData);
    }

    //This parses the book title, author, and imagelink from the API.
    public void parseBookFromAPI(String _responseString) {


            JSONObject root = new JSONObject(_responseString);
            JSONArray books = root.getJSONArray("items");
            String bookImageLink = "";

            for (int i = 0; i < books.length(); i++) {
                JSONObject book = books.getJSONObject(i);

                JSONObject info = book.getJSONObject("volumeInfo");
                String bookTitle = info.getString("title");

                JSONArray authors = info.getJSONArray("authors");

                String bookAuthor = authors.getString(0);
                
                
                
                //JSONObject imageLinks = info.getJSONObject("imageLinks");
                //ookImageLink = imageLinks.getString("smallThumbnail");
                
                String bookISBN = generateNumber();

                BooksModel bookObject;
                try {
                    bookObject = buildBook(bookAuthor, bookTitle, "", bookISBN,
                            bookImageLink);
                                    addBook(bookObject);

                } catch (Exception ex) {
                    Logger.getLogger(LibrarianModel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            

        }
    

    //This generates a random ISBN.
    public static String generateNumber() {
        String ISBN = "978-";
        for (int i = 0; i < 10; i++) {
            ISBN += (int) (Math.random() * 9 + 1);
        }
        return ISBN;
    }

}
