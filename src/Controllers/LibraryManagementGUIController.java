package Controllers;

import Views.LibraryManagementGUI;

/**
 * @author Jeremy Hudson Last updated 4-29-2019
 *
 * This class sets the main login window to visible and calls the displayLogin
 * method in the UserController if the login button is clicked and registers a
 * new customer if the register button is clicked
 */
public class LibraryManagementGUIController extends UserController {

    private LibraryManagementGUI libraryManagement = new LibraryManagementGUI();

    /**This tells login and register buttons what method to call after they are pressed.
    *
    *
    */
    public void initLibraryManagementGUIController() {
        this.libraryManagement.setVisible(true);
        this.libraryManagement.addLoginListener(e -> displayLogin());
        this.libraryManagement.addRegisterListener(e -> displayRegister("customer"));
    }

}
