package Controllers;

import Models.BooksModel;
import Views.AddBookView;
import Views.BookDatabaseView;
import Views.CheckoutView;
import Views.CustomerView;
import Views.LibrarianView;
import Views.LibraryManagementGUI;
import java.awt.BorderLayout;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last Updated 4/5
 *
 * This is the controller for the books class
 */
public class BooksController extends ParentController{

    private BooksModel bookModel;
    private AddBookView addBookView;
    private BookDatabaseView bookDBView;
    private CheckoutView checkoutView;


    public BooksController(LibrarianView librarianView, 
               CustomerView customerView, 
               LibraryManagementGUI libraryManagement, BooksModel bookModel,
               BookDatabaseView bookDBview, AddBookView addBookView) throws SQLException {
        
        super(librarianView, customerView, libraryManagement);
        
        this.bookModel = bookModel;
        this.bookDBView = bookDBview;
        this.addBookView = addBookView;
        
        
        initBookController();
    }
    

        


    
    public void initBookController() {
                
                
    librarianView.databaseListener(e -> displayBookDB());
    //customerView.databaseListener(e -> displayBookDB());
    addBookView.addBookListener(e -> displayAddBookView());

    //librarianView.checkInListener(e -> displayBookDB());
    librarianView.checkOutListener(e -> checkOutView());
    //librarianView.goToBookListener(e -> displayBookDB());
    librarianView.bookAddListener(e -> {
        try {
            displayAddBookView();
        } catch (Exception ex) {
            Logger.getLogger(BooksController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    });

        
      


    }


public void checkOutView () {
    checkoutView.setVisible(true);
}
   
 public void displayBookDB() {
        
                   JFrame frame = new JFrame();   
        frame.add(BorderLayout.CENTER, bookDBView);
        frame.pack();
        frame.setVisible(true);
        bookDBView.setVisible(true);
        bookDBView.searchDBListener(e -> {
                       try {
                           searchDB();
                       } catch (SQLException ex) {
                           Logger.getLogger
        (BooksController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   });
    }
 
 
 private void searchDB() throws SQLException {
     bookModel.searchBook(bookDBView.getAuthorName(), bookDBView.getBookTitle(), 
             bookDBView.getISBN());
 }
 private void displayAddBookView() {
         addBookView.setVisible(true);
         addBookView.addBookListener(e -> {
             try {
                 addBooks();
             } catch (Exception ex) {
                 Logger.getLogger
        (BooksController.class.getName()).log(Level.SEVERE, null, ex);
             }
         });

 }
    private void addBooks() throws Exception {

      String author = addBookView.getAuthor();
      String title = addBookView.getTitle();
      String ISBN = addBookView.getISBN();
      
        if (ISBN.equals("")) {
            bookModel.loadBookNameByAuthorAndTitle(author, title);
        } else {
            bookModel.loadBookByISBN(ISBN);
        }
    }

    private void displayIndividualBookView() throws SQLException {
        bookModel.bookDBMethod(bookModel.getAuthor(), bookModel.getTitle(),
                bookModel.getISBN());
    }

}
