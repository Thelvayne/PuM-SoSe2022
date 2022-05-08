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

    public void readFromFile (String filename) throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                Contact contact;
                if (line.startsWith("["))
                {
                    contact = new Contact();
                    contacts = addSpaceToArray(contacts);
                    contacts[contacts.length-1] = contact;
                }
                if (line.contains("first_name"))
                {
                    contacts[contacts.length - 1].setFirstName(line.substring(line.indexOf("\"") + 1, line.length() - 1));
                }
                if (line.contains("last_name"))
                {
                    contacts[contacts.length - 1].setLastName(line.substring(line.indexOf("\"") + 1, line.length() - 1));
                }
                if (line.contains("phone"))
                {
                    contacts[contacts.length - 1].setPhone(line.substring(line.indexOf("\"") + 1, line.length() - 1));
                }
                if (line.startsWith("messenger"))
                {
                    if (line.toUpperCase().contains("WHATSAPP"))
                    {
                        contacts[contacts.length - 1].addMessenger(Messenger.WHATSAPP);
                    }
                    if (line.toUpperCase().contains("FACEBOOK MESSENGER"))
                    {
                        contacts[contacts.length - 1].addMessenger(Messenger.FACEBOOK_MESSENGER);
                    }
                    if (line.toUpperCase().contains("SMS"))
                    {
                        contacts[contacts.length - 1].addMessenger(Messenger.SMS);
                    }
                    if (line.toUpperCase().contains("SIGNAL"))
                    {
                        contacts[contacts.length - 1].addMessenger(Messenger.SIGNAL);
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
            input = new Contact[1];
            return input;
        }
        int oldLength = input.length;
        int newLength = oldLength + 1;

        Contact[] longerArray = new Contact[newLength];
        System.arraycopy(input, 0, longerArray, 0, oldLength);
        return longerArray;
    }
}
