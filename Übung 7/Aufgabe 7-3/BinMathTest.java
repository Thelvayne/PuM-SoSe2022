import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;


public class BinMathTest {
    @Test
    void decToBinSmallNegetiveNumber()
    {
        int decValue = -3;
        int size = 3;
        int[] expected = {1, 0, 1};        
        assertArrayEquals(expected, BinMath.decToBin(decValue, size));
    }

    @Test
    void decToBinBigNegetiveNumber()
    {
        int decValue = -826;
        int size = 10;
        int[] expected = {1,0,0,1,1,0,0,0,1,1,0};       
        assertArrayEquals(expected, BinMath.decToBin(decValue, size));
    }
}
