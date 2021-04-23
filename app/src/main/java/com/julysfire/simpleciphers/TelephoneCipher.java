package com.julysfire.simpleciphers;

public class TelephoneCipher
{
    private String output = "";
    private String breakdown = "";
    private int x = 0;

    public String encrypt(String input)
    {
        output = "";
        input = input.toLowerCase();

        do{
            breakdown = input.substring(x,x+1);

            boolean numcheck = isNum(breakdown);
            boolean specialcheck = breakdown.matches("^.*[^a-zA-Z0-9 ].*$");

            //Test for exceptions
            if(numcheck == true)
                output = output + breakdown + " ";
            else if(specialcheck == true)
                output = output + breakdown + " ";
            else if(Character.isWhitespace(breakdown.charAt(0)))
                output = output + " ";
            else
                output = output+ getNumbers(breakdown);
            x++;
        }while(x < input.length());
        return output;
    }

    //TODO: Can enter '2 3' and it will pick up as 23
    public String decrypt(String input)
    {
        output = "";
        input = input.replace(" ","");

        if(input.length() % 2 != 0)
            return "ERROR: Please enter a valid 2 digit number!";

        do{
            breakdown = input.substring(x,x+2);

            boolean numcheck = isNum(breakdown);
            if(numcheck == false)
                return "ERROR: Please enter only numbers!";

            boolean specialcheck = breakdown.matches("^.*[^a-zA-Z0-9 ].*$");
            if(specialcheck == true)
                return "ERROR: Please enter only numbers!";

            String tempString = getText(breakdown);
            if(tempString.equals("ERROR"))
                return "ERROR: Please enter a valid number!  Think of a cell phone number pad!  If you need help, please see the about section in the top right!";
            else
                output = output + tempString;
            x = x +2;
        }while(x < input.length());
        return output;
    }

    public String getNumbers(String breakdown)
    {
        String returnString = "";
        String s2 = "abc";
        String s3 = "def";
        String s4 = "ghi";
        String s5 = "jkl";
        String s6 = "mno";
        String s7 = "pqrs";
        String s8 = "tuv";
        String s9 = "wxyz";

        if(s2.contains(breakdown))
        {
            int index = s2.indexOf(breakdown) + 1;
            return "2"+index + " ";
        }
        else if(s3.contains(breakdown))
        {
            int index = s3.indexOf(breakdown) + 1;
            return  "3"+index+" ";
        }
        else if(s4.contains(breakdown))
        {
            int index = s4.indexOf(breakdown) + 1;
            return "4"+index+" ";
        }
        else if(s5.contains(breakdown))
        {
            int index = s5.indexOf(breakdown) + 1;
            return "5"+index + " ";
        }
        else if(s6.contains(breakdown))
        {
            int index = s6.indexOf(breakdown) + 1;
            return "6"+index + " ";
        }
        else if(s7.contains(breakdown))
        {
            int index = s7.indexOf(breakdown) + 1;
            return "7"+index+" ";
        }
        else if(s8.contains(breakdown))
        {
            int index = s8.indexOf(breakdown) + 1;
            return "8"+index+" ";
        }
        else if(s9.contains(breakdown))
        {
            int index = s9.indexOf(breakdown) + 1;
            return "9"+index+" ";
        }

        return "ERROR: Count not find number";
    }
    public String getText(String breakdown)
    {
        String s2 = "abc";
        String s3 = "def";
        String s4 = "ghi";
        String s5 = "jkl";
        String s6 = "mno";
        String s7 = "pqrs";
        String s8 = "tuv";
        String s9 = "wxyz";

        switch(breakdown.substring(0,1))
        {
            case "2":
                int index = Integer.parseInt(breakdown.substring(1,2));
                if(index > s2.length())
                    return "ERROR";
                return s2.substring(index-1,index);
            case "3":
                int index2 = Integer.parseInt(breakdown.substring(1,2));
                if(index2 > s3.length())
                    return "ERROR";
                return s3.substring(index2-1,index2);
            case "4":
                int index3 = Integer.parseInt(breakdown.substring(1,2));
                if(index3 > s4.length())
                    return "ERROR";
                return s4.substring(index3-1,index3);
            case "5":
                int index4 = Integer.parseInt(breakdown.substring(1,2));
                if(index4 > s5.length())
                    return "ERROR";
                return s5.substring(index4-1,index4);
            case "6":
                int index5 = Integer.parseInt(breakdown.substring(1,2));
                if(index5 > s6.length())
                    return "ERROR";
                return s6.substring(index5-1,index5);
            case "7":
                int index6 = Integer.parseInt(breakdown.substring(1,2));
                if(index6 > s7.length())
                    return "ERROR";
                return s7.substring(index6-1,index6);
            case "8":
                int index7 = Integer.parseInt(breakdown.substring(1,2));
                if(index7 > s8.length())
                    return "ERROR";
                return s8.substring(index7-1,index7);
            case "9":
                int index8 = Integer.parseInt(breakdown.substring(1,2));
                if(index8 > s9.length())
                    return "ERROR";
                return s9.substring(index8-1,index8);
            default:
                return "ERROR";
        }
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
