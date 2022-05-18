package three;

import javax.xml.stream.events.Characters;
import java.util.Arrays;

public class Board {

    private char[][] fields;

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
        boolean actuallyComplete;

        for(int i =0;i<fields.length;i++){
            for(int j =0;j<fields.length;j++){
                if(Character.isWhitespace(fields[i][j])) return true;
            }
        }

        return false;
    }

    //gibt true zurück wenn die mark eine 3er kette ausgelöst hat
    boolean isWinner(char mark) {
        return false;
    }

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
}
