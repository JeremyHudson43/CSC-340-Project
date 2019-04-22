package Controllers;

import Models.UserModel;
import Views.LibraryManagementGUI;
import Views.LoginView;

/**
 *
 * @author Jeremy Hudson
 * Last Updated 4-17-2019
 */
public class ParentController {

    UserModel userModel = new UserModel();
    LoginView loginView = new LoginView();

    private LibraryManagementGUI libraryManage;

    public void initParentController() {

        BooksController bookController = new BooksController();

        LibraryManagementGUIController libManage = new LibraryManagementGUIController();
        UserController userController = new UserController();

        libManage.initLibraryManagementGUIController();
    }
}
