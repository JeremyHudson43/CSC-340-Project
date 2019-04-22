
package API;

import org.json.JSONObject;

/**
 *
 * @author Jeremy Hudson
 *
 * Last updated 4/17
 */
public interface ApiConnector {

    public String loadBookNameByISBN(String _ISBN);

    public String loadBookNameByAuthorAndTitle(String _author, String _title);

}

