// Nick Cwertetschka 4070430
// Philipp Jäckel 4070258

import java.io.IOException;
import java.util.Random;

public class Palindrome
{
    // variables
    private String[] input, palindromes;

    // constructor
    public Palindrome(String[] input)
    {
        this.input = input;
        this.palindromes = null;
    }

    public Palindrome()
    {
        this.palindromes = null;
    }

    public String[] getInput() 
    {
        return input;
    }

    public String[] getPalindromes() 
    {
        return palindromes;
    }

    /**
     * This method takes a String input and verifies if the input is a palindrome or not. And returns it as boolean value.
     * @param input of the type String
     * @return
     *
     * The result is "true" if the input is a palindrome and "false" if not.
     */
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

    /**
     * This method goes through an array and searches for palindromes. If palindromes are found, then they will be added to the array where the palindromes
     * are saved. All words that are not palindromes are ignored.
     * @param input
     */
    private void findPalindromes(String[] input)
    {
        if (input == null)
        {
            return;
        }
        int i = 0;
        while (i < input.length)
        {
            if (isPalindrome(input[i]) == true)
            {
                addPalindromeToArray(input[i]);
            }            
            i++;
        }
        if (palindromes == null)
        {
            palindromes = new String[0];
        }
    }

    /**
     * IF given array is NOT initialized, then it will do so.
     * Otherwise it will take the array, enlarge it by 1 in length and then copy the content into the newer longer array.
     * @param input
     * @return
     */
    public static String[] addSpaceToArray(String[] input)
    { 
        if (input == null){
            input = new String[1];
            return input;
        }
        int oldLength = input.length;
        int newLength = oldLength + 1;

        String[] longerArray = new String[newLength];
        System.arraycopy(input, 0, longerArray, 0, oldLength);
        return longerArray;        
    }

    /**
     * Adds a String into a String array.
     * @param input
     */
    private void addPalindromeToArray(String input)
    {
        this.palindromes = addSpaceToArray(this.palindromes);
        this.palindromes[this.palindromes.length - 1] = input;
    }

    /**
     * Creates a new palindrome of a certain length that the user chose.
     * @param length
     */
    public void addNewPalindrome(int length)
    {
        // checking for requirement
        if (length <= 0)
        {
            System.out.println("Die Länge des Palindroms muss > 0 sein!");
            return;
        }
        // method
        String firstHalf = "";
        String secondHalf = "";

        for (int i = 0; i <= length/2; i++)
        {
            String tempChar = createRandomChar();
            firstHalf = firstHalf + tempChar;
        }

        for (int i = firstHalf.length()-1; i >= 0; i--)
        {
            String reverseChar = String.valueOf(firstHalf.charAt(i));
            secondHalf = secondHalf + reverseChar;
        }

        if (length%2 == 0)
        {
            String newPalindrome = firstHalf + secondHalf;
            addPalindromeToArray(newPalindrome);
            return;
        }
        else 
        {
            String middle = createRandomChar();
            String newPalindrome = firstHalf + middle + secondHalf;
            addPalindromeToArray(newPalindrome);
            return;
        }
    }

    /**
     * Creates random chars that are converted to String and returned.
     * @return
     */
    private String createRandomChar()
    {
        // define allowed alphabet for creation
        String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String allSymbols = upperCaseAlphabet + lowerCaseAlphabet;

        Random ran = new Random();
        int randomIndexAllSymbols = ran.nextInt(allSymbols.length());
        char sym = allSymbols.charAt(randomIndexAllSymbols);
        String str = String.valueOf(sym);
        return str;
    }

    /**
     * Creates a String with all palindromes that are within the array. Which can be printed out.
     * @return
     */
    public String printPalindromes()
    {
        String output = "";
        findPalindromes(input);
        if (palindromes == null)
        {
            output = "Es wurden keine Palindrome gefunden.";
            return output;
        }
        else
        {

            for (int i = 0; i <= palindromes.length - 1; i++)
            {
                output = output + ", " + palindromes[i] ;
            }
            output = output.substring(2);
            return output;
        }
    }
}