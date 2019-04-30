package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Jeremy Hudson
 *
 * Last updated 4-25-2019
 *
 * This class contacts the Google Books API to receive information from either
 * an ISBN search or an author/title search. It receives a response string and
 * parses the information using JSONobjects, then returns the information.
 *
 * It uses a loop to gather data from the API in a 2d array in the following
 * fashion 2dArray[book][detail of book]
 */
public class GoogleBooksAPI implements ApiConnector {

    private static final String apiKey = "AIzaSyDPvUouD8UQzYc2bWylpp07l3M0uNLfcQQ";
    private static final String baseURL = "https://www.googleapis.com/books/v1/volumes?q=";

    /**
     * This returns a 2d array of books based upon only the ISBN.
     *
     *
     */
    @Override
    public String[][] loadBookNameByISBN(String _isbn) {
        String response[][] = getRequest("", "", _isbn);
        return response;
    }

    /**
     * This returns a 2d array of books based upon either the author, title, or
     * both
     *
     *
     */
    @Override
    public String[][] loadBookNameByAuthorAndTitle(String _author, String _title) {

        String authorWithSpaces = _author.replaceAll("\\s{1,}", "+");
        String titleWithSpaces = _title.replaceAll("\\s{1,}", "+");

        String response[][] = getRequest(authorWithSpaces, titleWithSpaces, "");
        return response;
    }

    /**
     * This is a get request to the API using data from BookDatabaseView.
     *
     *
     */
    public String[][] getRequest(String _author, String _volume, String _isbn) {

        try {
            URL url = new URL(this.baseURL + _volume + "+inauthor:" + _author
                    + "&key=" + this.apiKey);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (_isbn.equals("")) {

                String responseString[][] = (connectionHelper(connection));
                return responseString;
            } else {
                URL isbnURL = new URL(this.baseURL + _isbn + "&key=" + this.apiKey);

                isbnURL.openConnection();
                HttpURLConnection ISBNconnection = (HttpURLConnection) isbnURL.openConnection();

                String responseString[][] = (connectionHelper(ISBNconnection));
                return responseString;
            }
        } catch (Exception ex) {
            Logger.getLogger(GoogleBooksAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This is a helper method to read the response string from the API.
     *
     *
     */
    private static String[][] connectionHelper(HttpURLConnection _connection) {
        String[][] bookData = new String[0][0];
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(_connection.getInputStream()));
            String responseString = "";
            String str;
            while ((str = in.readLine()) != null) {
                responseString += str + "\n";
            }
            in.close();
            bookData = parseBookFromAPI(responseString);
            return bookData;
        } catch (IOException ex) {
            Logger.getLogger(GoogleBooksAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookData;
    }

    /**
     * This parses the book title, author, and imagelink from the API.
     *
     *
     */
    public static String[][] parseBookFromAPI(String _responseString) {

        JSONObject root = new JSONObject(_responseString);
        JSONArray books = root.getJSONArray("items");

        String[] individualBookData = new String[4];
        String[][] totalBookData = new String[10][4];

        totalBookData = parseBookFromAPIHelper(individualBookData, books, totalBookData);

        return totalBookData;
    }

    /**
     * This is a helper method for the parseBook method to ensure that the
     * parseBookFromAPI method is not longer than 30 lines.
     *
     *
     */
    public static String[][] parseBookFromAPIHelper(String[] _individualBookData, JSONArray _books, String[][] _totalBookData) {
        for (int i = 0; i < _books.length(); i++) {

            String bookImageLink = "";
            JSONObject book = _books.getJSONObject(i);
            JSONObject info = book.getJSONObject("volumeInfo");
            String bookTitle = info.getString("title");
            JSONArray authors = info.getJSONArray("authors");
            String bookAuthor = authors.getString(0);

            try {
                JSONObject imageLinks = info.getJSONObject("imageLinks");
                bookImageLink = imageLinks.getString("smallThumbnail");
            } catch (org.json.JSONException exception) {
                System.out.println("Warning: At least one imagelink was not found");
            }
            String bookISBN = generateNumber();

            _individualBookData[0] = bookTitle;
            _individualBookData[1] = bookAuthor;
            _individualBookData[2] = bookISBN;
            _individualBookData[3] = bookImageLink;

            for (int j = 0; j < _individualBookData.length; j++) {
                _totalBookData[i][j] = _individualBookData[j];
            }

        }
        return _totalBookData;
    }

    /**
     * This generates a random ISBN.
     *
     *
     */
    public static String generateNumber() {
        String ISBN = "978";
        for (int i = 0; i < 10; i++) {
            ISBN += (int) (Math.random() * 9 + 1);
        }
        return ISBN;
    }

}
