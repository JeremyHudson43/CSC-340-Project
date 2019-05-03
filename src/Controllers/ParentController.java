package Controllers;

/**
 *
 * @author Jeremy Hudson 
 * Last Updated 4-28-2019
 * 
 * This is the controller that kickstarts the main view to begin the program.
 */
public class ParentController {

    public void initParentController() {

        LibraryManagementGUIController libManage = new LibraryManagementGUIController();
        libManage.initLibraryManagementGUIController();

    }
}
