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
 * Last updated 4-30-2019
 *
 * This class contacts the Google Books API to receive information from either
 * an ISBN search or an author/title search. It receives a response string and
 * parses the information using JSONobjects, then returns the information.
 *
 * It uses a loop to gather data from the API in a 2d array in the following
 * fashion: Array[book][detail of book].
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
     * both.
     *
     *
     */
    @Override
    public String[][] loadBookNameByAuthorAndTitle(String _author, String _title) {

        //If the author or title string contains a space, replace it with a plus for API formatting.
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
    private String[][] getRequest(String _author, String _volume, String _isbn) {

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
     * This parses the book title, author, and image link from the API.
     *
     *
     */
    private static String[][] parseBookFromAPI(String _responseString) {
        String[] individualBookData = new String[5];
        String[][] totalBookData = new String[10][5];
        try {
            JSONObject root = new JSONObject(_responseString);
            JSONArray books = root.getJSONArray("items");

            totalBookData = parseBookFromAPIHelper(individualBookData, books, totalBookData);

            return totalBookData;

        } catch (org.json.JSONException e) {
            System.out.println("There was an error parsing the JSONObject.");
        }
        return totalBookData;
    }

    /**
     * This is a helper method for the parseBook method to ensure that the
     * parseBookFromAPI method is not too long.
     *
     *
     */
    private static String[][] parseBookFromAPIHelper(String[] _individualBookData, JSONArray _books, String[][] _totalBookData) {
        for (int i = 0; i < _books.length(); i++) {

            String bookImageLink = "";
            String bookISBN = "";
            String bookAuthor = "";

            JSONObject book = _books.getJSONObject(i);
            JSONObject info = book.getJSONObject("volumeInfo");

            String bookTitle = info.getString("title");
            JSONArray authors = info.getJSONArray("authors");
            JSONArray category = info.getJSONArray("categories");
            String categoryString = category.getString(0);

            try {
                JSONArray isbn = info.getJSONArray("industryIdentifiers");
                bookISBN = extractISBN(isbn.toString());

                bookAuthor = authors.getString(0);

                JSONObject imageLinks = info.getJSONObject("imageLinks");
                bookImageLink = imageLinks.getString("smallThumbnail");
            } catch (org.json.JSONException exception) {
                System.out.println("Warning: At least one imagelink was not found");
            }

            _individualBookData[0] = bookTitle;
            _individualBookData[1] = bookAuthor;
            _individualBookData[2] = bookISBN;
            _individualBookData[3] = bookImageLink;
            _individualBookData[4] = categoryString;

            for (int j = 0; j < _individualBookData.length; j++) {
                _totalBookData[i][j] = _individualBookData[j];
            }

        }
        return _totalBookData;
    }

    private static String extractISBN(String _isbn) {

        //This splits the resposne into multiple lines
        _isbn = _isbn.replaceAll(",", "\n");

        //This turns every linebreak into an individual string and places them into an array
        String textStr[] = _isbn.split("\\r\\n|\\n|\\r");
        String finalISBN[] = new String[textStr.length];
        String isbnToReturn;
        
        try {
            finalISBN[0] = textStr[0].replace("{\"identifier\":", "");
            if (finalISBN[0].matches(".*\\d+.*")) {
                _isbn = finalISBN[0].replace("[\"", "");
                isbnToReturn = _isbn.replace("\"", "");

                return isbnToReturn;
            }
        } catch (Exception exception) {
            System.out.println("");
        }
        return "";
    }
}
