/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_Translator;

import Models.BooksModel;
import Models.UserModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chip Brady
 *
 * Last updated 4/12
 */
public class MySQLCaller {

    MySQLDBTranslator translator;

    public MySQLCaller() {
        try {
            this.translator = new MySQLDBTranslator();
        } catch (Exception ex) {
            Logger.getLogger(MySQLCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int addBooks(BooksModel _book) {
        return translator.addBooks(_book);
    }

    public int removeBooks(String _isbn) {
        return translator.removeBooks(_isbn);
    }

    public Object[][] searchBooks(String _author, String _title, String _isbn) {
        try {
            return translator.searchBooks(_author, _title, _isbn);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void searchBooksHelper(String _author, String _title, String _isbn) {
        translator.searchBooksHelper(_author, _title, _isbn, _isbn);
    }

    public int checkoutBooks(String[] _bookISBN, String _id) {
        return translator.checkoutBooks(_bookISBN, _id);
    }

    public int checkinBooks(String[] _bookISBN, String _id) {
        return translator.checkInBooks(_bookISBN, _id);
    }

    public int createAccount(UserModel _user) {
        return translator.createAccount(_user);
    }

    public String checkLogin(UserModel _user) {
        try {
            return translator.checkLogin(_user);
        } catch (Exception ex) {
            Logger.getLogger(MySQLCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public UserModel searchUser(String _id) {
        return translator.searchUser(_id);
    }
}
