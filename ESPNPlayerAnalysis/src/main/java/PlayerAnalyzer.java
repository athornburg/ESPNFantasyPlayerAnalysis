/**
 * User: alexthornburg
 * Date: 10/22/13
 * Time: 8:36 PM
 */

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;
import java.io.File;
import com.googlecode.gmail4j.javamail.*;

import com.googlecode.gmail4j.*;
import com.googlecode.gmail4j.auth.Credentials;

public class PlayerAnalyzer {
    static Map<String,String> playerMap = new HashMap<String,String>();
    static ArrayList<String>roster = new ArrayList<String>();
    public static void main(String[] args){
        GmailClient client = new ImapGmailClient();
        Credentials creds = new Credentials();
        creds.setUsername("alexthornburg1@gmail.com");
        creds.setPassword("PUT PASSWORD HERE".toCharArray());
        GmailConnection connection = new ImapGmailConnection(creds);
        client.setConnection(connection);
        try {
            Scanner sc = new Scanner(new File("ESPNPlayerAnalysis/src/main/resources/roster.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String playerName = line.split(" ")[1]+"  "+line.split(" ")[2];
                roster.add(playerName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        RosterPopulator populator = new RosterPopulator();
         playerMap = populator.getRosterMap();
        StringBuilder sb = new StringBuilder();
        for(Entry e:playerMap.entrySet()){
             for(String name:roster){
                 if(e.getKey().toString().equals(name)){
                    sb.append(e.getKey()+" "+e.getValue()+"\n");
                 }
             }

        }
        JavaMailGmailMessage message = new JavaMailGmailMessage();
        message.setSubject("Injury Report");
        message.addTo(new EmailAddress("alexthornburg1@gmail.com"));
        message.setContentText(sb.toString());
        client.send(message);

    }
}



