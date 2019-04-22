package Controllers;

import Views.LibraryManagementGUI;

/* @author Jeremy Hudson
   Last updated 4-22-2019
*/

public class LibraryManagementGUIController extends UserController {

    private LibraryManagementGUI libraryManagement = new LibraryManagementGUI();

    /*This tells login and register buttons what method to call after 
    they are pressed.   
    */
    public void initLibraryManagementGUIController() {
        this.libraryManagement.setVisible(true);
        this.libraryManagement.addLoginListener(e -> displayLogin());
        this.libraryManagement.addRegisterListener(e -> displayRegister("customer"));
    }

}
