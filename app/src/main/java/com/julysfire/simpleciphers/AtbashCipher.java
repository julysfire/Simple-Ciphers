package com.julysfire.simpleciphers;

public class AtbashCipher
{
    public String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    public String atbashUpper = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
    public String atbashLower = "zyxwvutsrqponmlkjihgfedcba";

    public int x = 0;

    public String breakDown = "";
    public String newString = "";

    public int index = 0;

    public String encrypt(String input)
    {
        do
        {
            breakDown = input.substring(x, x+1);

            boolean isNum = false;
            boolean specialTest = false;

            isNum = numTest(breakDown);
            specialTest = breakDown.matches("^.*[^a-zA-Z0-9 ].*$");
            if(isNum == true)
                newString = newString + breakDown;
            else if(specialTest == true)
                newString = newString + breakDown;
            else if(breakDown.matches("^\\s*$") == true)
                newString = newString + " ";
            else if(breakDown == breakDown.toUpperCase())
            {
                index = alphabetUpper.indexOf(breakDown);
                newString = newString + atbashUpper.substring(index, index+1);
            }
            else if(breakDown == breakDown.toLowerCase())
            {
                index = alphabetLower.indexOf(breakDown);
                newString = newString + atbashLower.substring(index, index+1);
            }

            x++;
        }while(x < input.length());

        return newString;
    }


    public String decrypt(String input)
    {
        do
        {
            breakDown = input.substring(x, x+1);

            boolean isNum = false;
            boolean specialTest = false;

            isNum = numTest(breakDown);
            specialTest = breakDown.matches("^.*[^a-zA-Z0-9 ].*$");

            if(isNum == true)
                newString = newString + breakDown;
            else if(specialTest == true)
                newString = newString + breakDown;
            else if(breakDown.matches("^\\s*$") == true)
                newString = newString + " ";
            else if(breakDown == breakDown.toUpperCase())
            {
                index = atbashUpper.indexOf(breakDown);
                newString = newString + alphabetUpper.substring(index, index+1);
            }
            else if(breakDown == breakDown.toLowerCase())
            {
                index = atbashLower.indexOf(breakDown);
                newString = newString + alphabetLower.substring(index, index+1);
            }

            x++;
        }while(x < input.length());

        return newString;
    }

    public boolean numTest(String breakString)
    {
        return breakString != null && breakString.matches("[-+]?\\d*\\.?\\d+");
    }
}
