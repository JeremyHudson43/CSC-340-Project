package Controllers;

import Models.BooksModel;
import Models.UserModel;
import Views.AddBookView;
import Views.BookDatabaseView;
import Views.CustomerView;
import Views.LibrarianView;
import Views.LibraryManagementGUI;
import Views.LoginView;


/**
 *
 * @author Jeremy Hudson Last Updated 4-10-2019
 */
public class ParentController {

    UserModel userModel = new UserModel();
    LoginView loginView = new LoginView();

   private LibraryManagementGUI libraryManage;

    public void initParentController()  {
        
                BooksController bookController = new BooksController();


        UserController userController = new UserController();
        userController.initUserController();

        

        

    }
}
