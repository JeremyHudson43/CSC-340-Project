package Controllers;

import Models.BooksModel;
import Models.UserModel;
import Views.BookDatabaseView;
import Views.BookDatabaseView;
import Views.BookScrollView;
import Views.IndividualBookView;

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
    BookScrollView bookScrollView = new BookScrollView();

    /*This gets the userID and ISBNs from checkinView and contacts the model to 
    checkout the books in the database.
     */
    //This displays the book DB view. 
    

    public void displayBookDB() {

        this.bookDBView.setVisible(true);
        this.bookDBView.searchDBListener(e -> searchLocalDB());

    }

    // This searches the local SQL database for book matching author/title/ISBN.
    public void searchLocalDB() {

            String author = this.bookDBView.getAuthorName();
            String title = this.bookDBView.getBookTitle();
            String ISBN = this.bookDBView.getISBN();

        try {
            getIndividualBookViewTable(author, title, ISBN);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }


    }

    //This creates a table from book model info and displays it in a scrollPane.
    private void getIndividualBookViewTable(String author, String title,
            String ISBN) throws SQLException {

        JTable table = bookModel.createTable(author, title, ISBN);
        JScrollPane scrollPane = new JScrollPane(table);

        bookScrollView.getContentPane().setLayout(new BorderLayout());
        bookScrollView.getContentPane().add(scrollPane, BorderLayout.CENTER);
        bookScrollView.setSize(500, 600);
        bookScrollView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookScrollView.setVisible(true);

        bookScrollView.bookSelectionListener(e -> getInfoAboutBook(table));

    }


    /*This displays individual book info after an item has been clicked in
    the scroll plane.
     */
    void getInfoAboutBook(JTable _table) {
        try {
            String[] bookInfo = bookModel.parseTable(_table);

            this.individualBookView.setIndividualBookVewAuthorPlaceholderTxtLbl(bookInfo[2]);
            this.individualBookView.setIndividualBookVewCategoryPlaceholderTxtLbl(bookInfo[3]);
            this.individualBookView.setIndividualBookVewISBNPlaceholderTxtLbl(bookInfo[0]);
            this.individualBookView.setIndividualBookVewNamePlaceholderTxtLbl(bookInfo[1]);
            this.individualBookView.setImagePlaceholderLbl(bookInfo[4]);

            JFrame frame = new JFrame();

            frame.add(BorderLayout.CENTER, individualBookView);
            frame.pack();
            frame.setVisible(true);

            this.individualBookView.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
