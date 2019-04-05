package Controllers;

import Models.BooksModel;
import Views.AddBookView;
import Views.BookDatabaseView;

import java.sql.SQLException;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/15
 *
 * This is the controller for the books class
 */
public class BooksController {

    private BooksModel bookModel;
    private BookDatabaseView bookDBview;
    private AddBookView addBookView;

    public BooksController(BooksModel bookModel, BookDatabaseView bookDBview) {
        this.bookModel = bookModel;
        this.bookDBview = bookDBview;
    }

    public BooksController(BooksModel bookModel, AddBookView addBookView) {
        this.bookModel = bookModel;
        this.addBookView = addBookView;
    }

    public void initController(String _author, String _bookTitle, String _ISBN)
            throws SQLException {

        bookModel.setAuthor(_author);
        bookModel.setTitle(_bookTitle);
        bookModel.setISBN(_ISBN);

        displayIndividualBookView();
    }

    public void addBook(String _author, String _bookTitle, String _ISBN)
            throws SQLException, Exception {

        displayAddBookView(_author, _bookTitle, _ISBN);
    }

    private void displayAddBookView(String _author, String _bookTitle, String _ISBN)
            throws SQLException, Exception {
        if (_ISBN.equals("")) {
            bookModel.loadBookNameByAuthorAndTitle(_author, _bookTitle);
        } else {
            bookModel.loadBookByISBN(_ISBN);
        }
    }

    private void displayIndividualBookView() throws SQLException {
        bookModel.bookDBMethod(bookModel.getAuthor(), bookModel.getTitle(),
                bookModel.getISBN());
    }

}
