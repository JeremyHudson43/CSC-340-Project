package libManage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Charles Brady
 * @author Jeremy Hudson
 *
 * Last updated 2/20
 *
 * This class is used to check if the username and login exist and if they do,
 * allow the relevant user to access the system
 */
public class VerifyLogin extends javax.swing.JPanel {

    public static void verifyLogin(String _username,
            String _password, String _filePath, String _userType)
            throws FileNotFoundException {

        Scanner reader = new Scanner(System.in);

        reader = new Scanner(new File(_filePath));
        reader.useDelimiter("[,\n]");

        boolean _found = false;

        while (reader.hasNext() && !_found) {
            String tempUsername = reader.next();
            String tempPassword = reader.next();

            _found = trimAndLogin(tempUsername, _username,
                    tempPassword, _password, _userType);
        }

        if (_found == false) {
            JOptionPane.showMessageDialog(null, "Unsucessful login");

        }
        reader.close();

    }

    private static boolean trimAndLogin(String _tempUsername,
            String _username, String _tempPassword,
            String _password, String _userType) {

        boolean _found = false;

        if (_tempUsername.trim().equals(_username)
                && _tempPassword.trim().equals(_password)
                && _userType.equals("librarian")) {

            _found = true;

            verifyLoginLibrarian();

        } else if (_tempUsername.trim().equals(_username)
                && _tempPassword.trim().equals(_password)
                && _userType.equals("customer")) {

            _found = true;

            verifyLoginCustomer();
        }

        return _found;
    }

    private static void verifyLoginLibrarian() {
        JOptionPane.showMessageDialog(null, "Sucessful login");

        JFrame libFrame = new JFrame("Librarian View");
        LibrarianView librarianView = new LibrarianView();
        libFrame.add(BorderLayout.CENTER, librarianView);
        librarianView.setPreferredSize(new Dimension(640, 480));

        libFrame.pack();
        libFrame.setVisible(true);
        librarianView.setVisible(true);

    }

    private static void verifyLoginCustomer() {
        JOptionPane.showMessageDialog(null, "Sucessful login");

        JFrame custFrame = new JFrame("Customer View");
        CustomerView custView = new CustomerView();
        custFrame.add(BorderLayout.CENTER, custView);

        custView.setPreferredSize(new Dimension(640, 480));
        custFrame.pack();
        custFrame.setVisible(true);

    }
}
