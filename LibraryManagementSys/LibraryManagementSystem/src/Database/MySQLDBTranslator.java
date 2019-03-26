package Database;

import Models.Books;
import Models.User;
import Views.BookResultView;
import Views.BookView;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charles Brady
 *
 * Last updated 3/13
 */
public class MySQLDBTranslator {

    private Connection connection;
    private PreparedStatement preparedstate;
    private final static String URL = "jdbc:mysql://localhost:3306/library";
    private final static String acct = "librarian";
    private final static String pass = "Alexandria";

    public MySQLDBTranslator() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connection = DriverManager.getConnection(URL, acct, pass);
            if (connection == null) {
                JOptionPane.showMessageDialog(null, "Cannot connect to database. Program Exiting.");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Cannot connect to database.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //Add a book to the MySQL Database.
    public int addBooks(Books _book) {
        int res = 0;
        String sql = "";

        try {
            sql = "INSERT INTO book(isbn, author, title, category, imagelink) "
                    + "VALUES(?,?,?,?,?)";

            preparedstate = connection.prepareStatement(sql);
            preparedstate.setString(1, _book.getISBN());
            preparedstate.setString(2, _book.getAuthor());
            preparedstate.setString(3, _book.getTitle());
            preparedstate.setString(4, _book.getCategory());
            preparedstate.setString(5, _book.getImageLink());
            res = preparedstate.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    //Remove a book from the MySQL database.
    public int removeBooks(String _isbn) {

        int result = 0;
        String sql = "";

        try {

            sql = "DELETE FROM books WHERE isbn = " + _isbn;
            result = preparedstate.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //Search for a book in the MySQL Database.
    public void searchBooks(String _author, String _title, String _isbn) {

        String sql = "";
        ResultSet resultset;

        try {
            if (!_isbn.equals("")) {
                sql = "SELECT * FROM book WHERE isbn like ?";
                preparedstate = connection.prepareStatement(sql);
                preparedstate.setString(1, "%" + _isbn + "%");
            } else {
                if (!_author.equals("") && !_title.equals("")) {
                    sql = "SELECT * FROM book WHERE author like ? AND title like ?";
                    preparedstate = connection.prepareStatement(sql);
                    preparedstate.setString(1, "%" + _author + "%");
                    preparedstate.setString(2, "%" + _title + "%");
                }
                if (!_author.equals("")) {
                    sql = "select * from book where author like ? ";
                    preparedstate = connection.prepareStatement(sql);
                    preparedstate.setString(1, "%" + _author + "%");
                    //   select * from book where author like '%Rowling%';
                }
                if (!_title.equals("")) {
                    sql = "SELECT * FROM book WHERE title like ?";
                    preparedstate = connection.prepareStatement(sql);
                    preparedstate.setString(1, "%" + _title + "%");
                }
            }
            
            BookResultView bookresult = new BookResultView(null);
            resultset = preparedstate.executeQuery();
            JTable table = new JTable(buildTableModel(resultset));
            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    //Check out a book for a user within the MySQL Database.
    public int CheckoutBooks(Books _book, User _user) {
        int result = 0;
        String sql = "";

        try {
            sql = "INSERT INTO checkout (id, ISBN, date)"
                    + "VALUES(?,?,?)";

            preparedstate = connection.prepareCall(sql);
            preparedstate.setInt(1, _user.getId());
            preparedstate.setString(2, _book.getISBN());
            //code to set date
            result = preparedstate.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //Check in a Users checked out book within the MySQL Database.
    public int CheckinBooks(Books _book, User _user) {
        int res = 0;
        String sql = "";

        try {
            sql = "DELETE FROM checkout WHERE isbn = '" + _book.getISBN() + "' AND ID = " + _user.getId();

            preparedstate = connection.prepareCall(sql);
            //code to set date
            res = preparedstate.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    //Create new user for the MySQL Database
    public int createAccount(User _user) {
        int res = 0;
        String sql = "";

        try {
            sql = "INSERT INTO users (UserID, PWD, Name, userType) "
                    + "VALUES(?,?,?,?)";
            preparedstate = connection.prepareStatement(sql);
            preparedstate.setString(1, _user.getUserId());
            preparedstate.setString(2, _user.getPassword());
            preparedstate.setString(3, _user.getName());
            preparedstate.setString(4, _user.getUserType());
            res = preparedstate.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    //Checks within the MySQL database whether or not a user is a Librarian or a Customer
    public String CheckLogin(User _user) throws Exception {
        String sql = "";
        ResultSet rs = null;
        String type = "";

        try {
            sql = "SELECT userType FROM users WHERE UserID=? AND PWD=?";
            preparedstate = connection.prepareStatement(sql);

            preparedstate.setString(1, _user.getUserId());
            preparedstate.setString(2, _user.getPassword());

            rs = preparedstate.executeQuery();

            if (rs.next()) {
                type = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return type;
    }

    //Search for a user within the MySQL Database
    public User searchUser(String _id) {

        String sql = "";
        ResultSet rs;

        User u = new User();

        u.setUserId(_id);

        try {

            sql = "SELECT Name, usertype, id FROM users WHERE UserId = '" + _id + "'";
            rs = preparedstate.executeQuery(sql);

            if (rs.next()) {
                u.setName(rs.getString(1));
                u.setUserType(rs.getString(2));
                u.setId(rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }

    //Table model
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        //names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        //data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);

    }
}
