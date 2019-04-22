
package API;

/**
 *
 * @author Jeremy Hudson
 *
 * Last Updated 4/17
 */
public class APITranslator implements ApiConnector {

    protected static final ApiConnector thisApi = new GoogleBooksAPI();

    @Override
    public String loadBookNameByISBN(String _ISBN) {
        return APITranslator.thisApi.loadBookNameByISBN(_ISBN);
    }

    @Override
    public String loadBookNameByAuthorAndTitle(String _author, String _title) {
        return APITranslator.thisApi.loadBookNameByAuthorAndTitle( _author, _title);
    }

}

