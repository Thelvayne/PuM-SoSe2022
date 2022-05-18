package three;

import java.util.Scanner;

public class Game {

    private Board board;
    private Player playerOne, playerTwo;

    // Konstruktoren


    // 2 Spieler Konstruktor
    public Game(String p1, String p2) {

        playerOne = new Player(p1, 'o');
        playerTwo = new Player(p2, 'x');

        board = new Board();
    }

    // Singleplayer Konstruktor
    public Game(String p1) {

        playerOne = new Player(p1, 'o');
        playerTwo = new Computer("Computer", 'x');

        board = new Board();
    }

    public Game() {

        board = new Board();
    }

    //Spielablauflogik
    public void play() {

        Player[] players = {playerOne, playerTwo};

        int round = 1;
        String coordinate = "";

        while (round < 10) {
            System.out.println("Round: "+round);

            //ermittelt eingabekoordinaten der jeweilgen Spieler
            if (round % 2 == 1)
            {
                coordinate = playerOne.getFieldInput();
                board.setMark(coordinate, playerOne.getMark());
            } else {
                coordinate = playerTwo.getFieldInput();
                board.setMark(coordinate, playerTwo.getMark());
            }
            // ab dem 5. platzierten Mark kann der erste Sieger gefunden werden,
            // da min. 1 Spieler 3 Marks platzieren konnte.
            if (round > 5) {
                for (Player p : players) {
                    if (board.checkWin(p,coordinate)) {
                        return;
                    }
                }
            }

            round++;
        }
        board.isComplete();

    }

}
