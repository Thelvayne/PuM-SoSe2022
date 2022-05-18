package two;

import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;
import java.util.Random;

public class Playground
{

    Field[][]playfield;

    public Playground(int size)
    {
        if (size>0) playfield = createPlayfield(size);
        else System.err.println("Bitte eine Größe eingeben, die grüßer als 0 ist.");

    }

    Field[][]getPlayground(){
        return playfield;
    }

    private Field[][] createPlayfield(int size)
    {

        playfield = new Field[size][size];
        boolean lastOneHasWalls = false;

        int randomPath = 0;

        for (int row = 0; row < size; row++) {
            if (row == 0 || row == size - 1) {

                for (int column = 0; column < size; column++) {
                    playfield[row][column] = Field.FREE;
                }
            } else {
                int randomWall = (int) (Math.random() * 2);

                if (randomWall == 0) // Random hat entschieden, dass dort keine Wall hin soll
                {
                    lastOneHasWalls = false;

                    for (int column = 0; column < size; column++) {
                        playfield[row][column] = Field.FREE;
                    }

                } else {
                    if (!lastOneHasWalls) {
                        randomPath = (int) (Math.random() * (size-1));
                        System.out.println(randomPath);
                        lastOneHasWalls = true;
                    }
                    System.out.println(randomPath);
                    for (int column = 0; column < size; column++)
                    {
                        if (column != randomPath)
                            playfield[row][column] = Field.WALL;

                        else playfield[row][column] = Field.FREE;
                    }
                }
            }
        }
        for(int i =0;i<size;i++){
            System.out.println(Arrays.toString(playfield[i]));
        }

        return playfield;
    }

}
