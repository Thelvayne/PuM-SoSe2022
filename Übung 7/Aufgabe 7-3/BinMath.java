public class BinMath 
{
    /**
     * This method is used to convert decimal numbers to binary numbers of chosen bit length.
     * @param decValue is the decimal number
     * @param size is the bit length
     *  
     */
    static int[] decToBin(int decValue, int size)
    {
        int[] binNumber;
        if (decValue < 0)
        {
            binNumber = checkArrayLength(decValue, size);
            binNumber[0] = 1;
            int rest = (int)Math.pow(2, binNumber.length - 1) - Math.abs(decValue);
            for (int i = 1; i < binNumber.length; i++)
            {
                if (rest >= (int)Math.pow(2, binNumber.length - 1 - i))
                {
                    rest = Math.abs(rest) - (int)Math.pow(2, binNumber.length - 1 - i);
                    binNumber[i] = 1;
                }
                else
                {
                    binNumber[i] = 0;
                }
            }
            return binNumber;
        }
        else
        {
            int rest = Math.abs(decValue);
            binNumber = checkArrayLength(decValue, size);
            for (int i = 1; i < binNumber.length; i++)
            {
                if (rest >= (int)Math.pow(2, binNumber.length - 1 - i))
                {
                    rest = (int)Math.pow(2, binNumber.length - 1 - i) - Math.abs(rest);
                    binNumber[i] = 1;
                }
                else
                {
                    binNumber[i] = 0;
                }
            }
            if (binNumber[0] == 1)
            {
                addSpaceToArray(binNumber);
                binNumber[0] = 0;
            }
            return binNumber;
        }
    }   

    /**
     * This method will take a binary number in an array where the array length is the bit length of the binary
     * number and converts it to a decimal number
     * @param binValue is an array filled with binary numbers
     * @return returns the converted decimal number
     */
    static int binToDec(int[] binValue)
    {
        int decNumber;
        if (binValue[0] == 0)
        {
            decNumber = 0;
            for (int i = 0; i < binValue.length; i++)
            {
                decNumber = decNumber + (int)Math.pow(2, binValue.length - i) * binValue[i];
            }
            return decNumber;
        }
        else
        {
            decNumber = -((int)Math.pow(2, binValue.length - 1));
            for (int i = 1; i < binValue.length; i++)
            {
                decNumber = decNumber + (int)Math.pow(2, binValue.length - i) * binValue[i];
            }
            return decNumber;
        }
    }

    /**
     * 
     * @param operand1 first binary number
     * @param operand2 second binary number
     * @return new binary number
     */
    static int[] addBinaryNumbers(int[] operand1, int[] operand2)
    {
        int[] sumBinNum;
        int transfer = 0;
        if (operand1.length >= operand2.length)
        {
            sumBinNum = new int[operand1.length];
        }
        else
        {
            sumBinNum = new int[operand2.length];
        }
        for (int i = sumBinNum.length - 1; i > 0; i--)
        {
            if (operand1[i] + operand2[i] + transfer == 0 || operand1[i] + operand2[i] + transfer == 1)
            {
                sumBinNum[i] = operand1[i] + operand2[i] + transfer;
            }
            else if (operand1[i] + operand2[i] + transfer == 2)
            {
                sumBinNum[i] = 0;
                transfer = 1;
            }
            else if (operand1[i] + operand2[i] + transfer == 3)
            {
                sumBinNum[i] = 1;
                transfer = 1;
            }
            else 
            {
                transfer = 0;
            }

            if (operand1[0] == 0 && operand2[0] == 0 && transfer == 0)
            {
                sumBinNum[0]= 0;
                return sumBinNum;
            }
            else if (operand1[0] == 0 && operand2[0] == 0 && transfer == 1)
            {
                sumBinNum[0] = 1;
                addSpaceToArray(sumBinNum);
                sumBinNum[0] = 0;
                return sumBinNum;
            }
            else if ((operand1[0] == 0 ^ operand2[0] == 0) && transfer == 1)
            {
                sumBinNum[0] = 0;
                return sumBinNum;
            }
            else if ((operand1[0] == 0 ^ operand2[0] == 0) && transfer == 0)
            {
                sumBinNum[0] = 1;
            }
            else if (operand1[0] == 1 && operand2[0] == 1 && transfer == 0)
            {
                sumBinNum[0] = 0;
                addSpaceToArray(sumBinNum);
                sumBinNum[0] = 1;
                return sumBinNum;
            }
            else if (operand1[0] == 1 && operand2[0] == 1 && transfer == 1)
            {
                sumBinNum[0] = 1;
                addSpaceToArray(sumBinNum);
                sumBinNum[0] = 1;
                return sumBinNum;
            }
            else
            {
                sumBinNum[0] = 2;
            }
        }
        return sumBinNum;
    }

    static String[] addSpaceToArray(int[] input)
    { 
        if (input == null){
            input = new int[0];
        }
        int oldLength = input.length;
        int newLength = oldLength + 1;

        String[] longerArray = new String[newLength];
        System.arraycopy(input, 0, longerArray, 1, oldLength);
        return longerArray;        
    }

    static int[] checkArrayLength(int decValue, int size)
    {
        int[] binNumber; 
        if ((int)Math.pow(2, size) < Math.abs(decValue)*2)
            {
                int newSize = 128;
                System.out.println("Es ist nicht möglich, die Zahl " + decValue + " in einer binären Zahl der Bitlänge " + size + " darzustellen.");
                for (int i = size + 1; i <=128; i++)
                {
                    if ((int)Math.pow(2, i) > Math.abs(decValue)*2)
                    {
                        newSize = i;
                        break;
                    }
                }
                binNumber = new int[newSize];
                return binNumber;
            }
            else
            {
                binNumber = new int[size];
                return binNumber;
            }
    }
}
