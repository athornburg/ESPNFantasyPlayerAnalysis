/**
 * User: alexthornburg
 * Date: 10/22/13
 * Time: 8:49 PM
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Map;
import java.util.HashMap;

public class RosterPopulator {
    Map<String,String> idMap;

    public RosterPopulator(){
        idMap = new HashMap<String,String>();
    }

    public Map getRosterMap(){
        InjuryChecker checker = new InjuryChecker();
        checker.setKey("ADD API KEY");
        checker.setUrl("http://api.espn.com/v1/sports/basketball/nba/athletes?apikey=");
        for (int offset = 1; offset < 650; offset = offset + 50) {
            try {
                final JsonArray athletes = checker.getAthletes(offset);
                for (final JsonElement athlete : athletes) {
                        idMap.put(athlete.getAsJsonObject().get("fullName").getAsString(),
                                athlete.getAsJsonObject().get("injuryStatus").getAsString());
                    }

            } catch (Exception e) {
            }
        }
        return idMap;
    }


}
