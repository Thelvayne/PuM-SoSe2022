package three.tictactoe.player;

import java.util.Arrays;
import java.util.Scanner;

public class Player {

    /** Attribute
     *
     * name: Spielername (getter) --> String
     * mark: Spielerfigur (getter) -> char --> O oder X
     *
     * */

    final String[] possibleChoices = {"a1","a2","a3","b1","b2","b3","c1","c2","c3"};

    private String name;

    public String getName() {
        return name;
    }

    private char mark;

    public char getMark() {
        return mark;
    }

    //////////////////////////////////////////////////////////////////////

    /** Construktor:
     *
     * Attribute name(String) , mark(char) -> O oder X
     *
     * */

    public Player(String n, char m){
        name = n;
        mark = m;
    }

    //////////////////////////////////////////////////////////////////////

    /** getFieldInput
     *
     * erhält eine Koordinaten-Eingabe {A1,A2,A3},{B1,B2,B3},{C1,C2,C3}
     *
     * */

    //TODO hier
    public String getFieldInput()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Spieler ["+getName()+"]"+": Geben Sie eine Zielkoordinate ein! Mögliche Eingaben: "
                + Arrays.toString(possibleChoices));

        String input = sc.nextLine();

        // gibt die input-koordinaten weiter und fügt die playerMark hinten an
        return input+getMark();
    }

    //////////////////////////////////////////////////////////////////////

    @Override
    public String toString(){
        String s = "Player: "+name+ "("+mark+")";

                return s;
    }



}