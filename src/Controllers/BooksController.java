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
        
        librarianView.databaseListener(e -> displayBookDB());
        librarianView.bookAddListener(e -> displayAddBookView());
        librarianView.customerSearchListener(e -> customerDisplay());
        librarianView.checkInListener(e -> displayCheckInView());
        librarianView.checkOutListener(e -> displayCheckOutView());
    }

    public void initControllerForCustomer() {
        customerView.setVisible(true);
        customerView.databaseListener(e -> displayBookDB());

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
    
    private void checkOut() {
        String userID = checkoutView.getUserID();
        String isbn1 = checkoutView.getISBN1();
        String isbn2 = checkoutView.getISBN2();
        String isbn3 = checkoutView.getISBN2();
        String isbn4 = checkoutView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};

        bookModel.checkOutBooksByISBN(isbn, userID);

    }

    private void displayCheckOutView() {
        checkoutView.setVisible(true);
        checkoutView.checkOutListener(e -> {
            try {
                checkOut();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    private void displayCheckInView() {
        checkInView.setVisible(true);
        checkInView.checkinListener(e -> {
            try {
                checkIn();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    private void checkIn() {
        String userID = checkInView.getUserID();
        String isbn1 = checkInView.getISBN1();
        String isbn2 = checkInView.getISBN2();
        String isbn3 = checkInView.getISBN2();
        String isbn4 = checkInView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};
        bookModel.checkInBooksByISBN(isbn, userID);

    }

    public void displayBookDB() {

        bookDBView.setVisible(true);

        JFrame frame = new JFrame();
        frame.add(BorderLayout.CENTER, bookDBView);
        frame.pack();
        frame.setVisible(true);
        bookDBView.searchDBListener(e -> searchLocalDB());

    }

    private void displayAddBookView() {
        addBookView.setVisible(true);
        addBookView.addBookListener(e -> {
            try {
                addBooks();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
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

    //searches local SQL database for book matching author/title/ISBN
    public void searchLocalDB() {

        String author = bookDBView.getAuthorName();
        String title = bookDBView.getBookTitle();
        String ISBN = bookDBView.getISBN();

        try {
            bookModel.searchBook(author, title, ISBN);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        getIndividualBookViewTable(author, title, ISBN);

    }

    //creates a table from book model info and displays it in a scrollPane
    private void getIndividualBookViewTable(String author, String title,
            String ISBN) {

        JTable table = bookModel.createTable(author, title, ISBN);

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

    /*displays individual book info after an item has been clicked in
    the scroll plane
     */
    private void getInfoAboutBook(JTable table) throws IOException {
        String[] bookInfo = bookModel.parseTable(table);

        individualBookView.setIndividualBookVewAuthorPlaceholderTxtLbl(bookInfo[0]);
        individualBookView.setIndividualBookVewCategoryPlaceholderTxtLbl(bookInfo[1]);
        individualBookView.setIndividualBookVewISBNPlaceholderTxtLbl(bookInfo[2]);
        individualBookView.setIndividualBookVewNamePlaceholderTxtLbl(bookInfo[3]);
        individualBookView.setImagePlaceholderLbl(bookInfo[4]);

        JFrame frame = new JFrame();

        frame.add(BorderLayout.CENTER, individualBookView);
        frame.pack();
        frame.setVisible(true);

        individualBookView.setVisible(true);
    }

}
