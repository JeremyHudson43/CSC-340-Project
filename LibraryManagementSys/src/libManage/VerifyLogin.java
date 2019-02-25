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

        boolean _found = false;
        String _tempUsername = "";
        String _tempPassword = "";

        Scanner reader = new Scanner(System.in);

        reader = new Scanner(new File(_filePath));
        reader.useDelimiter("[,\n]");

        while (reader.hasNext() && !_found) {
            _tempUsername = reader.next();
            _tempPassword = reader.next();

            if (_tempUsername.trim().equals(_username)
                    && _tempPassword.trim().equals(_password)
                    && _userType.equals("librarian")) {
                _found = true;
                JOptionPane.showMessageDialog(null, "Sucessful login");

                JFrame libFrame = new JFrame("Librarian View");
                LibrarianView librarianView = new LibrarianView();
                libFrame.add(BorderLayout.CENTER, librarianView);
                librarianView.setPreferredSize(new Dimension(640, 480));

                libFrame.pack();
                libFrame.setVisible(true);
                librarianView.setVisible(true);
                
            } else if (_tempUsername.trim().equals(_username)
                    && _tempPassword.trim().equals(_password)
                    && _userType.equals("customer")) {
                _found = true;
                JOptionPane.showMessageDialog(null, "Sucessful login");

                JFrame custFrame = new JFrame("Customer View");
                CustomerView custView = new CustomerView();
                custFrame.add(BorderLayout.CENTER, custView);

                custView.setPreferredSize(new Dimension(640, 480));
                custFrame.pack();
                custFrame.setVisible(true);

            }
        }
        if (_found == false) {
            JOptionPane.showMessageDialog(null, "Unsucessful login");
        }
        reader.close();

    }

}
