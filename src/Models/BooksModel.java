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

    protected final static ApiConnector myAPI = new APITranslator();

    MySQLCaller sqlCaller = new MySQLCaller();

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

    //placeholder method for checkout logic
    public void checkOutBooksByISBN(String[] _isbn, String _userID) {

        try {
            sqlCaller.checkoutBooks(_isbn, _userID);

        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    public void checkInBooksByISBN(String[] _isbn, String _userID) {

        try {
            sqlCaller.checkinBooks(_isbn, _userID);

        } catch (Exception ex) {
            Logger.getLogger(CheckoutView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    //placeholder method for printing library card
    public void LibraryCardPrint() {
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pageFormat = job.defaultPage();
        //job.setPrintable(new Printer(this, 0.75));
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(
                        LibraryCardView.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    //placeholder method for library card logic
    public void LibraryCardView() {
//          try {
//            initComponents();
//            BarcodeController bc = new BarcodeController();
//            Barcode b = bc.createBarcode(Integer.toString(_u.getId()), _u.getName());
//            BufferedImage bi = BarcodeImageHandler.getImage(b);
//            BarCode.setIcon(new ImageIcon(bi));
//            NameTextField.setText(_u.getName());
//        } catch (BarcodeException ex) {
//            Logger.getLogger(LibraryCardView.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (OutputException ex) {
//            Logger.getLogger(LibraryCardView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    //Add a book to the database.
    public int addBook(BooksModel _b) {
        int res = sqlCaller.addBooks(_b);
        return res;
    }

    //Remove a book from the database.
    public int removeBook(BooksModel _b) {
        int res = sqlCaller.removeBooks(_b.getISBN());
        return res;
    }

    //Search for a book in the database.
    public Object[][] searchBook(String _author, String _title, String _isbn)
            throws SQLException {
        Object[][] data = sqlCaller.searchBooks(_author, _title, _isbn);
        return data;
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

    public void loadBookByISBN(String _isbn) throws Exception {
        BooksModel book = new BooksModel();
        book.setISBN(_isbn);
        String bookData = book.myAPI.loadBookNameByISBN(_isbn);
        parseBookFromAPI(bookData);
    }

    public void loadBookNameByAuthorAndTitle(String _author,
            String _title) throws Exception {
        BooksModel book = new BooksModel();
        String bookData = book.myAPI.loadBookNameByAuthorAndTitle(_author, _title);
        parseBookFromAPI(bookData);
    }

    public void parseBookFromAPI(String _responseString) {

        try {

            JSONObject root = new JSONObject(_responseString);
            JSONArray books = root.getJSONArray("items");

            for (int i = 0; i < books.length(); i++) {
                JSONObject book = books.getJSONObject(i);

                JSONObject info = book.getJSONObject("volumeInfo");
                String bookTitle = info.getString("title");

                JSONArray authors = info.getJSONArray("authors");

                String bookAuthor = authors.getString(0);
                JSONObject imageLinks = info.getJSONObject("imageLinks");
                String bookImageLink = imageLinks.getString("smallThumbnail");

                String bookISBN = generateNumber();

                BooksModel bookObject
                        = buildBook(bookAuthor, bookTitle, "", bookISBN,
                                bookImageLink);

                sqlCaller.addBooks(bookObject);
            }
        } catch (Exception e) {

        }
    }

    public static String generateNumber() {
        String ISBN = "978-";
        for (int i = 0; i < 10; i++) {
            ISBN += (int) (Math.random() * 9 + 1);
        }
        return ISBN;
    }

}
