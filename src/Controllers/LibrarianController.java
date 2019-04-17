package Controllers;

import Models.LibrarianModel;
import Models.UserModel;
import Views.AddBookView;
import Views.CheckinView;
import Views.CheckoutView;
import Views.IndividualCustomerView;
import Views.LibrarianView;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class LibrarianController extends BooksController {

    private LibrarianView librarianView = new LibrarianView();
    private LibrarianModel librarianModel = new LibrarianModel();
    private CheckinView checkInView = new CheckinView();
    private AddBookView addBookView = new AddBookView();
    private CheckoutView checkoutView = new CheckoutView();
    private IndividualCustomerView individualCustomerView = new IndividualCustomerView();


    public void initLibrarianController() {
        librarianView.setVisible(true);

        this.librarianView.databaseListener(e -> displayBookDB());
        this.librarianView.bookAddListener(e -> displayAddBookView());
        this.librarianView.customerSearchListener(e -> customerDisplay());
        this.librarianView.checkInListener(e -> displayCheckInView());
        this.librarianView.checkOutListener(e -> displayCheckOutView());

    }

    /*This gets the userID and ISBNs from checkoutView and contacts the model to 
    checkout the books in the database
     */
    private void checkOut() {
        String userID = checkoutView.getUserID();
        String isbn1 = checkoutView.getISBN1();
        String isbn2 = checkoutView.getISBN2();
        String isbn3 = checkoutView.getISBN2();
        String isbn4 = checkoutView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};

        librarianModel.checkOutBooksByISBN(isbn, userID);

    }

    //This displays the checkin view.
    private void displayCheckInView() {
        this.checkInView.setVisible(true);
        this.checkInView.checkinListener(e -> {
            try {
                checkIn();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    private void checkIn() {
        String userID = checkInView.getUserID();
        String isbn1 = checkInView.getISBN1();
        String isbn2 = checkInView.getISBN2();
        String isbn3 = checkInView.getISBN2();
        String isbn4 = checkInView.getISBN2();

        String[] isbn = {isbn1, isbn2, isbn3, isbn4};
        librarianModel.checkInBooksByISBN(isbn, userID);

    }
    
    //This displays the checkout view.
    private void displayCheckOutView() {
        this.checkoutView.setVisible(true);
        this.checkoutView.checkOutListener(e -> {
            try {
                checkOut();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    //This displays the add book view. 
    public void displayAddBookView() {
        this.addBookView.setVisible(true);
        this.addBookView.addBookListener(e -> {
            try {
                addBooks();
            } catch (Exception ex) {
                Logger.getLogger(BooksController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });

    }

    //This gets book info from the API by title and author or by ISBN.
    private void addBooks() throws Exception {

        String author = addBookView.getAuthor();
        String title = addBookView.getTitle();
        String ISBN = addBookView.getISBN();

        if (ISBN.equals("")) {
            librarianModel.loadBookNameByAuthorAndTitle(author, title);
        } else {
            librarianModel.loadBookByISBN(ISBN);
        }
    }

    //displays individual customer information 
    public void customerDisplay() {

        UserModel placeholder = new UserModel();
        

        placeholder = userModel.searchUser(librarianView.getCustomerSearchTextField());

        individualCustomerView.setCustomerName(placeholder.getName());
        individualCustomerView.setCustomerEmail(placeholder.getEmail());
        // individualCustomerView.setCustomerID(placeholder.getId());

        
        JFrame frame = new JFrame();
        frame.add(BorderLayout.CENTER, individualCustomerView);
        frame.pack();
        frame.setVisible(true);
        individualCustomerView.setVisible(true);
    
}
}