package Models;

import API.APITranslator;
import API.ApiConnector;
import SQL_Translator.MySQLCaller;
import SQL_Translator.MySQLDBTranslator;
import Views.BookDatabaseView;
import Views.CheckoutView;
import Views.LibraryCardView;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last Updated 4/5
 *
 * This is the model for the books class.
 */
public class BooksModel {

    MySQLCaller sqlCaller = new MySQLCaller();
            protected final static ApiConnector myAPI = new APITranslator();


    private String author;
    private String title;
    private String ISBN;
    private String category;
    private String imageLink;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String _author) {
        this.author = _author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String _ISBN) {
        this.ISBN = _ISBN;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String _category) {
        this.category = _category;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String _imageLink) {
        this.imageLink = _imageLink;
    }
    //======================================================================

    //creates table from given author, title and ISBN
    public JTable createTable(String _author, String _title, String _isbn) {
        try {
            String[] columns = {"ISBN", "Title", "Author", "Category",
                "ImageLink"};
            Object[][] data = searchBook(_author, _title, _isbn);
            JTable table = new JTable(data, columns);
            return table;

        } catch (Exception ex) {
            Logger.getLogger(BookDatabaseView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //helper method for BookDB method
    public String[] parseTable(JTable _table) throws IOException {

        TableModel model = (TableModel) _table.getModel();
        String[] bookInfo = new String[5];

        String author = "";
        String title = "";
        String category = "";
        String isbn = "";
        String imagelink = "";

        // get the selected row index
        int selectedRowIndex = _table.getSelectedRow();
        if (model.getValueAt(selectedRowIndex, 0) != null) {
            isbn = model.getValueAt(selectedRowIndex, 0).toString();
            bookInfo[0] = isbn;
        }
        if (model.getValueAt(selectedRowIndex, 1) != null) {
            title = model.getValueAt(selectedRowIndex, 1).toString();
            bookInfo[1] = title;
        }
        if (model.getValueAt(selectedRowIndex, 2) != null) {
            author = model.getValueAt(selectedRowIndex, 2).toString();
            bookInfo[2] = author;
        }
        if (model.getValueAt(selectedRowIndex, 3) != null) {
            category = model.getValueAt(selectedRowIndex, 3).toString();
            bookInfo[3] = category;
        }
        if (model.getValueAt(selectedRowIndex, 4) != null) {
            imagelink = model.getValueAt(selectedRowIndex, 4).toString();
            bookInfo[4] = imagelink;
        }

        return bookInfo;

    }
    //Search for a book in the database.
    public Object[][] searchBook(String _author, String _title, String _isbn)
            throws SQLException {
        Object[][] data = sqlCaller.searchBooks(_author, _title, _isbn);
        return data;
    }
   

}
