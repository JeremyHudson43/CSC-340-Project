package SQL_Translator;

import Models.BooksModel;
import Models.UserModel;
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
    private final static String URL = "jdbc:mysql://localhost:3306"
            + "/library";
    private final static String acct = "root";
    private final static String pass = "Alexandria";

    public MySQLDBTranslator() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connection = DriverManager.getConnection(URL, acct, pass);
            if (connection == null) {
                JOptionPane.showMessageDialog(null, "Cannot connect to database."
                        + " Program Exiting.");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Cannot connect to database.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //Add a book to the MySQL Database.
    public int addBooks(BooksModel _book) {
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
            Logger.getLogger(MySQLDBTranslator.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //Search for a book in the MySQL Database.
    public Object[][] searchBooks(String _author, String _title, String _isbn) throws SQLException
            {

        String sql = "";
        ResultSet resultset;
               
       
       searchBooksHelper(_author, _title, _isbn, sql);
       
          resultset = preparedstate.executeQuery();
            resultset.last();
            int row = resultset.getRow();
            resultset.first();
            int i = 0;
            Object[][] data = new Object[row][5];
            
            while (resultset.next()) {
                data[i][0] = resultset.getString(1);
                data[i][1] = resultset.getString(2);
                data[i][2] = resultset.getString(3);
                data[i][3] = resultset.getString(4);
                data[i][4] = resultset.getString(5);
                i++;
            }
            return data;
            
    }
   

    //helper method for searchBooks to ensure main method is not too long
public void searchBooksHelper (String _author, String _title, String _isbn,
        String _sql) {
 try {
            if (!_isbn.equals("")) {
                _sql = "SELECT * FROM book WHERE isbn like ?";
                preparedstate = connection.prepareStatement(_sql);
                preparedstate.setString(1, "%" + _isbn + "%");
            } else {
                if (!_author.equals("") && !_title.equals("")) {
                    _sql = "SELECT * FROM book WHERE author like ?"
                            + " AND title like ?";
                    preparedstate = connection.prepareStatement(_sql);
                    preparedstate.setString(1, "%" + _author + "%");
                    preparedstate.setString(2, "%" + _title + "%");
                }
                if (!_author.equals("")) {
                    _sql = "select * from book where author like ? ";
                    preparedstate = connection.prepareStatement(_sql);
                    preparedstate.setString(1, "%" + _author + "%");
                    //   select * from book where author like '%Rowling%';
                }
                if (!_title.equals("")) {
                    _sql = "SELECT * FROM book WHERE title like ?";
                    preparedstate = connection.prepareStatement(_sql);
                    preparedstate.setString(1, "%" + _title + "%");
                }
            }
               } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
}


     //Check out a book for a user within the MySQL Database.
    public int checkoutBooks(String[] _bookISBN, int _ID) {
        boolean result = false;
        String sql = "";
        int cnt = 0;

        try {
            for(int i = 0; i < 10; i++){
                if (!_bookISBN[i].equals("")) {
                    sql = "INSERT INTO checkout (ID, ISBN) VALUES"
                            + "(" + _ID + ", '" + _bookISBN[i] + "')";
                    preparedstate = connection.prepareCall(sql);
                    result = preparedstate.execute(sql);
                    cnt++;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cnt;
    }


    //Check in a Users checked out book within the MySQL Database.
    public int checkInBooks(BooksModel _book, UserModel _user) {
        int res = 0;
        String sql = "";

        try {
            sql = "DELETE FROM checkout WHERE isbn = '" 
                    + _book.getISBN() + "' AND ID = " + _user.getId();

            preparedstate = connection.prepareCall(sql);
            //code to set date
            res = preparedstate.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    //Create new user for the MySQL Database
    public int createAccount(UserModel _user) {
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

    /*Checks within the MySQL database whether or not a user is a Librarian 
    or a Customer
    */
    public String checkLogin(UserModel _user) throws Exception {
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
    public UserModel searchUser(String _id) {

        String sql = "";
        ResultSet rs;

        UserModel u = new UserModel();

        u.setUserId(_id);

        try {

            sql = "SELECT Name, usertype, id FROM users WHERE UserId = "
                    + "'" + _id + "'";
            rs = preparedstate.executeQuery(sql);

            if (rs.next()) {
                u.setName(rs.getString(1));
                u.setUserType(rs.getString(2));
                u.setId(rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBTranslator.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        return u;
    }

    //Table model
    public static DefaultTableModel buildTableModel(ResultSet _resultSet)
            throws SQLException {

        ResultSetMetaData metaData = _resultSet.getMetaData();

        //names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        //data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (_resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; 
                    columnIndex++) {
                vector.add(_resultSet.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);

    }
}
