
package Controllers;

import Views.CustomerView;


public class CustomerController extends BooksController {
    CustomerView customerView = new CustomerView();
    
    public void initCustomerController() {
        customerView.setVisible(true);
        customerView.databaseListener(e -> displayBookDB());
    }
    
}
