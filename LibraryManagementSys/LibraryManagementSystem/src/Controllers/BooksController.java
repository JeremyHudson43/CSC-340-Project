package Controllers;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/15
 *
 * This is the controller for the books class
 */
import Database.MySQLDBTranslator;
import Models.Books;

public class BooksController extends Books {

    MySQLDBTranslator SQL;

    public BooksController() throws Exception {
        super();
        SQL = new MySQLDBTranslator();
    }

    //Add a book to the database.
    public int AddBook(Books _b) {
        int res = SQL.addBooks(_b);
        return res;
    }

    //Remove a book from the database.
    public int RemoveBook(Books _b) {
        int res = SQL.removeBooks(_b.getISBN());
        return res;
    }

    //Search for a book in the database.
    public void SearchBook(String _author, String _title, String _isbn) {
        SQL.searchBooks(_author, _title, _isbn);;
    }

    //Create a new book
    public Books BuildBook(String _author, String _title, String _category, String _isbn, String _imageLink) {
        Books b = new Books();
        b.setAuthor(_author);
        b.setTitle(_title);
        b.setCategory(_category);
        b.setISBN(_isbn);
        b.setImageLink(_imageLink);
        return b;
    }
}
