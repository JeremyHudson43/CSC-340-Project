/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Views.CustomerView;
import Views.LibrarianView;
import Views.LibraryManagementGUI;


/**
 *
 * @author Jeremy Hudson Last Updated 4-5-2019
 */
public class ParentController {

    LibrarianView librarianView;
    CustomerView customerView;
    LibraryManagementGUI libraryManagement;

    public ParentController(LibrarianView librarianView,
            CustomerView customerView,
            LibraryManagementGUI libraryManagement) {
        {
            this.librarianView = librarianView;
            this.customerView = customerView;
            this.libraryManagement = libraryManagement;

            initParentController();

        }
    }

    public void initParentController() {

    }
}
