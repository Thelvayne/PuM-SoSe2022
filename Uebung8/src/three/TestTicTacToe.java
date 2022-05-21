package three;

import three.tictactoe.Game;

public class TestTicTacToe {
    
    // Code hier

    public static void main(String[] args){

        Game gamepvp = new Game("ich","du");

        Game gamepve = new Game("ich");

        gamepvp.play();
        gamepve.play();

    }

}