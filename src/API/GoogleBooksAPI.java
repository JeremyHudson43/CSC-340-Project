package API;

import Models.BooksModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GoogleBooksAPI implements ApiConnector {

    private static final String apiKey
            = "AIzaSyDPvUouD8UQzYc2bWylpp07l3M0uNLfcQQ";
    private static final String baseURL
            = "https://www.googleapis.com/books/v1/"
            + "volumes?q=";

    @Override
    public String loadBookNameByISBN(String _ISBN) {
            String response = getRequest("", "", _ISBN);
            return response;


    }

    @Override
    public String loadBookNameByAuthorAndTitle(String _author, String _title)  {

            String response = getRequest(_author, _title, "");
            return response;


       

    }
    //get request to the API using data from BookDatabaseView
    public String getRequest(String _Author, String _Volume, String _ISBN) {

        try {
            URL url = new URL(baseURL + _Volume + "+inauthor:" + _Author
                    + "&key=" + apiKey);
            
            HttpURLConnection connection = (HttpURLConnection) 
                    url.openConnection();
            
            connection.setRequestMethod("GET");
            
            if (_ISBN.equals("")) {
                
                String responseString = (connectionHelper(connection));
                
                return responseString;
                
                
            } else {
                URL ISBNurl = new URL(baseURL + _ISBN + "&key=" + apiKey);
                
                ISBNurl.openConnection();
                HttpURLConnection ISBNconnection
                        = (HttpURLConnection) ISBNurl.openConnection();
                
                String responseString = (connectionHelper(ISBNconnection));
                
                loadBookNameByAuthorAndTitle(responseString, "");
                return responseString;
                
            }
        } catch (Exception ex) {
            Logger.getLogger(GoogleBooksAPI.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    
        return null;
    }

    //helper method to read data from API
    private static String connectionHelper(
            HttpURLConnection _connection) throws IOException, Exception {

        try (
                BufferedReader in = new BufferedReader
        (new InputStreamReader(_connection.getInputStream()))) {

            String responseString = "";

            String str;
            while ((str = in.readLine()) != null) {
                responseString += str + "\n";

            }
            return responseString;
        }

    }
}
