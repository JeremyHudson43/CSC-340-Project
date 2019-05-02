package Controllers;

import Models.BooksModel;
import Views.BookDatabaseView;
import Views.BookScrollView;
import Views.IndividualBookView;
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last Updated 4/13
 *
 * This controller routes the logic to search the local database using the book
 * database view, and gets a JTable from the books model and loads it into a
 * JFrame to display the individualBookView
 */
public class BooksController {

    private BooksModel bookModel = new BooksModel();

    /**
     * This displays the book DB view and listens for the search button.
     *
     *
     */
    public void displayAndSearchBookDB() {

        BookDatabaseView bookDBView = new BookDatabaseView();
        bookDBView.setVisible(true);
        
        bookDBView.searchDBListener(e -> {
            try {
                getIndividualBookViewTable(bookDBView.getAuthorName(), bookDBView.getBookTitle(), bookDBView.getISBN());
            } catch (SQLException ex) {
                Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }


    /**
     * This displays individual book info after an item has been clicked in the
     * scroll plane.
     *
     *
     *
     */
    private void getInfoAboutBook(JTable _table) {
        try {
            IndividualBookView individualBookView = new IndividualBookView();

            String[] bookInfo = this.bookModel.parseTable(_table);

            individualBookView.setIndividualBookVewAuthorPlaceholderTxtLbl(bookInfo[2]);
            individualBookView.setIndividualBookVewCategoryPlaceholderTxtLbl(bookInfo[3]);
            individualBookView.setIndividualBookVewISBNPlaceholderTxtLbl(bookInfo[0]);
            individualBookView.setIndividualBookVewNamePlaceholderTxtLbl(bookInfo[1]);
            individualBookView.setImagePlaceholderLbl(bookInfo[4]);

            individualBookView.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This creates a table from book model info and displays it in a
     * scrollPane.
     *
     *
     */
    private void getIndividualBookViewTable(String _author, String _title, String _isbn) throws SQLException {

        JTable table = bookModel.createTable(_author, _title, _isbn);
        JScrollPane scrollPane = new JScrollPane(table);
        
        BookScrollView bookScrollView = new BookScrollView();
        bookScrollView.scrollPaneSetter(scrollPane);
  
        bookScrollView.setVisible(true);
        bookScrollView.bookSelectionListener(e -> getInfoAboutBook(table));

    }

}
