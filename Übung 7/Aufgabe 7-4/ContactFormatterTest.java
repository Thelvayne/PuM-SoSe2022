import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class ContactFormatterTest {

    
    
    @Test
    void testLength() throws IOException
    {
        String filenameTOML = "TestDreiKontakte.toml";
        ContactReader reader = new ContactReader();
        reader.readFromFile(filenameTOML);
        assertEquals(3, reader.getContacts().length);
    }

    @Test
    void testUnvalidMessengerInput() throws IOException
    {
        String filenameTOML = "TestUngueltigerMessenger.toml";
        ContactReader reader = new ContactReader();
        reader.readFromFile(filenameTOML);

        assertEquals(3, reader.getContacts()[0].getMessenger().length);
    }

    @Test
    void testEmptyTOML() throws IOException
    {
        String filenameTOML = "TestEmpty.toml";
        ContactReader reader = new ContactReader();
        reader.readFromFile(filenameTOML);

        assertEquals(null, reader.getContacts());
    }

     @Test
     void testEmptyAttributs() throws IOException
     {
     String filenameTOML = "TestEmptyAttributs.toml";
     ContactReader reader = new ContactReader();
        reader.readFromFile(filenameTOML);

        assertEquals("", reader.getContacts()[0].getFirstName());    
     }
     @Test
     void testsixLength() throws IOException
     {
         String filenameTOML = "TestSechsKontakte.toml";
         ContactReader reader = new ContactReader();
         reader.readFromFile(filenameTOML);
         assertEquals(6, reader.getContacts().length);
     }
 
     @Test
     void testEmptyMessenger() throws IOException
     {
     String filenameTOML = "TestEmptyAttributs.toml";
     ContactReader reader = new ContactReader();
        reader.readFromFile(filenameTOML);

        assertEquals(null, reader.getContacts()[0].getMessenger());    
     }
}
