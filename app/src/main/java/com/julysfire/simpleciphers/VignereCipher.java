package com.julysfire.simpleciphers;

public class VignereCipher
{
    public String newString = "";

    private static String inputBreakdown = "";
    private static String phraseBreakdown = "";

    private int x = 0;
    private int y = 0;
    private int indexX = 0;
    private int indexY = 0;

    private int lowerCase = 0;

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String[] alphabetArray = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "BCDEFGHIJKLMNOPQRSTUVWXYZA", "CDEFGHIJKLMNOPQRSTUVWXYZAB",
            "DEFGHIJKLMNOPQRSTUVWXYZABC", "EFGHIJKLMNOPQRSTUVWXYZABCD", "FGHIJKLMNOPQRSTUVWXYZABCDE",
            "GHIJKLMNOPQRSTUVWXYZABCDEF", "HIJKLMNOPQRSTUVWXYZABCDEFG", "IJKLMNOPQRSTUVWXYZABCDEFGH",
            "JKLMNOPQRSTUVWXYZABCDEFGHI", "KLMNOPQRSTUVWXYZABCDEFGHIJ", "LMNOPQRSTUVWXYZABCEFGHIJKL",
            "MNOPQRSTUVWXYZABCDEFGHIJKL", "NOPQRSTUVWXYZABCDEFGHIJKLM", "OPQRSTUVWXYZABCDEFGHIJKLMN",
            "PQRSTUVWXYZABCDEFGHIJKLMNO", "QRSTUVWXYZABCDEFGHIJKLMNOP", "RSTUVWXYZABCDEFGHIJKLMNOPQ",
            "STUVWXYZABCDEFGHIJKLMNOPQR", "TUVWXYZABCDEFGHIJKLMNOPQRS", "UVWXYZABCDEFGHIJKLMNOPQRST",
            "VWXYZABCDEFGHIJKLMNOPQRSTU", "WXYZABCDEFGHIJKLMNOPQRSTUV", "XYZABCDEFGHIJKLMNOPQRSTUVW",
            "YZABCDEFGHIJKLMNOPQRSTUVWX", "ZABCDEFGHIJKLMNOPQRSTUVWXY"};
    private String tempString = "";

    public String encrypt(String input, String phrase)
    {
        do{
            inputBreakdown = input.substring(x, x+1);

            if(inputBreakdown == inputBreakdown.toLowerCase())
                lowerCase = 1;

            boolean isNum = false;
            isNum = numTest(inputBreakdown);
            boolean specialTest = false;
            specialTest = inputBreakdown.matches("^.*[^a-zA-Z0-9 ].*$");

            if(isNum == true)
            {
                newString = newString + inputBreakdown;
                x++;
                y++;
            }

            else if(specialTest == true)
            {
                newString = newString + inputBreakdown;
                x++;
                y++;
            }
            else if(specialTest == false && isNum == false)
            {
                if(inputBreakdown.matches("^\\s*$") == false)
                {

                    phraseBreakdown = phrase.substring(y, y+1);

                    boolean phraseIsNum = false;
                    phraseIsNum = numTest(phraseBreakdown);
                    boolean phraseSpecialTest = false;
                    phraseSpecialTest = phraseBreakdown.matches("^.*[^a-zA-Z0-9 ].*$");

                    if(phraseIsNum == true)
                        return "ERROR: Number detected.  Please eneter only letters for the phrase";
                    else if(phraseSpecialTest == true)
                        return "ERROR: Special character detected.  Please enter only letters for the phrase";
                    else if(phraseBreakdown.matches("^\\s*$") == false)
                    {
                        indexX = alphabet.indexOf(inputBreakdown.toUpperCase());
                        indexY = alphabet.indexOf(phraseBreakdown.toUpperCase());

                        tempString = alphabetArray[indexX];
                        if(lowerCase == 1)
                            newString = newString + tempString.substring(indexY, indexY+1).toLowerCase();
                        else
                            newString = newString + tempString.substring(indexY, indexY+1);
                    }
                    else
                        x--;
                    y++;
                    if(y >= phrase.length())
                        y=0;
                }
                else
                    newString = newString + " ";
                x++;
            }
        }while(x < input.length());

        return newString;
    }

    public String decrypt(String input, String phrase)
    {
        do{
            inputBreakdown = input.substring(x, x+1);

            if(inputBreakdown == inputBreakdown.toLowerCase())
                lowerCase = 1;

            boolean isNum = false;
            isNum = numTest(inputBreakdown);
            boolean specialTest = false;
            specialTest = inputBreakdown.matches("^.*[^a-zA-Z0-9 ].*$");

            if(isNum == true)
            {
                newString = newString + inputBreakdown;
                x++;
                y++;
            }

            else if(specialTest == true)
            {
                newString = newString + inputBreakdown;
                x++;
                y++;
            }
            else if(specialTest == false && isNum == false)
            {
                if(inputBreakdown.matches("^\\s*$") == false)
                {
                    phraseBreakdown = phrase.substring(y, y+1);
                    boolean phraseIsNum = false;
                    phraseIsNum = numTest(phraseBreakdown);
                    boolean phraseSpecialTest = false;
                    phraseSpecialTest = phraseBreakdown.matches("^.*[^a-zA-Z0-9 ].*$");

                    if(phraseIsNum == true)
                        return "ERROR: Number detected.  Please eneter only letters for the phrase";
                    else if(phraseSpecialTest == true)
                        return "ERROR: Special character detected.  Please enter only letters for the phrase";

                    else if(phraseBreakdown.matches("^\\s*$") == false)
                    {
                        indexY = alphabet.indexOf(phraseBreakdown.toUpperCase());

                        tempString = alphabetArray[indexY];
                        indexX = tempString.indexOf(inputBreakdown.toUpperCase());

                        if(lowerCase == 1)
                            newString = newString + alphabet.substring(indexX, indexX+1).toLowerCase();
                        else
                            newString = newString + alphabet.substring(indexX, indexX+1);
                    }
                    else
                        x--;
                    y++;
                    if(y >= phrase.length())
                        y=0;
                }
                else
                    newString = newString + " ";
                x++;
            }

        }while(x < input.length());

        return newString;
    }

    public boolean numTest(String breakString)
    {
        boolean answer = true;
        try
        {
            Double.parseDouble(breakString);
        }catch (NumberFormatException e){
            answer = false;
        }

        return answer;
    }
}