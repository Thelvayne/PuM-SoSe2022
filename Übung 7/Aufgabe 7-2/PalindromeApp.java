// Nick Cwertetschka 4070430
// Philipp Jäckel 4070258

import java.util.Scanner;

public class PalindromeApp 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        Palindrome pal;
        String j = "J";
        String n = "N";

        System.out.println("Geben Sie Ihre Auswahl an Wörtern an: ");
        String input = scan.nextLine();
        while (checkInput(input) == false)
            {
                System.out.println("Bitte geben Sie die Eingabe in folgendem Format an: \"Wort, Wort\" ");
                input = scan.nextLine();
            }
            if (input.equals("") == false)
            {
                pal = new Palindrome(inputToStringArray(input));
            }
            else {
                pal = new Palindrome();
            }
        
        while (true)
        {
            System.out.println("Möchten Sie sich ein Palindrome generieren lassen? (J/N)");
            input = scan.next();
            while (j.equals(input) == false && n.equals(input) == false)
            {
                System.out.println("Falsche Eingabe. Bitte antworten Sie mit \"J\" für ja und \"N\" für nein");
                input = scan.nextLine();
            }
            if (n.equals(input))
            {
                break;
            }
            if (j.equals(input))
            {
                System.out.println("Wie lang soll Ihr Palindrome werden?");
                int length = scan.nextInt();
                pal.addNewPalindrome(length);
            }
        }

        System.out.println(pal.printPalindromes());
        scan.close();
        
    }
    
    private static boolean checkInput(String input){
        if ((input.matches("\\A\\b\\w*\\b(, \\b\\w*\\b)*\\z"))){
            return true;
        }
        else if(input.matches(""))
        {
            return true;
        }
        else 
        {
            return false;
        }    
    }

    static String[] inputToStringArray(String input)
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