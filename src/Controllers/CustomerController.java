
package Controllers;

import Views.CustomerView;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/* @author Jeremy Hudson
   Last updated 4-22-2019
   
*/

public class CustomerController extends BooksController {
    CustomerView customerView = new CustomerView();
    
    public void initCustomerController() {
        
        JFrame frame = new JFrame();
        frame.add(BorderLayout.CENTER, customerView);
        frame.pack();
        frame.setVisible(true);
        
        customerView.setVisible(true);
        customerView.databaseListener(e -> displayBookDB());
    }
    
}
