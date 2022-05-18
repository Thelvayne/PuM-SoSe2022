package two;

import java.util.Arrays;

public class FindTheWay
{
    Field[][]getWay()
    {
        Field[][] path = new Field[field.length][field.length];

        int row= 0,column= 0;
        boolean columnFinished =false;

        while(row< field.length-1) {

            columnFinished = false;

            while (column < field.length - 1 && columnFinished == false) {

                // falls es keine wand in der aktuellen spalte in der nächsten zeile ist -> nach unten gehen
                if (field[row + 1][column] == Field.FREE && (row + 1) < field.length - 1) {
                    field[row][column] = Field.PATH;
                    row++;

                // wenn eine wand ist: statt nach unten gehen -> zur seite gehen bis wieder nach unten gegangen werden kann
                } else if (column != getPathIndex(field[row+1])&&!(row==field.length-2)) {
                    field[row][column] = Field.PATH;

                    //welche seite: links oder rechts?
                    if (column < getPathIndex(field[row+1])) {
                        column++;
                    } else column--;
                    if (column == getPathIndex(field[row])) columnFinished = true;
                }

                // wenn der path in der vorletzten teile ist fallen die vorherigen bedingungen weg
                // gehe direkt nach unten, da dort alle felder FREE sind
                if(row==field.length-2){
                    field[row][column]=Field.PATH;
                    row++;

                    field[row][column]=Field.PATH;

                    // gehe dann zum Ende des Arrays (letzte zeile, letzte spalte)
                    while(column < field.length-1) {
                        column++;
                        field[row][column]=Field.PATH;
                    }
                }
            //    path[row][column]=Field.PATH; //Endpunkt als path markieren

            }
        }

        for(int i =0;i< field.length;i++){
            System.out.println(Arrays.toString(field[i]));
        }

        return field;
    }

    private int getPathIndex(Field[] f)
    {
        for(int i=0;i<f.length;i++){
            if(f[i]==Field.FREE)return i;
        }
        return 0;
    }

    private Field[][]field, path;

    public FindTheWay(Field[][] f){
        field = f;
        getWay();
    }

}
