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
        InjuryChecker checker = new InjuryChecker("Deron","Williams");
        checker.setKey("f64x7ykwpmch2qnnk2rhbwwh");
        checker.setUrl("http://api.espn.com/v1/sports/basketball/nba/athletes?apikey=");
        for (int offset = 1; offset < 650; offset = offset + 50) {
            try {
                final JsonArray athletes = checker.getAthletes(offset);
                for (final JsonElement athlete : athletes) {
                    if(athlete.getAsJsonObject().get("fullName").equals("Wilson Chandler")){
                        idMap.put(athlete.getAsJsonObject().get("fullName").toString(),
                                athlete.getAsJsonObject().get("id").toString());
                    }
                }
            } catch (Exception e) {
            }
        }
        return idMap;
    }


}
