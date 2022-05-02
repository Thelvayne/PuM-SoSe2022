import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    @Test
    void creatingRightConstructor()
    {
        String input = "";
        Palindrome palIs = new Palindrome(PalindromeApp.inputToStringArray(input));
        Palindrome palExp = new Palindrome();
        palIs.printPalindromes();
    }
}
