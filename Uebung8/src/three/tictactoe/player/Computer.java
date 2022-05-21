package three.tictactoe.player;

public class Computer extends Player {
    public Computer(String n, char m)
    {

        super(n, m);
    }


    @Override
    public String getFieldInput(){

        System.out.println("Computer ["+getName()+"]"+": Gibt eine Zielkoordinate ein!");

        String input = possibleChoices[(int)(Math.random()*possibleChoices.length)];

        System.out.println("Computer wählt: "+input);

        // gibt die input-koordinaten weiter und fügt die computerMark hinten an

        return input+getMark();

    }
    
}
