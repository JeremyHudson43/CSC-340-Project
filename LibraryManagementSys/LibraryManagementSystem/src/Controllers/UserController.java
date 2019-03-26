package Controllers;

/**
 *
 * @author Charles Brady
 *
 * Last updated 3/15
 */
import Models.User;
import Database.MySQLDBTranslator;
import Views.LibraryCardView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public void CreateUser(User _user, String _name, String _password, String _id, String _Email) {
        try {
            int result;
            _user.setName(_name);
            _user.setPassword(_password);
            _user.setUserId(_id);
            _user.setEmail(_Email);

            MySQLDBTranslator SQL = new MySQLDBTranslator();
            result = SQL.createAccount(_user);

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Account Created");
                _user = SQL.searchUser(_id);
                LibraryCardView lc = new LibraryCardView(_user);
                lc.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Unabel to create account");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
