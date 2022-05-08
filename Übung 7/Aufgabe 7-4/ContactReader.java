import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class ContactReader {
    private Contact[] contacts;

    public ContactReader()
    {

    }

    public Contact[] getContacts()
    {
        return contacts;
    }

    private void readFromFile (String filename) throws IOException
    {
        // StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                Contact contact;
                if (line.startsWith("["))
                {
                    contact = new Contact();
                    addSpaceToArray(contacts);
                    contacts[contacts.length-1] = contact;
                }
                if (line.contains("first_name"))
                {
                    contact.setFirstName(line.substring(line.indexOf("\"") + 1, line.indexOf("\"", line.indexOf("\""))));
                }
                if (line.contains("last_name"))
                {
                    contact.setLastName(line.substring(line.indexOf("\"") + 1, line.indexOf("\"", line.indexOf("\""))));
                }
                if (line.contains("phone"))
                {
                    contact.setPhone(line.substring(line.indexOf("\"") + 1, line.indexOf("\"", line.indexOf("\""))));
                }
                if (line.startsWith("messenger"))
                {
                    if (line.contains("WHATSAPP"))
                    {
                        contact.addMessenger(Messenger.WHATSAPP);
                    }
                    if (line.contains("FACEBOOK_MESSENGER"))
                    {
                        contact.addMessenger(Messenger.FACEBOOK_MESSENGER);
                    }
                    if (line.contains("SMS"))
                    {
                        contact.addMessenger(Messenger.SMS);
                    }
                    if (line.contains("SIGNAL"))
                    {
                        contact.addMessenger(Messenger.SIGNAL);
                    }
                }            
            }
            br.close();
        }
        


        // return sb.toString();
    }

    private static Contact[] addSpaceToArray(Contact[] input) // method to increase the length of an array w/out losing content
    {
        if (input == null){
            input = new Contact[0];
        }
        int oldLength = input.length;
        int newLength = oldLength + 1;

        Contact[] longerArray = new Contact[newLength];
        System.arraycopy(input, 0, longerArray, 0, oldLength);
        return longerArray;
    }
}
