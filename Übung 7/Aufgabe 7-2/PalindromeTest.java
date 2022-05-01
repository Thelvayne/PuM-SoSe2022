import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    @Test
    void testToString()
    {
        String expected = "Anna, AbbA";
        String[] input = {"Anna", "Kekse", "Helmut", "AbbA"};
        Palindrome p = new Palindrome(input);
        
        
    }
}
