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

    public void getRequest(String _Author, String _Volume)
            throws ProtocolException, IOException {

        String responseString = "";

        URL url = new URL("https://www.googleapis.com/books/v1/volumes?q="
                + _Volume + "+inauthor:" + _Author
                + "&key=AIzaSyDPvUouD8UQzYc2bWylpp07l3M0uNLfcQQ");
        //            + "&AIzaSyD2l4xicCXG_xS6iszQodS9O2u5e18s3Ck");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String str;
            while ((str = in.readLine()) != null) {

                responseString += str + "\n";
                System.out.println(responseString);
                parseBook(responseString);
            }

        }
    }

    private void writeToText(String title, String author, String imageLink)
            throws FileNotFoundException, UnsupportedEncodingException,
            IOException {
        try (FileWriter writer = new FileWriter("books.txt", true)) {
            writer.write(author + "\n");
            writer.write(title + "\n");
            writer.write(imageLink + "\n");
            writer.close();
        }
    }

    private void parseBook(String responseString) throws FileNotFoundException,
            UnsupportedEncodingException, IOException {
        try {
            JSONObject root = new JSONObject(responseString);
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

    private void postRequest(String website) throws ProtocolException,
            IOException {

        URL obj = new URL(null, "https://www.example.com",
                new sun.net.www.protocol.https.Handler());

        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("POST");

        String urlParameters = "test";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        BufferedReader in
                = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer res = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            res.append(inputLine);
        }
        in.close();
    }
}
