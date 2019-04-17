package Controllers;

import Views.LibraryManagementGUI;

public class LibraryManagementGUIController extends UserController {

    private LibraryManagementGUI libraryManagement = new LibraryManagementGUI();

    //This adds listeners to the main login and register buttons.
    public void initLibraryManagementGUIController() {
        this.libraryManagement.setVisible(true);
        this.libraryManagement.addLoginListener(e -> displayLogin());
        this.libraryManagement.addRegisterListener(e -> displayRegister());
    }

}
