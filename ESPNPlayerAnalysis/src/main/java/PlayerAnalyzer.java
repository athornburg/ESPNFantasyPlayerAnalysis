/**
 * User: alexthornburg
 * Date: 10/22/13
 * Time: 8:36 PM
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class PlayerAnalyzer {
    static Map<String,String> playerMap = new HashMap<String,String>();
    public static void main(String[] args){
         RosterPopulator roster = new RosterPopulator();
         playerMap = roster.getRosterMap();
        for(Entry e:playerMap.entrySet()){
             System.out.println(e.getKey()+" "+e.getValue());
        }


    }
}
