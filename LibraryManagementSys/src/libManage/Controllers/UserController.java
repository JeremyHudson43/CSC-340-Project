package Controllers;

/**
 *
 * @author Charles Brady
 *
 * Last updated 3/15
 */
import Models.User;
import net.sourceforge.barbecue.*;
import java.sql.*;
import Database.MySQLDBTranslator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController extends User {

    public UserController() throws Exception {
        super();
    }

    //Create new user account
    public int CreateAccount(User _user) {
        int result = 0;
        try {
            MySQLDBTranslator SQL = new MySQLDBTranslator();
            result = SQL.createAccount(_user);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //Search for user in the database
    public User SearchUser(String _id) {
        User searched = null;
        try {
            MySQLDBTranslator SQL = new MySQLDBTranslator();
            searched = SQL.searchUser(_id);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searched;
    }
}
