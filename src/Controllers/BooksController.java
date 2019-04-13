package Controllers;

import Models.BooksModel;
import Models.UserModel;
import SQL_Translator.MySQLCaller;
import Views.AddBookView;
import Views.BookDatabaseView;
import Views.CheckinView;
import Views.CheckoutView;
import Views.CustomerView;
import Views.IndividualBookView;
import Views.IndividualCustomerView;
import Views.LibrarianView;

import java.awt.BorderLayout;
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last Updated 4/13
 *
 * This is the controller for the books class
 */
public class BooksController {

    private BooksModel bookModel = new BooksModel();
    private UserModel userModel = new UserModel();
    private AddBookView addBookView = new AddBookView();
    private BookDatabaseView bookDBView = new BookDatabaseView();
    private CheckoutView checkoutView = new CheckoutView();
    private CheckinView checkInView = new CheckinView();
    private LibrarianView librarianView = new LibrarianView();
    private CustomerView customerView = new CustomerView();
    private IndividualBookView individualBookView = new IndividualBookView();
    private IndividualCustomerView individualCustomerView = new IndividualCustomerView();

    public void initControllerForLibrarian() {
        librarianView.setVisible(true);
        
        this.librarianView.databaseListener(e -> displayBookDB());
        this.librarianView.bookAddListener(e -> displayAddBookView());
        this.librarianView.customerSearchListener(e -> customerDisplay());
        this.librarianView.checkInListener(e -> displayCheckInView());
        this.librarianView.checkOutListener(e -> displayCheckOutView());
    }

    public void initControllerForCustomer() {
        this.customerView.setVisible(true);
        this.customerView.databaseListener(e -> displayBookDB());

    }

    public void customerDisplay() {
        
       UserModel placeholder = new UserModel();
       
       placeholder = userModel.searchUser
        (librarianView.getCustomerSearchTextField());
       
       individualCustomerView.setCustomerName(placeholder.getName());
       individualCustomerView.setCustomerEmail(placeholder.getEmail());
      // individualCustomerView.setCustomerID(placeholder.getId());
       
       individualCustomerView.setVisible(true);
    }
    
    /*This gets the userID and ISBNs from checkoutView and contacts the model to 
    checkout the books in the database
    */
    private void checkOut() {
        String userID = checkoutView.getUserID();
        String isbn1 = checkoutView.getISBN1();
        String isbn2 = checkoutView.getISBN2();
        String isbn3 = checkoutView.getISBN2();
        String isbn4 = checkoutView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};

        bookModel.checkOutBooksByISBN(isbn, userID);

    }

    //This displays the checkout view.
    private void displayCheckOutView() {
        this.checkoutView.setVisible(true);
        this.checkoutView.checkOutListener(e -> {
            try {
                checkOut();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    //This displays the checkin view.
    private void displayCheckInView() {
        this.checkInView.setVisible(true);
        this.checkInView.checkinListener(e -> {
            try {
                checkIn();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    /*This gets the userID and ISBNs from checkinView and contacts the model to 
    checkout the books in the database.
    */
    private void checkIn() {
        String userID = checkInView.getUserID();
        String isbn1 = checkInView.getISBN1();
        String isbn2 = checkInView.getISBN2();
        String isbn3 = checkInView.getISBN2();
        String isbn4 = checkInView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};
        bookModel.checkInBooksByISBN(isbn, userID);

    }

    //This displays the book DB view. 
    public void displayBookDB() {

        this.bookDBView.setVisible(true);

        JFrame frame = new JFrame();
        frame.add(BorderLayout.CENTER, bookDBView);
        frame.pack();
        frame.setVisible(true);
        this.bookDBView.searchDBListener(e -> searchLocalDB());

    }

    //This displays the add book view. 
    private void displayAddBookView() {
        this.addBookView.setVisible(true);
        this.addBookView.addBookListener(e -> {
            try {
                addBooks();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });

    }

    //This gets book info from the API by title and author or by ISBN.
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

    // This searches the local SQL database for book matching author/title/ISBN.
    public void searchLocalDB() {

        String author = this.bookDBView.getAuthorName();
        String title = this.bookDBView.getBookTitle();
        String ISBN = this.bookDBView.getISBN();

        try {
            bookModel.searchBook(author, title, ISBN);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        getIndividualBookViewTable(author, title, ISBN);

    }

    //This creates a table from book model info and displays it in a scrollPane.
    private void getIndividualBookViewTable(String _author, String _title,
            String _isbn) {

        JTable table = bookModel.createTable(_author, _title, _isbn);

        try {

            table.addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    try {
                        getInfoAboutBook(table);

                    } catch (IOException ex) {
                        Logger.getLogger(BooksController.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            });

            JFrame frame = new JFrame();
            JScrollPane scrollPane = new JScrollPane(table);

            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setSize(500, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(BookDatabaseView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /*This displays individual book info after an item has been clicked in
    the scroll plane.
     */
    private void getInfoAboutBook(JTable _table) throws IOException {
        String[] bookInfo = bookModel.parseTable(_table);

        this.individualBookView.setIndividualBookVewAuthorPlaceholderTxtLbl(bookInfo[0]);
        this.individualBookView.setIndividualBookVewCategoryPlaceholderTxtLbl(bookInfo[1]);
        this.individualBookView.setIndividualBookVewISBNPlaceholderTxtLbl(bookInfo[2]);
        this.individualBookView.setIndividualBookVewNamePlaceholderTxtLbl(bookInfo[3]);
        this.individualBookView.setImagePlaceholderLbl(bookInfo[4]);

        JFrame frame = new JFrame();

        frame.add(BorderLayout.CENTER, individualBookView);
        frame.pack();
        frame.setVisible(true);

        this.individualBookView.setVisible(true);
    }

}
