package three;

import javax.xml.stream.events.Characters;
import java.util.Arrays;

public class Board {

    private char[][] fields;

    public char[][] getFields() {
        return fields;
    }

    public Board() {

        fields = new char[3][3];

    }

    //liest den eintrag an der stelle des eingegebenen strings auf (z.B. a1 --> return fields[0][1])
    public char read(String f)
    {
        int[] x = convertInput(f);

        return fields[x[0]][x[1]];
    }

    // gibt true nach dem erfolgreichen platzieren eines marks (O|X) zurück
    boolean setMark(String f, char m) {

        int[] x = convertInput(f);

        if (!Character.isSpaceChar(read(f)))
        {
            if(Character.valueOf(read(f))!='o' && Character.valueOf(read(f))!='x'){
            fields[x[0]][x[1]] = m;

            for(int i = 0;i<fields.length;i++){
                System.out.println(Arrays.toString(fields[i]));
            }

            return true;
        }
        }
            System.out.println("Platz schon besetzt");
            return false;
    }

    //gibt true zurück, wenn alle felder besetzt sind (nach 9 zügen)
    boolean isComplete()
    {
        for(int i =0;i<fields.length;i++){
            for(int j =0;j<fields.length;j++){
                if(!Character.isSpaceChar(fields[i][j])) return true;
            }
        }
        return false;
    }

    //gibt true zurück wenn die mark eine 3er kette ausgelöst hat

    boolean isWinner(char mark)
    {
        char[][] w = constructLanes();

        if (checkWin(w,mark)) {
            System.out.println("Spieler ["+mark+"] gewinnt!");
            return true;
        }
        else return false;
    }

    ///////////////////////////////////////////////////////////////////////

    // CONVERT INPUT

    /**
     * convertInput
     * <p>
     * wandelt den input aus getFieldInput Koordinaten als int[2] um
     */

    int[] convertInput(String input) {

        int x = 0, y = 0;

        if (input.charAt(0) == 'a') {
            x = 0;
        } else if (input.charAt(0) == 'b') {
            x = 1;
        } else if (input.charAt(0) == 'c') {
            x = 2;
        }

        if (input.charAt(1) == '1') {
            y = 0;
        } else if (input.charAt(1) == '2') {
            y = 1;
        } else if (input.charAt(1) == '3') {
            y = 2;
        }

        return new int[]{x, y};
    }

    /**
     * checkWin
     * <p>
     * startet den Rekursiven Algorithmus, der in alle richtungen die PlayerMarks vergleicht
     *
     * Player p: der zu prüfende Spieler
     * String c: Die Startkoordinaten, ab der die Win Condition rekursiv geprüft wird
     *
     */

    boolean checkWin(Player p, String f) {

        char m = p.getMark();
        int[] xy = convertInput(f); //begrenzt x und y auf 0 <= x|y <=2
        int x = xy[0], y = xy[1];

        return isWinner(m);
      //  else if (m == checkWinH(x,y,m)) return true;
      //  else if (m=checkWinD(x,y,m))return true;
    }

    private boolean checkWin(char[][] w, char m)
    {
        int correctCount =0;

        for(int i=0;i<w.length;i++){
            for(int j=0;j<w[i].length;j++)
            {
                System.out.println(w[i][j]+" = "+m+"?");
                if(w[i][j]==m)correctCount++;
            }
            if(correctCount==3){return true;} else
                correctCount =0;
            System.out.println("---------------------");
        }
        return false;
    }

    private char[][] constructLanes()
    {
        char[][] w = new char[8][3];

        // horizontale lanes des tictactoe feldes
        for(int i =0;i<fields.length;i++){
            w[0][i]=fields[0][i];
        }
        for(int i =0;i<fields.length;i++){
            w[1][i]=fields[1][i];
        }
        for(int i =0;i<fields.length;i++){
            w[2][i]=fields[2][i];
        }

        // vertikale lanes des tictactoe feldes
        for(int i =0;i<fields.length;i++){
            w[3][i]=fields[i][0];
        }
        for(int i =0;i<fields.length;i++){
            w[4][i]=fields[i][1];
        }
        for(int i =0;i<fields.length;i++) {
            w[5][i] = fields[i][2];
        }

        //diagonale lanes des tictactoe feldes
        for(int i =0;i<fields.length;i++) {
            w[6][i] = fields[i][i];
        }
        w[7][0] = fields[2][0];
        w[7][1] = fields[1][1];
        w[7][2] = fields[0][2];

        return w;
    }

}
