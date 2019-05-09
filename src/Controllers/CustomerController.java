package Controllers;

import Views.CustomerView;

/**
 * @author Jeremy Hudson 
 * Last updated 4-22-2019
 *
 * This class simply sets the customer view to visible and opens the book database view if the searchDB button is clicked on the customerView.
 *
 */
public class CustomerController extends BooksController {

    private CustomerView customerView = new CustomerView();

    public void initCustomerController() {

        this.customerView.setVisible(true);
        this.customerView.databaseListener(e -> displayAndSearchBookDB());
    }

}
