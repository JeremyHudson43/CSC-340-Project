package Controllers;

import Models.BooksModel;
import Views.AddBookView;
import Views.BookDatabaseView;
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
public class BooksController extends MasterController{

    private BooksModel bookModel;
    private BookDatabaseView bookDBView;
    private AddBookView addBookView;


    public BooksController(LibrarianView librarianView, 
               CustomerView customerView, 
               LibraryManagementGUI libraryManagement, BooksModel bookModel,
               BookDatabaseView bookDBview, AddBookView addBookView) {
        
        super(librarianView, customerView, libraryManagement);
        
        this.bookModel = bookModel;
        this.bookDBView = bookDBview;
    }
    
       public BooksController(LibrarianView librarianView) throws SQLException{
           this.librarianView = librarianView;
           initController();
       }
       
         public BooksController(CustomerView customerView) throws SQLException{
           this.customerView = customerView;
           initController();
       }
        


    
    public void initController()
            throws SQLException {

      

        librarianView.databaseListener(e -> displayBookDB());
//        librarianView.bookAddListener
//        (e -> {
//            try {
//                displayAddBookView(_author, _bookTitle, _ISBN);
//            } catch (Exception ex) {
//                Logger.getLogger(BooksController.class.getName())
//                        .log(Level.SEVERE, null, ex);
//            }
//        });
        
        //librarianView.checkInListener(e -> displayBookDB());
        //librarianView.checkOutListener(e -> displayBookDB());
        //librarianView.goToBookListener(e -> displayBookDB());
        
        customerView.databaseListener(e -> displayBookDB());
        //customerView.goToBookListener(e -> displayBookDB());


    }

    public void displayBookDB() {
        bookDBView.setVisible(true);
//          bookModel.setAuthor(_author);
//        bookModel.setTitle(_bookTitle);
//        bookModel.setISBN(_ISBN);
    }

    private void displayAddBookView
        (String _author, String _bookTitle, String _ISBN)
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
