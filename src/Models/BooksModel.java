package Models;

import SQL_Translator.MySQLCaller;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

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

    private String author;
    private String title;
    private String isbn;
    private String category;
    private String imageLink;

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String _author) {
        this.author = _author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setISBN(String _ISBN) {
        this.isbn = _ISBN;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String _category) {
        this.category = _category;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public void setImageLink(String _imageLink) {
        this.imageLink = _imageLink;
    }
    //======================================================================

    //creates table from given author, title and isbn
    public JTable createTable(String _author, String _title, String _isbn) throws SQLException {
        String[] columns = {"ISBN", "Title", "Author", "Category",
            "ImageLink"};
        Object[][] data = searchBook(_author, _title, _isbn);
        JTable table = new JTable(data, columns);

        return table;

    }

    //helper method for BookDB method
    public String[] parseTable(JTable _table) throws IOException {

        TableModel model = _table.getModel();
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

    //Create a new book
    public static BooksModel buildBook(String _author, String _title,
            String _category, String _isbn, String _imageLink)
            throws Exception {
        BooksModel b = new BooksModel();
        b.setAuthor(_author);
        b.setTitle(_title);
        b.setCategory(_category);
        b.setISBN(_isbn);
        b.setImageLink(_imageLink);
        return b;
    }

    //Search for a book in the database.
    public Object[][] searchBook(String _author, String _title, String _isbn)
            throws SQLException {
        Object[][] data = this.sqlCaller.searchBooks(_author, _title, _isbn);
        return data;
    }

}
