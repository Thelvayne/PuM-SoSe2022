import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    private boolean isPalindrome(String input)
    {
        input = input.toLowerCase();
        int charFromBack = input.length() - 1;
        int charFromFront = 0;

        while (charFromFront < charFromBack)
        {
            if (input.charAt(charFromFront) != input.charAt(charFromBack))
            {
                return false;
            }
            charFromFront++;
            charFromBack--;
        }
        return true;
    }
    @Test
    void creatingCorretConstructorWithoutInput()
    {
        var pal = new Palindrome();
        assertArrayEquals(null, pal.getInput());
    }
    @Test
    void creatingCorretConstructorWithInput()
    {
        String input = "Abba, tests, Sinn, AEgyFDYH";
        var pal = new Palindrome(PalindromeApp.inputToStringArray(input));
        String[] expected = {"Abba", "tests", "Sinn", "AEgyFDYH"};
        assertArrayEquals(expected, pal.getInput());
    }
    @Test
    void creatingCorrectPalindromeEvenNumber()
    {
        var pal = new Palindrome();
        pal.addNewPalindrome(50);
        assertTrue(isPalindrome(pal.getPalindromes()[0]));
        assertEquals(50, pal.getPalindromes()[0].length());
    }
    @Test
    void creatingCorrectPalindromeUnevenNumber()
    {
        var pal = new Palindrome();
        pal.addNewPalindrome(51);
        assertTrue(isPalindrome(pal.getPalindromes()[0]));
        assertEquals(51, pal.getPalindromes()[0].length());
    }
    @Test
    void creatingUnvalidPalindrome()
    {
        var pal = new Palindrome();
        pal.addNewPalindrome(0);
        String[] exp = new String[0];
        assertArrayEquals(exp, pal.getPalindromes());
    }
    @Test
    void outputWithoutGenerating()
    {
        String input = "Abba, tests, Sinn, AEgyFDYH, Palindrome, OttO";
        var pal = new Palindrome(PalindromeApp.inputToStringArray(input));
        String expected = "Abba, OttO";
        assertEquals(expected, pal.printPalindromes());
    }
}
