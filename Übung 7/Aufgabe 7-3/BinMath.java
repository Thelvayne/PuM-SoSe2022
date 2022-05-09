// Nick Cwertetschka 4070430
// Philipp Jäckel 4070258

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
                    rest = rest - (int)Math.pow(2, binNumber.length - 1 - i);
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
        if (binValue[0] == 1)    
        {
            decNumber = (-1) * ((int)Math.pow(2, binValue.length - 1));
            for (int i = 1; i < binValue.length; i++)
            {
                decNumber = decNumber + ((int)Math.pow(2, binValue.length - 1 - i) * binValue[i]);
            }
            return decNumber;
        }
        else
        {
            decNumber = 0;
            for (int i = 0; i < binValue.length; i++)
            {
                decNumber = decNumber + (int)Math.pow(2, binValue.length - 1 - i) * binValue[i];
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
        int filledWithOne = 0;
        if (operand1.length > operand2.length)
        {
            sumBinNum = new int[operand1.length];
            
            if (operand2[0] == 0)
            {
                operand2 = addZeroToArrayBegin(operand2, operand1.length - operand2.length);
            }
            else
            {
                operand2 = addOneToArrayBegin(operand2, operand1.length - operand2.length);
                filledWithOne = 1;
            }
        }
            
        else if (operand1.length < operand2.length)
        {
            sumBinNum = new int[operand2.length];
            if (operand1[0] == 0)
            {
                operand1 = addZeroToArrayBegin(operand1, operand2.length-operand1.length);
            }
            else 
            {
                operand1 = addOneToArrayBegin(operand1, operand2.length-operand1.length);
                filledWithOne = 1;
            }
        }

        else
        {
            sumBinNum = new int[operand1.length];
        }

        for (int i = sumBinNum.length - 1; i > 0; i--)
        {
            if ((operand1[i] + operand2[i] + transfer == 0) || (operand1[i] + operand2[i] + transfer == 1))
            {
                sumBinNum[i] = operand1[i] + operand2[i] + transfer;
                transfer = 0;
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
           
        }
        if (operand1[0] == 0 && operand2[0] == 0 && transfer == 0) 
        {
            sumBinNum[0] = 0;
            return sumBinNum;
        } 
        else if (operand1[0] == 0 && operand2[0] == 0 && transfer == 1) 
        {
            sumBinNum[0] = 1;
            sumBinNum = addSpaceToArray(sumBinNum);
            sumBinNum[0] = 0;
            return sumBinNum;
        } 
        else if ((operand1[0] == 0 ^ operand2[0] == 0) && transfer == 1) // anpassung für auffüllung einfügen
        {
            if (filledWithOne == 0)
            {
                sumBinNum[0] = 0;
                sumBinNum = addSpaceToArray(sumBinNum);
                sumBinNum[0] = 1;
            }
            else
            {
                sumBinNum[0] = 0;
            }
                return sumBinNum;
        } 
        else if ((operand1[0] == 0 ^ operand2[0] == 0) && transfer == 0) // anpassung für auffüllung einfügen
        {
            if (filledWithOne == 1)
            {
                sumBinNum[0] = 0;
            }
            else
            {

                sumBinNum[0] = 1;
            }
            return sumBinNum;
        } 
        else if (operand1[0] == 1 && operand2[0] == 1 && transfer == 0) 
        {
            sumBinNum[0] = 0;
            sumBinNum = addSpaceToArray(sumBinNum);
            sumBinNum[0] = 1;
            return sumBinNum;
        } 
        else if (operand1[0] == 1 && operand2[0] == 1 && transfer == 1) 
        {
            sumBinNum[0] = 1;
            return sumBinNum;
        } 
        else 
        {
            sumBinNum[0] = 2;
        }

        return sumBinNum;
    }

    static int[] addSpaceToArray(int[] input)
    { 
        if (input == null){
            input = new int[0];
        }
        int oldLength = input.length;
        int newLength = oldLength + 1;

        int[] longerArray = new int[newLength];
        System.arraycopy(input, 0, longerArray, 1, oldLength);
        return longerArray;        
    }

    /**
     * increase of length for positive numbers
     * @param input the array that needs to be stretched
     * @param n length of increasement
     * @return
     */
    static int[] addZeroToArrayBegin(int[] input, int n)
    {
        for (int i = 0; i < n; i++) 
        {
            if (input == null)
            {
            input = new int[0];
            }
            int oldLength = input.length;
            int newLength = oldLength + 1;
            
            int[] longerArray = new int[newLength];
            System.arraycopy(input, 0, longerArray, 1, oldLength);
            longerArray[0] = 0;
            input = longerArray;
        }        
        return input;
    }

    /**
     * increase of length for negative numbers
     * @param input the array that needs to be stretched
     * @param n length of increasement
     * @return
     */
    static int[] addOneToArrayBegin(int[] input, int n)
    {
        for (int i = 0; i < n; i++) 
        {
            if (input == null)
            {
            input = new int[0];
            }
            int oldLength = input.length;
            int newLength = oldLength + 1;
            
            int[] longerArray = new int[newLength];
            System.arraycopy(input, 0, longerArray, 1, oldLength);
            longerArray[0] = 1;
            input = longerArray;
        }        
        return input;
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


/*
*testRandomAddBinaryNumbers(): failure. 0 marks
*Fehler: Die addBinaryNumbers-Methode scheint die Binaerzahlen [0, 0, 1, 0, 1, 0, 0, 1, 1] und [1, 0, 0, 0, 1] nicht korrekt zu addieren. ==> array contents differ at index [0], expected: <1> but was: <0>
*
*Hinweis: In diesem Test wird getestet, ob die Methode addBinaryNumbers() zufaellige Beispiele korrekt berechnet.
*
*001010011 (83)
*111110001 (-15)
*__________
*001000100 (68)
*
*Was soll hier falsch sein?
*/
}
