package SQL_Translator;

import Models.BooksModel;
import Models.UserModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Brady
 *
 * Last updated 4/21
 *
 * This is the caller for the MySQL translator.
 */
public class MySQLCaller {

    MySQLDBTranslator translator;

    public MySQLCaller() {
        try {
            this.translator = new MySQLDBTranslator();
        } catch (Exception ex) {
            Logger.getLogger(MySQLCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method calls the addBooks method in the MySQL translator.
     *
     * @param _book
     * @return
     */
    public int addBooks(BooksModel _book) {
        return translator.addBooks(_book);
    }

    /**
     * This method calls the removeBooks method in the MySQL translator.
     *
     * @param _isbn
     * @return
     */
    public int removeBooks(String _isbn) {
        return translator.removeBooks(_isbn);
    }

    /**
     * This method calls the searchBooks method in the MySQL translator.
     *
     * @param _author
     * @param _title
     * @param _isbn
     * @return
     */
    public Object[][] searchBooks(String _author, String _title, String _isbn) {
        try {
            return translator.searchBooks(_author, _title, _isbn);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This calls the checkoutBooks method in the MySQL translator.
     *
     * @param _bookISBN
     * @param _id
     * @return
     */
    public int checkoutBooks(String[] _bookISBN, String _id) {
        return translator.checkoutBooks(_bookISBN, _id);
    }

    /**
     * This calls the checkinBooks method in the MySQL translator.
     *
     * @param _bookISBN
     * @param _id
     * @return
     */
    public int checkinBooks(String[] _bookISBN, String _id) {
        return translator.checkInBooks(_bookISBN, _id);
    }

    /**
     * This calls the createAccount method in the MySQL translator.
     *
     * @param _user
     * @return
     */
    public int createAccount(UserModel _user) {
        return translator.createAccount(_user);
    }

    /**
     * This calls the checkLogin method in the MySQL translator.
     *
     * @param _user
     * @return
     */
    public String checkLogin(UserModel _user) {
        try {
            return translator.checkLogin(_user);
        } catch (Exception ex) {
            Logger.getLogger(MySQLCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This calls the searchUserID in the MySQL translator.
     *
     * @param _name
     * @return
     */
    public String searchUserID(String _name) {
        return translator.searchUserID(_name);
    }

    /**
     * This calls the searchUser method in the MySQL translator.
     *
     * @param _id
     * @return
     */
    public UserModel searchUser(String _id) {
        return translator.searchUser(_id);
    }
}
