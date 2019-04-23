package Models;

import Controllers.UserController;
import SQL_Translator.MySQLCaller;
import Views.LoginView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/7
 *
 * This is the model for the user class.
 */
public class UserModel {


    private static final String LIBRARIAN = "librarian";
    private static final String CUSTOMER = "customer";

    private String name;
    private String id;
    private String userId;
    private String password;
    private String userType;
    private String email;

    // The getters of the variables
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserType() {
        return userType;
    }

// The setters of the variables
    public void setName(String _name) {
        this.name = _name;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    public void setUserId(String _UserId) {
        this.userId = _UserId;
    }

    public void setUserType(String _userType) {
        this.userType = _userType;
    }

//================================================================

    /* If something is entered, the program will check to see if it exists in
    the database. */
    public String checkLogin(String _username, String _password) {
        if (_username.equals("") || _password.equals("")) {
            JOptionPane.showMessageDialog(null, "Required fields not entered. "
                    + "Please try again.");
        } else {
            try {
                UserModel user = new UserModel();
                user.setUserId(_username);
                user.setPassword(_password);

                MySQLCaller call = new MySQLCaller();
                String result = call.checkLogin(user);
                // if the user is a librarian, it will open the librarian view.
                if (result == null ? this.LIBRARIAN == null
                        : result.equals(this.LIBRARIAN)) {

                    return "librarian";
                    // if the user is a customer, it will open the customer view.
                } else if (result == null ? this.CUSTOMER == null
                        : result.equals(this.CUSTOMER)) {

                    return "customer";
                    /* if the username and password is not in the database,
                    it will ask the user to try again.
                     */
                } else {
                    JOptionPane.showMessageDialog(null, " User does not exist."
                            + " Please try again.");
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginView.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    //This creates an acocunt if all input is valid.
    public void checkRegister(String _userType, String _name, String _password,
            String _userID, String _email) throws Exception {

        UserModel user = new UserModel();

        try {
            int result;
            user.setName(_name);
            user.setPassword(_password);
            user.setUserId(_userID);
            user.setEmail(_email);
            user.setUserType(_userType);

            MySQLCaller SQL = new MySQLCaller();
            result = SQL.createAccount(user);

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Account Created");
                String idNumber = SQL.searchUserID(_name);
                user.setId(idNumber);

            } else {
                JOptionPane.showMessageDialog(null, "Unable to create account");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    //This creates a new user account.
    public int createAccount(UserModel _user) {
        int result = 0;
        try {
            MySQLCaller SQL = new MySQLCaller();
            result = SQL.createAccount(_user);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return result;
    }

    //This searches for user in the database.
    public UserModel searchUser(String _id) {
        UserModel placeholder = new UserModel();
        try {
            MySQLCaller SQL = new MySQLCaller();
            placeholder = SQL.searchUser(_id);
            return placeholder;
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return placeholder;
    }
}

    

