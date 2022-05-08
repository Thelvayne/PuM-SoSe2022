import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BinMathTest {

//decToBinTests
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

    @Test
    void decToBinSmallPositiveNumber()
    {
        int decValue = 14;
        int size = 5;
        int[] expected = {0,1,1,1,0};
        assertArrayEquals(expected, BinMath.decToBin(decValue, size));
    }

    @Test
    void decToBinBigPositiveNumber()
    {
        int decValue = 1465;
        int size = 11;
        int[] expected = {0,1,0,1,1,0,1,1,1,0,0,1};
        assertArrayEquals(expected, BinMath.decToBin(decValue, size));
    }

    @Test
    void decToBinNull()
    {
        int decValue = 0;
        int size = 4;
        int[] expected = {0,0,0,0};
        assertArrayEquals(expected, BinMath.decToBin(decValue, size));
    }

    @Test
    void decToBinMinusOne()
    {
        int decValue = -1;
        int size = 4;
        int[] expected =  {1,1,1,1};
        assertArrayEquals(expected, BinMath.decToBin(decValue, size));
    }

// binToDecTests

    @Test
    void binToDecSmallNegetiveNumber()
    {
        int[] binValue = {1,1,0,1};
        assertEquals(-3, BinMath.binToDec(binValue));
    }

    @Test
    void binToDecBigNegetiveNumber()
    {
        int[] binValue = {1,0,0,0,1,1,0,1};
        assertEquals(-115, BinMath.binToDec(binValue));
    }

    @Test
    void binToDecSmallPositiveNumber()
    {
        int[] binValue = {0,1,0,1};
        assertEquals(5, BinMath.binToDec(binValue));
    }

    @Test
    void binToDecBigPositiveNumber()
    {
        int[] binValue = {0,1,1,1,1,0,1,1,0,1};
        assertEquals(493, BinMath.binToDec(binValue));
    }

    @Test
    void binToDecNull()
    {
        int[] binValue = {0,0,0,0};
        assertEquals(0, BinMath.binToDec(binValue));
    }

    @Test
    void binToDecMinusOne()
    {
        int[] binValue = {1,1,1,1};
        assertEquals(-1, BinMath.binToDec(binValue));
    }

// addBinaryNumbersTest

    @Test
    void addBinaryNumbersSmallNegativeSmallPositiveToSmallNegative()
    {
        int[] operand1 = {1,1,0,1};
        int[] operand2 = {0,0,1,0};
        int[] expected = {1,1,1,1};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));
    }

    @Test
    void addBinaryNumbersSmallNegativeSmallPositiveToSmallPositive()
    {
        int[] operand1 = {1,1,0,1};
        int[] operand2 = {0,1,1,0};
        int[] expected = {1,0,0,1,1};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));
    }

    @Test
    void addBinaryNumbersSmallNegativeBigPositiveToBigPositive()
    {
        int[] operand1 = {1,1,0,1};
        int[] operand2 = {0,1,0,1,1,0,1,0,1,1,0};
        int[] expected = {0,1,0,1,1,1,0,0,0,1,1};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));
    }

    @Test
    void addBinaryNumbersBigNegativeSmallNegativeToBigNegative()
    {
        int[] operand1 = {1,1,0,1,1,0,1,0,1,1,0};
        int[] operand2 = {1,1,0,1};
        int[] expected = {1,1,1,0,1,1,0,1,0,0,1,1};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));
    }

    @Test
    void addBinaryNumbersBigNegativeBigNegativeToBigNegative()
    {
        int[] operand1 = {1,1,0,1,1,0,1,0,1,1,0};
        int[] operand2 = {1,0,1,1,0,0,0,1,1,0,1};
        int[] expected = {1,1,0,0,0,1,1,0,0,0,1,1};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));
    }

    @Test
    void addBinaryNumbersBigPositiveBigPositiveToBigPositive()
    {
        int[] operand1 = {0,1,0,1,1,0,1,0,1,1,0};
        int[] operand2 = {0,1,1,1,0,0,0,1,1,0,1};
        int[] expected = {0,1,1,0,0,1,1,0,0,0,1,1};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));
    }

    @Test
    void fromVPLRandom1()
    {
        int[] operand1 = {1,1,0,1,1,1,0,1,0};
        int[] operand2 = {1,1,1,0,0};
        int[] expected = {1,1,1,0,1,1,0,1,1,0};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));
    }

    @Test
    void fromVPLRandom2()
    {
        int[] operand1 = {1,0,0,1,0,1,0,0,0};
        int[] operand2 = {1,0,1,0,1};
        int[] expected = {1,1,0,0,0,1,1,1,0,1};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));  
    }

    @Test
    void fromVPLRandom3() //laut VPL soll es eine Länge von 10 erreichen, was aber keinen Sinn macht
    {
        int[] operand1 = {0,0,1,1,0,0,1,0,0};
        int[] operand2 = {0,1,1,1,1};
        int[] expected = {0,0,1,1,1,0,0,1,1};
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2));    
    }

    @Test
    void fromVPLRandom4() //laut VPL soll es eine Länge von 10 erreichen, was aber keinen Sinn macht
    {
        int[] operand1 = {1,0,1,1,0,1,0,0,0}; 
        int[] operand2 = {0,1,1,0,1}; 
        int[] expected = {1,0,1,1,1,0,1,0,1}; 
        assertArrayEquals(expected, BinMath.addBinaryNumbers(operand1, operand2)); 
    }
}
