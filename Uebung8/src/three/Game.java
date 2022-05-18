package three;

import java.util.Scanner;

public class Game {

    private Board board;
    private Player playerOne, playerTwo;

    private Player[] players = {playerOne, playerTwo};

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

        int round = 1;
        String coordinate = "";

        while (round < 10) {

            //ermittelt eingabekoordinaten der jeweilgen Spieler
            if (round % 2 == 1) {
                board.setMark(playerOne.getFieldInput(), playerOne.getMark());
            } else board.setMark(playerTwo.getFieldInput(), playerTwo.getMark());

            // ab dem 5. platzierten Mark kann der erste Sieger gefunden werden,
            // da min. 1 Spieler 3 Marks platzieren konnte.
            if (round > 5) {
                for (Player player : players) {
                    if (checkWin(board.convertInput(player.getFieldInput()), player.getMark())){
                        board.isWinner(player.getMark());
                        return;
                    }
                }
            }

            round++;
        }
        board.isComplete();

    }

    /**
     * convertInput
     * <p>
     * wandelt den input aus getFieldInput Koordinaten als int[2] um
     */




    /**
     * checkWin
     * <p>
     * startet den Rekursiven Algorithmus, der in alle richtungen die PlayerMarks vergleicht
     */

    private boolean checkWin(int[] p, char m) {

        int x = p[0];
        int y = p[1];

        if (m == checkWinR(x, y, m)) return true;
        else
            return false;
    }

    /**
     * checkWinR
     */


    // startet Rekursive Prüfmethode, die in alle richtungen die String vergleicht
    private char checkWinR(int x, int y, char m) {
        if (x >= 0 && x <= 2) {
            if (y >= 0 && y <= 2) {
                //Diagonal
                if (checkWinR(y - 1, x - 1, m) == checkWinR(x, y, m)) return m;
                else if (checkWinR(y + 1, x - 1, m) == checkWinR(x, y, m)) return m;
                else if (checkWinR(y - 1, x + 1, m) == checkWinR(x, y, m)) return m;
                else if (checkWinR(y + 1, x + 1, m) == checkWinR(x, y, m)) return m;
                //Horizontal
                if (checkWinR(x - 1, y, m) == checkWinR(x, y, m)) return m;
                else if (checkWinR(x + 1, y, m) == checkWinR(x, y, m)) return m;
                //Vertical
                if (checkWinR(x, y - 1, m) == checkWinR(x, y, m)) return m;
                else if (checkWinR(x, y + 1, m) == checkWinR(x, y, m)) return m;
            }
        }
        return '-';

    }


}
