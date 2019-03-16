package Models;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/7
 *
 * This is the model for the user class.
 */
public class User {

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
}
