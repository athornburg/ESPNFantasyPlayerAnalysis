/**
 * User: alexthornburg
 * Date: 10/22/13
 * Time: 8:00 PM
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
import com.google.gson.*;

public class InjuryChecker {
    private String firstName;
    private String lastName;
    private boolean injuryFlag;
    private static String APIURL = null;
    private static String APIKEY = null;

    public InjuryChecker(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setKey(String key){
        APIKEY = key;

    }

    public void setUrl(String url){
        APIURL = url;

    }


    public JsonArray getAthletes( int offset)
            throws Exception {
        final String json = connectToAPI(getUrl(offset));
        final JsonArray sports = getSportsJsonArray(json);
        final JsonElement league = sports.get(0);
        return league.getAsJsonObject().get("leagues").getAsJsonArray().get(0)
                .getAsJsonObject().get("athletes").getAsJsonArray();
    }

    private static JsonArray getSportsJsonArray(final String json) {
        final JsonArray sports = new JsonParser().parse(json).getAsJsonObject()
                .get("sports").getAsJsonArray();
        return sports;
    }


    private static String getUrl(int offset) {
        return APIURL + APIKEY+"&offset=" + offset;
    }



    public static String connectToAPI(String urlString){
        BufferedReader reader = null;
        try {
            final URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            final StringBuffer buffer = new StringBuffer();
            int read;
            final char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        } catch (MalformedURLException e) {
            System.out.println("Bad URL");
        } catch (IOException e) {
            System.out.println("Error Reading File");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing reader");
                }
            }
        }
        return null;

    }
}

