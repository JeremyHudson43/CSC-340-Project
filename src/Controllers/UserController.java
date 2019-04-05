package Controllers;

import Models.UserModel;
import Views.LoginView;
import Views.RegisterView;

/**
 *
 * @author Charles Brady
 *
 * Last updated 3/15
 */


public class UserController {

    private UserModel userModel;
    private RegisterView registerView;
    private LoginView loginView;

    public UserController(UserModel userModel, LoginView loginView) {
        this.userModel = userModel;
        this.loginView = loginView;
    }
    
    public UserController(UserModel userModel, RegisterView registerView) {
        this.registerView = registerView;
        this.userModel = userModel;
    }
    
    public void initView(String username, String password) {

        userModel.checkLogin(username, password);
    }

  
}
