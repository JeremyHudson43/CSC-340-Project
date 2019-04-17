package Models;

import Controllers.UserController;
import SQL_Translator.MySQLCaller;
import SQL_Translator.MySQLDBTranslator;
import Views.LibraryCardView;
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
    
        private static final String librarian = "librarian";
    private static final String customer = "Customer";


    private String name;
    private int id;
    private String UserId;
    private String password;
    private String userType;
    private String email;
    private String barcode;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // The getters of the variables
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return UserId;
    }

    public String getUserType() {
        return userType;
    }

// The setters of the variables
    public void setName(String _name) {
        this.name = _name;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    public void setUserId(String _UserId) {
        this.UserId = _UserId;
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
        } 
        else {
            try {
                UserModel user = new UserModel();
                user.setUserId(_username);
                user.setPassword(_password);

                MySQLDBTranslator translator = new MySQLDBTranslator();
                String result = translator.checkLogin(user);
                // if the user is a librarian, it will open the librarian view.
                if (result == null ? librarian == null 
                        : result.equals(librarian)) {

                    return "librarian";
                   // if the user is a customer, it will open the customer view.
                } else if (result == null ? customer == null : 
                        result.equals(customer)) {

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
    public void checkRegister(UserModel _user, String _name, String _password, 
            String _id, String _email)  throws Exception {
        
          try {
            int result;
            _user.setName(_name);
            _user.setPassword(_password);
            _user.setUserId(_id);
            _user.setEmail(_email);

            MySQLCaller SQL = new MySQLCaller();
            result = SQL.createAccount(_user);

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Account Created");
                _user = SQL.searchUser(_id);
                //LibraryCardView libraryCard = new LibraryCardView(_user);
                //libraryCard.setVisible(true);
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
             UserModel searched  = SQL.searchUser(_id);
                     return searched;

        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return placeholder;
    }
    
}
