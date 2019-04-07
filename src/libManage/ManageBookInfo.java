package libManage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jeremy Hudson
 *
 * This class is used to contact the API and parse the data it receives into a
 * JSON object, which it then writes part of to a text file
 *
 * Last updated 2/25
 *
 */
public class ManageBookInfo {

    private final String baseURL
            = "https://www.googleapis.com/books/v1/volumes?q=";
    private final String apiKey
            = "&AIzaSyD2l4xicCXG_xS6iszQodS9O2u5e18s3Ck";

    public void getRequest(String _Author, String _Volume)
            throws ProtocolException, IOException {

        String responseString = "";

        URL url = new URL(baseURL + _Volume + "+inauthor:" + _Author + apiKey);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String str;
            while ((str = in.readLine()) != null) {

                responseString += str + "\n";
                System.out.println(responseString);
                parseBook(responseString);
            }
        } catch (IOException e) {
            System.out.println("No results found, try again");
        }
    }

    private void writeToText(String _title, String _author, String _imageLink)
            throws FileNotFoundException, UnsupportedEncodingException,
            IOException {
        try (FileWriter writer = new FileWriter("books.txt", true)) {

            writer.write(_author + "\n");
            writer.write(_title + "\n");
            writer.write(_imageLink + "\n");
            writer.write("\n");

            writer.close();
        }
    }

    private void parseBook(String _responseString) throws FileNotFoundException,
            UnsupportedEncodingException, IOException {
        try {
            JSONObject root = new JSONObject(_responseString);
            JSONArray books = root.getJSONArray("items");

            for (int i = 0; i < books.length(); i++) {
                JSONObject book = books.getJSONObject(i);

                JSONObject info = book.getJSONObject("volumeInfo");
                String title = info.getString("title");
                JSONArray authors = info.getJSONArray("authors");

                String author = authors.getString(0);
                JSONObject imageLinks = info.getJSONObject("imageLinks");
                String imageLink = imageLinks.getString("smallThumbnail");

                writeToText(title, author, imageLink);
                System.out.println("");
            }
        } catch (JSONException e) {

        }
    }

    private void postRequest(String _website) throws ProtocolException,
            IOException {

        URL obj = new URL(null, "https://www.example.com",
                new sun.net.www.protocol.https.Handler());

        HttpsURLConnection connection
                = (HttpsURLConnection) obj.openConnection();

        connection.setRequestMethod("POST");

        String urlParameters = "test";

        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());

        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        BufferedReader in
                = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer res = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            res.append(inputLine);
        }
        in.close();
    }
}
