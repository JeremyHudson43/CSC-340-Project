package Controllers;

import Models.BooksModel;
import Views.AddBookView;
import Views.BookDatabaseView;
import Views.CheckinView;
import Views.CheckoutView;
import Views.CustomerView;
import Views.IndividualBookView;
import Views.LibrarianView;
import Views.LibraryManagementGUI;
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
 * Last Updated 4/12
 *
 * This is the controller for the books class
 */
public class BooksController extends ParentController {

    private BooksModel bookModel;
    private AddBookView addBookView;
    private BookDatabaseView bookDBView;
    private CheckoutView checkOutView;
    private CheckinView checkInView;
    private IndividualBookView individualBookView;

    public BooksController(LibrarianView librarianView,
            CustomerView customerView,
            LibraryManagementGUI libraryManagement, BooksModel bookModel,
            BookDatabaseView bookDBview, AddBookView addBookView, CheckoutView checkOutView,
            CheckinView checkInView)
            throws SQLException {

        super(librarianView, customerView, libraryManagement);

        this.bookModel = bookModel;
        this.bookDBView = bookDBview;
        this.addBookView = addBookView;
        this.checkOutView = checkOutView;
        this.checkInView = checkInView;

        initBookController();
    }

    public void initBookController() {

        librarianView.databaseListener(e -> displayBookDB());
        customerView.databaseListener(e -> displayBookDB());
        addBookView.addBookListener(e -> displayAddBookView());

        librarianView.checkInListener(e -> displayCheckInView());
        librarianView.checkOutListener(e -> displayCheckOutView());
        librarianView.goToBookListener(e -> displayBookDB());
        librarianView.bookAddListener(e -> displayAddBookView());

    }

    //opens book DB and adds listener to search butotn
    public void displayBookDB() {

        JFrame frame = new JFrame();
        frame.add(BorderLayout.CENTER, bookDBView);
        frame.pack();
        frame.setVisible(true);
        bookDBView.setVisible(true);
        bookDBView.searchDBListener(e -> {
            searchLocalDB();

        });

    }

    //searches local SQL database for book matching author/title/ISBN
    private void searchLocalDB() {

        String author = bookDBView.getAuthorName();
        String title = bookDBView.getBookTitle();
        String ISBN = bookDBView.getISBN();

        bookModel.createTable(author, title, ISBN);

        try {
            getIndividualBookViewTable(author, title, ISBN);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //opens addBookView and adds a listener to the addBook button
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

    //helper method to call the API to add books to local database
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

    private void displayCheckOutView() {
        checkOutView.setVisible(true);
        checkOutView.checkOutListener(e -> {
            try {
                checkOut();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    private void checkOut() {
        String userID = checkOutView.getUserID();
        String isbn1 = checkOutView.getISBN1();
        String isbn2 = checkOutView.getISBN2();
        String isbn3 = checkOutView.getISBN2();
        String isbn4 = checkOutView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};

        bookModel.checkOutBooksByISBN(isbn, userID);

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

    //creates a table from book model info and displays it in a scrollPane
    private void getIndividualBookViewTable(String author, String title,
            String ISBN) throws SQLException {

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
        JFrame frame = new JFrame();
        IndividualBookView individualBookView = new IndividualBookView(bookInfo);
        individualBookView.setVisible(true);
        

//        IndividualBookView bookView
//                = new IndividualBookView(bookInfo[2],
//                        bookInfo[2], bookInfo[3], bookInfo[0],
//                        bookInfo[4]);
        frame.add(BorderLayout.CENTER, individualBookView);
        frame.pack();
        frame.setVisible(true);
//
//        bookView.setVisible(true);
    }

}
