package SQL_Translator;

import Models.BooksModel;
import Models.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charles Brady
 *
 * Last updated 4/21
 *
 * This is the translator for all of the SQL code in the Library Management
 * System.
 */
public class MySQLDBTranslator {

    private Connection connection;
    private PreparedStatement preparedstate;
    private final static String URL = "jdbc:mysql://localhost:3306"
            + "/library?autoReconnect=true&useSSL=false";
    private final static String account = "root";
    private final static String password = "Alexandria";

    public MySQLDBTranslator() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver.
            Class.forName("com.mysql.jdbc.Driver");
            // This sets up the connection with the DB.
            this.connection = DriverManager.getConnection(this.URL, this.account, this.password);
            if (this.connection == null) {
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

    /**
     * This method adds a book to the MySQL Database.
     *
     * @param _book
     * @return
     */
    public int addBooks(BooksModel _book) {
        int result = 0;
        String sql = "";

        try {
            sql = "INSERT INTO book(isbn, author, title, category, imagelink) "
                    + "VALUES(?,?,?,?,?)";

            this.preparedstate = this.connection.prepareStatement(sql);
            this.preparedstate.setString(1, _book.getISBN());
            this.preparedstate.setString(2, _book.getAuthor());
            this.preparedstate.setString(3, _book.getTitle());
            this.preparedstate.setString(4, _book.getCategory());
            this.preparedstate.setString(5, _book.getImageLink());
            result = this.preparedstate.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean checkUser(UserModel _user) {
        boolean check = false;
        String sql;
        ResultSet result;

        try {

            sql = "Select UserID from users where UserID = ?";

            this.preparedstate = this.connection.prepareCall(sql);
            this.preparedstate.setString(1, _user.getUserId());
            result = this.preparedstate.executeQuery();

            if (result.next()) {

                check = false;
            } else {

                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }

    /**
     * This searches for a book in the MySQL Database.
     *
     * @param _author
     * @param _title
     * @param _isbn
     * @return
     * @throws SQLException
     */
    public Object[][] searchBooks(String _author, String _title, String _isbn) {

        try {
            String sql = "";
            ResultSet resultset;

            resultset = searchBooksHelper(_author, _title, _isbn, sql);

            resultset.last();
            int row = resultset.getRow();
            resultset.first();

            Object[][] data = new Object[row][5];

            for (int i = 0; i < row; i++) {
                data[i][0] = resultset.getString(1);
                data[i][1] = resultset.getString(2);
                data[i][2] = resultset.getString(3);
                data[i][3] = resultset.getString(4);
                data[i][4] = resultset.getString(5);
                resultset.next();
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This is a helper method for searchBooks to ensure the main method is not
     * too long
     *
     * @param _author
     * @param _title
     * @param _isbn
     * @param _sql
     * @return
     */
    public ResultSet searchBooksHelper(String _author, String _title, String _isbn, String _sql) {
        try {
            if (!_isbn.equals("")) {
                _sql = "SELECT * FROM book WHERE isbn like ?";
                this.preparedstate = this.connection.prepareStatement(_sql);
                this.preparedstate.setString(1, "%" + _isbn + "%");
            } else {
                if (!_author.equals("") && !_title.equals("")) {

                    _sql = "SELECT * FROM book WHERE author like ?"
                            + " AND title like ?";
                    this.preparedstate = this.connection.prepareStatement(_sql);
                    this.preparedstate.setString(1, "%" + _author + "%");
                    this.preparedstate.setString(2, "%" + _title + "%");
                }
                if (!_author.equals("")) {
                    _sql = "select * from book where author like ? ";
                    this.preparedstate = this.connection.prepareStatement(_sql);
                    this.preparedstate.setString(1, "%" + _author + "%");
                }
                if (!_title.equals("")) {
                    _sql = "SELECT * FROM book WHERE title like ?";
                    this.preparedstate = connection.prepareStatement(_sql);
                    this.preparedstate.setString(1, "%" + _title + "%");
                }
            }
            return this.preparedstate.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /**
     * This checks out a book for a user within the MySQL Database.
     *
     * @param _isbn
     * @param _id
     * @return
     */
    public int checkoutBooks(List<String> _isbn, String _id) {

        boolean result = false;
        String sql = "";
        int cnt = 0;
        int length = _isbn.size();

        try {

            for (int i = 0; i < length; i++) {

                if (!_isbn.get(i).equals("")) {

                    sql = "INSERT INTO checkout (ID, ISBN, status) VALUES"
                            + "('" + _id + "', '" + _isbn.get(i) + "', 'Checked Out');";
                    this.preparedstate = this.connection.prepareCall(sql);
                    result = this.preparedstate.execute(sql);
                    cnt++;
                }
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return cnt;
    }

    /**
     * This checks in a User's checked out book within the MySQL Database.
     *
     * @param _isbn
     * @param _id
     * @return
     */
    public int checkInBooks(List<String> _isbn, String _id) {

        int result = 0;
        String sql = "";
        int length = _isbn.size();

        try {

            for (int i = 0; i < length; i++) {

                sql = "UPDATE checkout SET status = 'Check In' WHERE isbn = '"
                        + _isbn.get(i) + "' AND ID = '" + _id + "';";
                this.preparedstate = this.connection.prepareCall(sql);
                result = this.preparedstate.executeUpdate();
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * This creates a new library user for the MySQL Database.
     *
     * @param _user
     * @return
     */
    public int createAccount(UserModel _user) {
        int result = 0;
        String sql = "";

        try {
            sql = "INSERT INTO users (UserID, PWD, Name, userType, eMail) "
                    + "VALUES(?,?,?,?,?)";
            this.preparedstate = this.connection.prepareStatement(sql);
            this.preparedstate.setString(1, _user.getUserId());
            this.preparedstate.setString(2, _user.getPassword());
            this.preparedstate.setString(3, _user.getName());
            this.preparedstate.setString(4, _user.getUserType());
            this.preparedstate.setString(5, _user.getEmail());
            result = this.preparedstate.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * This checks within the MySQL database whether or not a user is a
     * Librarian or a Customer.
     *
     * @param _user
     * @return
     * @throws Exception
     */
    public String checkLogin(UserModel _user) {
        String sql = "";
        ResultSet result = null;
        String type = "";

        try {
            sql = "SELECT userType FROM users WHERE UserID=? AND PWD=?";
            this.preparedstate = this.connection.prepareStatement(sql);

            this.preparedstate.setString(1, _user.getUserId());
            this.preparedstate.setString(2, _user.getPassword());

            result = this.preparedstate.executeQuery();

            if (result.next()) {
                type = result.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return type;
    }

    /**
     * This method searches for a user ID for the library card with the given
     * user name.
     *
     * @param _name
     * @return
     */
    public String searchUserID(String _name) {
        String sql = "";
        ResultSet result = null;
        String id = "";
        try {

            sql = "SELECT ID from users where Name = '" + _name + "'";
            this.preparedstate = this.connection.prepareStatement(sql);
            result = this.preparedstate.executeQuery();

            if (result.next()) {
                id = result.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    //This searches for a user within the MySQL Database.
    public UserModel searchUser(String _id) {

        String sql = "";

        UserModel user = new UserModel();

        String name = "";
        String eMail = "";
        String userID = "";
        String userType = "";

        user = searchUserHelper(_id, name, eMail, userID, userType);

        return user;

    }

    //This is a helper method to ensure style guide requirements.
    public UserModel searchUserHelper(String _id, String _name, String _email, String _userID, String _userType) {
        ResultSet result;

        try {

            UserModel user = new UserModel();
            String sql = "SELECT Name, eMail, userType FROM users WHERE ID = "
                    + "'" + _id + "';";
            this.preparedstate = this.connection.prepareStatement(sql);
            result = this.preparedstate.executeQuery();

            if (result.next()) {
                _name = result.getString(1);
                _email = result.getString(2);
                _userType = result.getString(3);
            }
            user.setName(_name);
            user.setEmail(_email);
            user.setId(_id);
            user.setUserType(_userType);
                    return user;

            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBTranslator.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //This is the Table model
    public static DefaultTableModel buildTableModel(ResultSet _resultSet) {

        try {
            ResultSetMetaData metaData = _resultSet.getMetaData();

            //These are the names of the columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            //This is the data of the table
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
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDBTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
