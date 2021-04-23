package com.julysfire.simpleciphers;

public class CaesarCipher
{
    public String encrypt(String str, int num)
    {
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newString = "";
        String breakDown = "";
        int indexOfEach = 0;
        int x = 0;


        //Cipher loophole honestly
        if(num >= 26)
        {
            do {
                num = num-26;
            }while(num>= 26);
        }

        do
        {
            breakDown = str.substring(x, x+1);

            //Is it a number though?
            boolean checkNum = isNum(breakDown);
            boolean specialTest = false;
            specialTest = breakDown.matches("^.*[^a-zA-Z0-9 ].*$");
            if(checkNum == true)
            {
                newString = newString + breakDown;
            }
            else if (specialTest == true)
                newString = newString + breakDown;
            //Space
            else if(Character.isWhitespace(breakDown.charAt(0)))
            {
                newString = newString + " ";
            }

            //Lowercase
            else if(breakDown == breakDown.toLowerCase())
            {
                //Find index
                indexOfEach = alphabetLower.indexOf(breakDown) + num;
                if (indexOfEach >= 26)
                {
                    do
                    {
                        indexOfEach = indexOfEach - 26;
                    }while(indexOfEach >= 26);
                }
                newString = newString + alphabetLower.substring(indexOfEach, indexOfEach+1);
            }
            //Uppercase
            else if(breakDown == breakDown.toUpperCase())
            {
                //Find Index
                indexOfEach = alphabetUpper.indexOf(breakDown) + num;
                if (indexOfEach >= 26)
                {
                    do
                    {
                        indexOfEach = indexOfEach - 26;
                    }while(indexOfEach >= 26);
                }
                newString = newString + alphabetUpper.substring(indexOfEach, indexOfEach+1);
            }
            x++;
        }while(x < str.length());

        return newString;
    }

    public String decrypt(String input, int num)
    {
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String breakDown = "";
        String newString = "";
        int index = 0;
        int x = 0;

        do {
            breakDown = input.substring(x, x+1);
            boolean checkNum = isNum(breakDown);
            boolean specialTest = false;
            specialTest = breakDown.matches("^.*[^a-zA-Z0-9 ].*$");
            if(checkNum == true)
            {
                newString = newString + breakDown;
            }
            else if (specialTest == true)
                newString = newString + breakDown;
            //Space
            else if(Character.isWhitespace(breakDown.charAt(0)))
            {
                newString = newString + " ";
            }

            else if(breakDown == breakDown.toLowerCase())
            {
                index = alphabetLower.indexOf(breakDown);
                index = index - num;

                if (index < 0)
                {
                    do {
                        index = index + 26;
                    }while(index < 0);
                }
                newString = newString + alphabetLower.substring(index, index+1);
            }

            else if(breakDown == breakDown.toUpperCase())
            {
                index = alphabetUpper.indexOf(breakDown);
                index = index - num;

                if (index < 0)
                {
                    do {
                        index = index + 26;
                    }while(index < 0);
                }
                newString = newString + alphabetUpper.substring(index, index+1);
            }
            x++;
        }while (x < input.length());

        return newString;
    }

    public static boolean isNum(String testStr)
    {
        boolean answer = true;
        try
        {
            Double.parseDouble(testStr);
        }catch (NumberFormatException e){
            answer = false;
        }

        return answer;
    }
}
