
package SQL_Translator;

import Models.BooksModel;
import Models.UserModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chip Brady
 *
 * Last updated 4/12
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
        return this.translator.addBooks(_book);
    }

    public boolean checkUser(UserModel _user) {
        return this.translator.checkUser(_user);
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
            return this.translator.searchBooks(_author, _title, _isbn);
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
    public int checkoutBooks(List<String> _bookISBN, String _id) {
        return this.translator.checkoutBooks(_bookISBN, _id);
    }

    /**
     * This calls the checkinBooks method in the MySQL translator.
     *
     * @param _bookISBN
     * @param _id
     * @return
     */
    public int checkinBooks(List<String> _bookISBN, String _id) {
        return translator.checkInBooks(_bookISBN, _id);
    }

    /**
     * This calls the createAccount method in the MySQL translator.
     *
     * @param _user
     * @return
     */
    public int createAccount(UserModel _user) {
        return this.translator.createAccount(_user);
    }

    /**
     * This calls the checkLogin method in the MySQL translator.
     *
     * @param _user
     * @return
     */
    public String checkLogin(UserModel _user) {
        try {
            return this.translator.checkLogin(_user);
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
        return this.translator.searchUserID(_name);
    }

    /**
     * This calls the searchUser method in the MySQL translator.
     *
     * @param _id
     * @return
     */
    public UserModel searchUser(String _id) {
        return this.translator.searchUser(_id);
    }
}
