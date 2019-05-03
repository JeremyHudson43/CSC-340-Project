package API;

/**
 *
 * @author Jeremy Hudson 
 * Last updated 4-19-2019
 * 
 * This class returns the two dimensional array of book data from the API class
 */
public class APITranslator implements ApiConnector {

    protected static final ApiConnector thisApi = new GoogleBooksAPI();

    @Override
    public String[][] loadBookNameByISBN(String _isbn) {
        return APITranslator.thisApi.loadBookNameByISBN(_isbn);
    }

    @Override
    public String[][] loadBookNameByAuthorAndTitle(String _author, String _title) {
        return APITranslator.thisApi.loadBookNameByAuthorAndTitle(_author, _title);
    }

}
