package Controllers;

import Views.CustomerView;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/* @author Jeremy Hudson
   Last updated 4-22-2019
 */

public class CustomerController extends BooksController {

    CustomerView customerView = new CustomerView();

    /**
     * This method creates the customer view with all of the buttons.
     */
    public void initCustomerController() {

        JFrame frame = new JFrame();
        frame.add(BorderLayout.CENTER, this.customerView);
        frame.pack();
        frame.setVisible(true);

        this.customerView.setVisible(true);
        this.customerView.databaseListener(e -> displayBookDB());

    }

}
