
package Controllers;

import Views.AddBookView;
import Views.BookDatabaseView;
import Views.CheckoutView;
import Views.IndividualBookView;
import Views.LoginView;
import Views.RegisterView;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;


public class ViewsController {
    
    // meta method that determines which view to display 
    public void determineView(String _viewType) {
        switch (_viewType) {

            case "SearchDB":
                displayBookDB();
                break;
            case "RegisterUser":
                displayRegister();
                break;
            case "LoginUser":
                displayLogin();
                break;
            case "AddBook":
                addBookView();
                break;
            case "AddLibrarian":
                addLibrarian();
                break;
            case "CheckoutView":
                checkoutView();
                break;
            case "RegisterCustomer":
                registerCustomer();
                break;
               
            default:
                break;
        }
    }
    
    private void displayBookDB() {
             JFrame frame = new JFrame("");
        BookDatabaseView BookDBView= 
                new BookDatabaseView();
        
        frame.add(BorderLayout.CENTER, BookDBView);
        frame.pack();
        frame.setVisible(true);

        BookDBView.setVisible(true);

    }

    
     private static void displayRegister() {
            
        RegisterView libReg = new RegisterView("Customer");
        libReg.setVisible(true);

    }
     
     private static void displayLogin() {
         LoginView log = new LoginView();
        log.setVisible(true);
     }
     
     private static void addBookView(){
         AddBookView abv = new AddBookView();
        abv.setVisible(true);
     }
     
     private static void addLibrarian() {
         RegisterView registerview = new RegisterView("librarian");
        registerview.setVisible(true);
     }
     
     private static void checkoutView() {
          CheckoutView checkoutview = new CheckoutView();
        checkoutview.setVisible(true);
     }
     
 
     
     private static void registerCustomer() {
          RegisterView registerView = new RegisterView("customer");
        registerView.setVisible(true);
     }
}
