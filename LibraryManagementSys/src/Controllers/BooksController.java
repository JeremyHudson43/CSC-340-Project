package Controllers;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/10
 */
import libManage.Database;
import Models.Books;
import Models.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BooksController extends Books {

    Database db;
    Connection con;
    PreparedStatement pst;

    public BooksController() throws Exception {
        super();
        db = new Database();
        con = db.getConnection();
    }

    public int addBooks(Books b) {
        int res = 0;
        String sql = "";

        try {
            sql = "INSERT INTO book(isbn, author, title, category, imagelink) "
                    + "VALUES(?,?,?,?,?)";

            pst = con.prepareStatement(sql);
            pst.setString(1, b.getISBN());
            pst.setString(2, b.getAuthor());
            pst.setString(3, b.getTitle());
            pst.setString(4, b.getCategory());
            pst.setString(5, b.getImageLink());
            res = pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    private int removeBooks(String _title) {

        int res = 0;
        String sql = "";

        try {

            sql = "DELETE FROM books WHERE title = " + _title;
            res = pst.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Books searchBooks(String _isbn) {

        String sql = "";
        ResultSet rs;

        Books b = new Books();

        b.setISBN(_isbn);

        try {

            sql = "SELECT * FROM books WHERE isbn = " + _isbn;
            rs = pst.executeQuery(sql);

            if (rs.next()) {
                b.getAuthor();
                b.getCategory();
                b.getImageLink();
                b.getTitle();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public int CheckoutBooks(Books b, User u) {
        int res = 0;
        String sql = "";

        try {
            sql = "INSERT INTO checkout (id, ISBN, date)"
                    + "VALUES(?,?,?)";

            pst = con.prepareCall(sql);
            pst.setString(1, b.getISBN());
            pst.setString(2, u.getId());
            //code to set date
            res = pst.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public int CheckinBooks(Books b, User u) {
        int res = 0;
        String sql = "";

        try {
            sql = "DROP FROM checkout WHERE isbn = '" + b.getISBN() + "' AND user = '" + u.getId() + "' ";

            pst = con.prepareCall(sql);
            pst.setString(1, b.getISBN());
            pst.setString(2, u.getId());
            //code to set date
            res = pst.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
}
