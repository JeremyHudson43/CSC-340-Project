package libManage;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/6
 *
 * This program connects to the SQL Database to store the books and users in.
 */
import java.sql.*;

public class Database {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private final String URL = "jdbc:mysql://localhost:3306/library";
    private final String acct = "librarian";
    private final String pass = "Alexandria";


    // get connection to mySQL
    public Connection getConnection() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            con = DriverManager.getConnection(URL, acct, pass);
        } catch (Exception e) {
            System.out.println("Could not create conection.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return con;
    }

    // close Connection to mySQL
    public void closeConnection(Connection con) throws Exception {
        try {
            con.close();
        } catch (Exception _e) {
            System.out.println(_e);
        }
    }

}
