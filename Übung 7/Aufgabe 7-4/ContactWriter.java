import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContactWriter {
    public void writeToFile(Contact[] contacts, String filename) throws IOException
    {
        ContactReader cr = new ContactReader();
        FileWriter fw = new FileWriter(filename);
        StringBuilder sb = new StringBuilder();
        String headStr = "First Name; Last Name; Phone; Messenger \n";
        sb.append(headStr);
        for (int i = 0; i < cr.getContacts().length; i++)
        {
            sb.append("\"" + cr.getContacts()[i].getFirstName() + "\";");
            sb.append("\"" + cr.getContacts()[i].getLastName() + "\";");
            sb.append("\"" + cr.getContacts()[i].getPhone() + "\";");
            for (int j = 0; j < cr.getContacts()[i].getMessenger().length; j++)
            {
                if (j <= cr.getContacts()[i].getMessenger().length - 2)
                {
                    sb.append("\"" + cr.getContacts()[i].getMessenger()[j].toString() + "\",");
                }
                else
                {
                    sb.append("\"" + cr.getContacts()[i].getMessenger()[j].toString() + "\"" + "\n");
                }
            }


        }
        fw.write(sb.toString());
        fw.close();
    }
}
