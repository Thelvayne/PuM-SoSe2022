// Nick Cwertetschka 4070430
// Philipp Jäckel 4070258

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

    // getter to read the values of the variables as mentioned in the task
    public String[] getInput() 
    {
        return input;
    }

    public String[] getPalindromes() 
    {
        return palindromes;
    }

    // methods
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
    }

    public static String[] addSpaceToArray(String[] input) // method to increase the length of an array w/out losing content
    { 
        if (input == null){
            input = new String[0];
        }
        int oldLength = input.length;
        int newLength = oldLength + 1;

        String[] longerArray = new String[newLength];
        System.arraycopy(input, 0, longerArray, 0, oldLength);
        return longerArray;        

    }

    private void addPalindromeToArray(String input) // add a new palindrome to the array
    {
        this.palindromes = addSpaceToArray(this.palindromes);
        this.palindromes[this.palindromes.length - 1] = input;
    }

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