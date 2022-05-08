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
            sb.append(contacts[i].getFirstName() + ";");
            sb.append(contacts[i].getLastName() + ";");
            sb.append(contacts[i].getPhone() + ";");
            for (int j = 0; j < contacts[i].getMessenger().length; j++)
            {
                if (j <= contacts[i].getMessenger().length - 2)
                {
                    sb.append(contacts[i].getMessenger()[j].toString() + ",");
                }
                else
                {
                    if (i + 1 != contacts.length)
                    {
                        sb.append(contacts[i].getMessenger()[j].toString() + "\n");
                    }
                    else
                    {
                        sb.append(contacts[i].getMessenger()[j].toString());
                    }
                }
            }
        }
        fw.write(sb.toString());
        fw.close();
    }
}
