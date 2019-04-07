
package API;

import org.json.JSONObject;

/**
 *
 * @author DELL6420
 */
public interface ApiConnector {

     public String loadBookNameByISBN(String _ISBN);

    public String loadBookNameByAuthorAndTitle(String _author, String _title);

}

