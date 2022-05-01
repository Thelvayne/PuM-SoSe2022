// Nick Cwertetschka 4070430
// Philipp Jäckel 4070258

import java.util.Scanner;

public class PalindromeApp 
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Geben Sie Ihre Auswahl an Wörtern an: ");
        String input = scan.nextLine();
        while (checkInput(input) == false)
        {
            System.out.println("Bitte geben Sie die Eingabe in folgendem Format an: \"Wort, Wort\" ");
            input = scan.nextLine();
        }
        
        Palindrome pal = new Palindrome(inputToStringArray(input));

        

        pal.printPalindromes();

        
    }
    
    static boolean checkInput(String input){
        String str = input;
        if ((str.matches("\\A\\b\\w*\\b(, \\b\\w*\\b)+\\z"))){
            return true;
        }
        else if(str.matches("\\A\\b\\w*\\b\\z"))
        {
            return true;
        }
        else 
        {
            return false;
        }    
    }

    private static String[] inputToStringArray(String input)
    {
        String[] inputArray = new String[0];
        int i = 0;
        
        while (input.contains(","))
        {
            int index = input.indexOf(",");
            String input1 = input.substring(0, index);
            input = input.substring(index + 2);
            inputArray = Palindrome.addSpaceToArray(inputArray);
            inputArray[i] = input1;
            i++;
        }
        inputArray = Palindrome.addSpaceToArray(inputArray);
        inputArray[i] = input;
        return inputArray;
    }
}