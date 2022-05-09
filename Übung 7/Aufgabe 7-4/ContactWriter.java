import java.io.FileWriter;
import java.io.IOException;

public class ContactWriter {
    public void writeToFile(Contact[] contacts, String filename) throws IOException
    {
        
    //    ContactReader cr = new ContactReader();
        FileWriter fw = new FileWriter(filename);
        StringBuilder sb = new StringBuilder();
        String headStr = "First Name;Last Name;Phone;Messenger\n";
        sb.append(headStr);
        for (int i = 0; i < contacts.length; i++)
        {
            sb.append("\"" + contacts[i].getFirstName() + "\";");
            sb.append("\"" + contacts[i].getLastName() + "\";");
            sb.append("\"" + contacts[i].getPhone() + "\";");
            for (int j = 0; j < contacts[i].getMessenger().length; j++)
            {
                if (j <= contacts[i].getMessenger().length - 2)
                {
                    sb.append("\"" + enumToReadableString(contacts, i, j) + "\",");
                }
                else
                {
                    if (i + 1 != contacts.length)
                    {
                        sb.append("\"" + enumToReadableString(contacts, i, j) + "\"\n");
                    }
                    else
                    {
                        sb.append("\"" + enumToReadableString(contacts, i, j) + "\"");
                    }
                }
            }
        }
        fw.write(sb.toString());
        fw.close();
    }

    private String enumToReadableString (Contact[] contacts, int i, int j)
    {
        if (contacts[i].getMessenger()[j].equals(Messenger.WHATSAPP))
        {
            return "WhatsApp";
        }
        if (contacts[i].getMessenger()[j].equals(Messenger.FACEBOOK_MESSENGER))
        {
            return "Facebook Messenger";
        }
        if (contacts[i].getMessenger()[j].equals(Messenger.SIGNAL))
        {
            return "Signal";
        }
        if (contacts[i].getMessenger()[j].equals(Messenger.SMS))
        {
            return "SMS";
        }
        return "";
    }
}
