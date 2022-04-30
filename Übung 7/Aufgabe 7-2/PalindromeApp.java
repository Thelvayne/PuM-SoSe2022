// Nick Cwertetschka 4070430
// Philipp Jäckel 4070258

import java.util.Scanner;

public class PalindromeApp 
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Geben Sie Ihre Auswahl an Wörtern an: ");
        String input = scan.nextLine();
        if (checkInput(input) == false)
        {
            System.out.println("Bitte geben Sie die Eingabe in folgendem Format an: \"Wort, Wort\" ");
        }
        
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

}