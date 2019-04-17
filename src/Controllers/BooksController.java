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

    BooksModel bookModel = new BooksModel();
    UserModel userModel = new UserModel();
    private BookDatabaseView bookDBView = new BookDatabaseView();
    private IndividualBookView individualBookView = new IndividualBookView();


    /*This gets the userID and ISBNs from checkinView and contacts the model to 
    checkout the books in the database.
    */

    //This displays the book DB view. 
    public void displayBookDB() {

        this.bookDBView.setVisible(true);

        JFrame frame = new JFrame();
        frame.add(BorderLayout.CENTER, bookDBView);
        frame.pack();
        frame.setVisible(true);
        this.bookDBView.searchDBListener(e -> searchLocalDB());

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
