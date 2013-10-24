import com.googlecode.gmail4j.EmailAddress;
import com.googlecode.gmail4j.GmailMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: alexthornburg
 * Date: 10/24/13
 * Time: 10:03 AM
 */
public class InjuryReportMessage extends GmailMessage {
    EmailAddress to;
    String messageText;

    public InjuryReportMessage(){}

    @Override
    public String getSubject() {
        return "Injury Report";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Date getSendDate() {
        return new Date();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EmailAddress getFrom() {
        return new EmailAddress("alexthornburg1@gmail.com");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<EmailAddress> getTo() {
        ArrayList<EmailAddress> add = new ArrayList<EmailAddress>();
        add.add(to);
        return add;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMessageNumber() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addTo(EmailAddress to){
         this.to = to;
    }

    @Override
    public void setContentText(String s){
          this.messageText = s;
    }

    @Override
    public String getContentText(){
        return this.messageText;
    }


}
