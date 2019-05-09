package API;

/**
 *
 * @author Jeremy Hudson
 * 
 * This class gets the information from the API in the following fashion: 2dArray[book][detail of book] 
 */
public interface ApiConnector {

    public String[][] loadBookNameByISBN(String _ISBN);

    public String[][] loadBookNameByAuthorAndTitle(String _author, String _title);

}
