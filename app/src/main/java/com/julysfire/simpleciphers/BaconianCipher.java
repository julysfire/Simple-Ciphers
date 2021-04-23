package com.julysfire.simpleciphers;

public class BaconianCipher
{
    public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String[] bacon = {"AAAAA", "AAAAB", "AAABA", "AAABB", "AABAA", "AABAB", "AABBA", "AABBB", "ABAAA", "BBBAA", "ABAAB",
            "ABABA", "ABABB", "ABBAA", "ABBAB", "ABBBA", "ABBBB", "BAAAA", "BAAAB", "BAABA", "BAABB", "BBBAB",
            "BABAA", "BABAB", "BABBA", "BABBB"};

    public String newString = "";
    public String breakDown = "";

    public int x = 0;
    public int index = 0;

    public String encrypt(String input)
    {
        boolean stringTest = false;
        stringTest = input.matches("[a-zA-Z ]+");

        if(stringTest == false)
        {
            return "ERROR: Non-alphabet character found.  Please enter only alphabet characters.";
        }
        do
        {
            breakDown = input.substring(x, x+1);
            if(breakDown.matches("^\\s*$") == true)
                newString = newString + " ";
            else
            {
                index = alphabet.indexOf(breakDown.toUpperCase());
                newString = newString + bacon[index] + " ";
            }
            x++;
        }while(x < input.length());

        return newString;
    }

    public String decrypt(String input)
    {
        int failCounter = 0;
        boolean stringTest = false;
        stringTest = input.matches("[a-zA-Z ]+");

        if(stringTest == false)
            return "ERROR: Non-alphabet character found.  Please enter only alphabet characters.";

        if(input.length() < 5)
            return "ERROR, Input is not a correct Baconian encrypted string. See 'About' if you are unsure about this cipher.";
        do
        {

            breakDown = input.substring(x, x+5).toUpperCase();

            for(int y = 0; y < 26; y++)
            {
                if(bacon[y].matches(breakDown) == true)
                {

                    index = y;
                    break;
                }
                else
                    failCounter++;

                if(failCounter == 26)
                {
                    return "ERROR, Input is not a correct Baconian encrypted string. See 'About' if you are unsure about this cipher.";
                }
            }

            newString = newString + alphabet.substring(index, index+1);

            x = x + 6;
        }while(x < input.length());

        return newString;
    }
}
