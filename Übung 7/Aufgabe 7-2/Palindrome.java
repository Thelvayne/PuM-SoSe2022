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
    }

    public Palindrome()
    {

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
        input.toLowerCase();
        int charFromBack = input.length() - 1;
        int charFromFront = 0;

        while (charFromFront > charFromBack)
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

    private void addSpaceToArray(String[] input) // method to increase the length of an array w/out losing content
    { 
        if (input == null){
            input = new String[0];
        }
        int oldLength = input.length;
        int newLength = oldLength + 1;

        String[] longerArray = new String[newLength];
        System.arraycopy(input, 0, longerArray, 0, oldLength);

    }

    private void addPalindromeToArray(String input) // add a new palindrome to the array
    {
        addSpaceToArray(this.palindromes);
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
        // String numbers = "0123456789";
        // String specialSymbols = "ÄäÖöÜüß";
        String allSymbols = upperCaseAlphabet + lowerCaseAlphabet /*+ numbers + specialSymbols*/;

        Random ran = new Random();
        int randomIndexAllSymbols = ran.nextInt(allSymbols.length());
        char sym = allSymbols.charAt(randomIndexAllSymbols);
        String str = String.valueOf(sym);
        return str;
    }
}