package Models;

import Controllers.UserController;
import SQL_Translator.MySQLCaller;
import Views.LoginView;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/7
 *
 * This model contains the variables for users and contains the logic that
 * verifies a customer or librarian against the SQL database for logins and
 * registrations, in addition to searching for a user and creating a new user.
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

    /**
     * These are the variable getters.
     *
     *
     *
     */
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

    /**
     * These are the setters of the variables.
     *
     *
     *
     */
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

    public void setUserId(String _userId) {
        this.userId = _userId;
    }

    public void setUserType(String _userType) {
        this.userType = _userType;
    }

//================================================================
    /**
     * If something is entered, the program will check to see if it exists in
     * the database.
     *
     *
     *
     */
    public String checkLogin(String _username, String _password) {

        if (_username.equals("") || _password.equals("")) {

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

                    return this.LIBRARIAN;
                    // if the user is a customer, it will open the customer view.
                } else if (result == null ? this.CUSTOMER == null
                        : result.equals(this.CUSTOMER)) {

                    return this.CUSTOMER;
                    /* if the username and password is not in the database,
                    it will ask the user to try again.
                     */
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginView.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    /**
     * This verifies if all input is valid for registration.
     *
     *
     *
     */
    public int checkRegister(String _userType, String _name, String _password, String _userID, String _email) {

        UserModel user = new UserModel();

        try {

            user.setName(_name);
            user.setPassword(_password);
            user.setUserId(_userID);
            user.setEmail(_email);
            user.setUserType(_userType);

            int result = checkRegisterHelper(user);
            return result;

        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * This is a helper method to ensure that checkRegister is not more than 30
     * lines.
     *
     *
     *
     */
    public int checkRegisterHelper(UserModel _user) {
        boolean check = false;
        int result;

        MySQLCaller SQL = new MySQLCaller();
        check = SQL.checkUser(_user);

        if (check == true) {

            if (!_user.getEmail().contains("@")) {
                result = 0;
                return result;
            }
            if (_user.getName().equals("") || _user.getUserId().equals("") || _user.getPassword().equals("") || _user.getEmail().equals("")) {
                result = 0;
                return result;
            }

            result = SQL.createAccount(_user);
            if (result > 0) {
                String idNumber = SQL.searchUserID(_user.getName());
                _user.setId(idNumber);
                return result;
            }

        }

        return 0;

    }

    /**
     * This creates a new user account.
     *
     *
     */
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

    /**
     * This searches for user in the database. *
     *
     *
     */
    public UserModel searchUser(String _id) {
        UserModel user = new UserModel();
        try {
            MySQLCaller SQL = new MySQLCaller();
            user = SQL.searchUser(_id);
            return user;
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
