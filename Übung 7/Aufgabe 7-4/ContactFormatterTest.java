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

        // String currentPath = new java.io.File(".").getCanonicalPath();
        // System.out.println("Current dir:" + currentPath);
        // System.err.println(currentPath);

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

    // @Test
    // void test
}
