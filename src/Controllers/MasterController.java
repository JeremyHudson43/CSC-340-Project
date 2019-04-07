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
public class MasterController {

    LibrarianView librarianView;
    CustomerView customerView;
    LibraryManagementGUI libraryManagement;

    public MasterController(LibrarianView librarianView,
            CustomerView customerView,
            LibraryManagementGUI libraryManagement) {
        this.librarianView = librarianView;
        this.customerView = customerView;
        this.libraryManagement = libraryManagement;
    }

    public MasterController(LibrarianView librarianView) {
        this.librarianView = librarianView;
    }

    public MasterController(CustomerView customerView) {
        this.customerView = customerView;
    }

    public MasterController() {
    }

}
