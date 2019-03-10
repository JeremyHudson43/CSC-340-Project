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
    private String id;
    private String password;
    private String userType;
    private String email;

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

    public String getId() {
        return id;
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

    public void setId(String _id) {
        this.id = _id;
    }

    public void setUserType(String _userType) {
        this.userType = _userType;
    }

//================================================================
}
