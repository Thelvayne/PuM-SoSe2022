package two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest
{
    @Test
    static void testZeroSize(){

        assertEquals(new IndexOutOfBoundsException(),new Playground(0));
        assertEquals(new IndexOutOfBoundsException(),new Playground(-1));
    }

    static void testVeryLargeSize(){

    }

    public static void main(String[] args){

        Playground p = new Playground(10);

        /*
        Playground pp = new Playground(20);
        Playground ppp = new Playground(5);
        Playground pppp = new Playground(4);
        Playground ppppp = new Playground(3);
        Playground pppppp = new Playground(2);
          */

        //testZeroSize();
        System.out.println("-------------------------------------------");
        FindTheWay f = new FindTheWay(p.getPlayground());
    }
    
}