package Controllers;

/**
 *
 * @author Charles Brady
 *
 * Last updated 3/7
 */
import Models.User;
import libManage.Database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController extends User {

    Database d;
    Connection con;
    PreparedStatement pst;

    public UserController() throws Exception {
        super();
        d = new Database();
        con = d.getConnection();
    }

    public int createAccount(User u) {
        int res = 0;
        String sql = "";

        try {
            sql = "INSERT INTO users (ID, PWD, Name, userType) "
                    + "VALUES(?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getId());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getName());
            pst.setString(4, u.getUserType());
            res = pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public String CheckLogin(User u) throws Exception {
        String sql = "";
        ResultSet rs = null;
        String type = "";

        try {
            sql = "SELECT userType FROM users WHERE ID=? AND PWD=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, u.getId());
            pst.setString(2, u.getPassword());

            rs = pst.executeQuery();

            if (rs.next()) {
                type = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return type;
    }

    public User searchUser(String _id) {

        String sql = "";
        ResultSet rs;

        User u = new User();

        u.setId(_id);

        try {

            sql = "SELECT * FROM users WHERE id = " + _id;
            rs = pst.executeQuery(sql);

            if (rs.next()) {
                u.getName();
                u.getPassword();
                u.getUserType();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }

}
