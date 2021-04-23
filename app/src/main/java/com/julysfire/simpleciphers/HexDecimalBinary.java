package com.julysfire.simpleciphers;

public class HexDecimalBinary
{
    //TEXT
    private String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    private String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String special = "!\"#$%&()*+,-./:;<=>?@[\\]^_`{|}~";
    private String numbers = "0123456789";
    //----

    //HEX
    private String[] hexLower = {"61","62","63","64","65","66","67","68","69","6A","6B","6C","6D","6E","6F","70","71","72","73","74","75","76","77","78","79","7A"};
    private String[] hexUpper = {"41","42","43","44","45","46","47","48","49","4A","4B","4C","4D","4E","4F","50","51","52","53","54","55","56","57","58","59","5A"};
    private String[] hexSpecial = {"21","22","23","24","25","26","28","29","2A","2B","2C","2D","2E","2F","3A","3B","3C","3D","3E","3F","40","5B","5C","5D","5E","5F","60","7B","7C","7D","7E"};
    private String[] hexNumber = {"30","31","32","33","34","35","36","37","38","39"};
    private String hexSpace = "20";
    //----

    //DECIMAL
    private String[] decimalsUpper = {"65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90"};
    private String[] decimalsLower = {"97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122"};
    private String[] decimalsNumber = {"48", "49", "50", "51", "52", "53", "54", "55", "56", "57"};
    private String decimalsSpace = "32";
    private String[] decimalsSpecial = {"33", "34", "35", "36", "37", "38", "40", "41", "42", "43", "44", "45", "46", "47", "58", "59", "60", "61", "62", "63", "64", "91", "92", "93", "94", "95", "96", "123", "124", "125", "126"};
    //----

    //BINARY
    private String[] binaryUpper= {"01000001", "01000010", "01000011", "01000100", "01000101", "01000110", "01000111", "01001000", "01001001", "01001010", "01001011", "01001100", "01001101", "01001110", "01001111", "01010000", "01010001", "01010010", "01010011", "01010100", "01010101", "01010110", "01010111", "01011000", "01011001", "01011010"};
    private String[] binaryLower = {"01100001", "01100010", "01100011", "01100100", "01100101", "01100110", "01100111", "01101000", "01101001", "01101010", "01101011", "01101100", "01101101", "01101110", "01101111", "01110000", "01110001", "01110010", "01110011", "01110100", "01110101", "01110110", "01110111", "01111000", "01111001", "01111010"};
    private String[] binaryNumber = {"00110000", "00110001", "00110010", "00110011", "00110100", "00110101", "00110110", "00110111", "00111000", "00111001"};
    private String binarySpace = "00100000";
    private String[] binarySpecial = {"00100001","001000010", "001000011", "001000100","00100101","00100110","00101000","00101001","00101010","00101011","00101100","00101101","00101110","00101111","00111010","00111011","00111100","00111101","00111110","00111111","01000000","01011011","01011100","01011101","01011110","01011111","01100000","01111011","01111100","01111101","01111110"};
    //----

    private String breakdown = "";
    private int x = 0;
    private String outputString = "";

    public String encryptDecrypt(String text, String inputType, String outputType)
    {
        inputType = inputType.toLowerCase();
        outputType = outputType.toLowerCase();

        switch (inputType)
        {
            case "text":
                switch(outputType)
                {
                    case "text":
                        outputString = text;
                        break;
                    case "hex":
                        outputString = textToHex(text);
                        break;
                    case "decimal":
                        outputString = textToDecimal(text);
                        break;
                    case "binary":
                        outputString = textToBinary(text);
                        break;
                }
                break;
            case "hex":
                switch(outputType)
                {
                    case "text":
                        outputString = hexToText(text);
                        break;
                    case "hex":
                        outputString = text;
                        break;
                    case "decimal":
                        outputString = hexToDecimal(text);
                        break;
                    case "binary":
                        outputString = hexToBinary(text);
                        break;
                }
                break;
            case "decimal":
                switch(outputType)
                {
                    case "text":
                        outputString = decimalToText(text);
                        break;
                    case "hex":
                        outputString = decimalToHex(text);
                        break;
                    case "decimal":
                        outputString = text;
                        break;
                    case "binary":
                        outputString = decimalToBinary(text);
                        break;
                }
                break;
            case "binary":
                switch(outputType)
                {
                    case "text":
                        outputString = binaryToText(text);
                        break;
                    case "hex":
                        outputString = binaryToHex(text);
                        break;
                    case "decimal":
                        outputString = binaryToDecimal(text);
                        break;
                    case "binary":
                        outputString = text;
                        break;
                }
                break;
        }
        return outputString;
    }

    //Done
    public String textToHex(String text)
    {
        byte[] bytes = text.getBytes();
        for(byte x : bytes)
        {
            String newHex = "";
            newHex = String.format("%02X ", x);
            outputString = outputString + newHex;
        }
        return outputString;
    }

    //Done
    public String textToDecimal(String text)
    {
        do {
            breakdown = text.substring(x, x+1);

            boolean numTest = numTest(breakdown);

            if(numTest == true)
            {
                int y = Integer.parseInt(breakdown);
                outputString = outputString + decimalsNumber[y] + " ";
            }
            else if(breakdown.matches("^\\s*$") == true)
            {
                outputString = outputString + decimalsSpace + " ";
            }
            else if(breakdown.matches("^.*[^a-zA-Z0-9 ].*$"))
            {
                int y = special.indexOf(breakdown);
                outputString = outputString + decimalsSpecial[y] + " ";
            }
            else if(breakdown == breakdown.toLowerCase())
            {
                int index = alphabetLower.indexOf(breakdown);
                outputString = outputString + decimalsLower[index] + " ";
            }
            else if(breakdown == breakdown.toUpperCase())
            {
                int index = alphabetUpper.indexOf(breakdown);
                outputString = outputString + decimalsUpper[index] + " ";
            }

            x++;
        }while(x < text.length());
        return outputString;
    }

    //Done
    public String textToBinary(String text)
    {
        do{
            breakdown = text.substring(x,x+1);
            boolean numTest = numTest(breakdown);

            if(numTest == true)
            {
                int y = Integer.parseInt(breakdown);
                outputString = outputString + binaryNumber[y] + " ";
            }
            else if(breakdown.matches("^\\s*$") == true)
            {
                outputString = outputString + binarySpace + " ";
            }
            else if(breakdown.matches("^.*[^a-zA-Z0-9 ].*$"))
            {
                int index = special.indexOf(breakdown);
                outputString = outputString + binarySpecial[index] + " ";
            }
            else if(breakdown.matches(breakdown.toLowerCase()))
            {
                int index = alphabetLower.indexOf(breakdown);
                outputString = outputString + binaryLower[index] + " ";
            }
            else if(breakdown.matches(breakdown.toUpperCase()))
            {
                int index = alphabetUpper.indexOf(breakdown);
                outputString = outputString + binaryUpper[index] + " ";
            }

            x++;
        }while(x < text.length());
        return outputString;
    }

    //Done
    public String hexToText(String text)
    {
        text = text.toUpperCase();
        String preString = "";
        if(text.length() < 2)
            return "ERROR: Non Hex text found!";
        do {
            preString = outputString;
            breakdown = text.substring(x,x+2);

            if(hexSpace.equals(breakdown))
            {
                outputString = outputString + " ";
            }
            for(int z = 0; z < alphabetLower.length(); z++)
            {
                if(hexLower[z].equals(breakdown)) {
                    outputString = outputString + alphabetLower.substring(z, z + 1);
                    break;
                }
            }
            for(int z = 0; z < alphabetUpper.length(); z++)
            {
                if(hexUpper[z].equals(breakdown)) {
                    outputString = outputString + alphabetUpper.substring(z, z + 1);
                    break;
                }
            }
            for(int z = 0; z < numbers.length(); z++)
            {
                if(hexNumber[z].equals(breakdown)) {
                    outputString = outputString + numbers.substring(z, z + 1);
                    break;
                }
            }
            for(int z = 0; z < special.length(); z++)
            {
                if(hexSpecial[z].equals(breakdown)) {
                    outputString = outputString + special.substring(z, z + 1);
                    break;
                }
            }

            if(outputString.equals(preString))
                return "ERROR: Non Hex text found!";
            if(x+3 > text.length())
            {
                x = x + 2;
            }
            else
            {
                if(text.substring(x+2,x+3).equals(" "))
                    x = x + 3;
                else
                    x = x + 2;
            }
        }while (x < text.length());
        return outputString;
    }

    //Done
    public String hexToDecimal(String text)
    {
        text = text.toUpperCase();
        String preString = "";
        if(text.length() < 2)
            return "ERROR: Non Hex text found!";

        do{
            preString = outputString;
            breakdown = text.substring(x,x+2);

            if(hexSpace.equals(breakdown))
            {
                outputString = outputString + decimalsSpace + " ";
            }
            for(int z = 0; z < decimalsLower.length; z++)
            {
                if(hexLower[z].equals(breakdown)) {
                    outputString = outputString + decimalsLower[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < decimalsUpper.length; z++)
            {
                if(hexUpper[z].equals(breakdown)) {
                    outputString = outputString + decimalsUpper[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < decimalsNumber.length; z++)
            {
                if(hexNumber[z].equals(breakdown)) {
                    outputString = outputString + decimalsNumber[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < decimalsSpecial.length; z++)
            {
                if(hexSpecial[z].equals(breakdown)) {
                    outputString = outputString + decimalsSpecial[z] + " ";
                    break;
                }
            }

            if(outputString.equals(preString))
                return "ERROR: Non Hex text found!";

            if(x+3 > text.length())
            {
                x = x + 2;
            }
            else
            {
                if(text.substring(x+2,x+3).equals(" "))
                    x = x + 3;
                else
                    x = x + 2;
            }
        }while(x < text.length());
        return outputString;    }

    //Done
    public String hexToBinary(String text)
    {
        text = text.toUpperCase();
        String preString = "";
        if(text.length() < 2)
            return "ERROR: Non Hex text found!";

        do{
            preString = outputString;
            breakdown = text.substring(x,x+2);

            if(hexSpace.equals(breakdown))
            {
                outputString = outputString + binarySpace + " ";
            }
            for(int z = 0; z < binaryLower.length; z++)
            {
                if(hexLower[z].equals(breakdown)) {
                    outputString = outputString + binaryLower[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < binaryUpper.length; z++)
            {
                if(hexUpper[z].equals(breakdown)) {
                    outputString = outputString + binaryUpper[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < binaryNumber.length; z++)
            {
                if(hexNumber[z].equals(breakdown)) {
                    outputString = outputString + binaryNumber[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < binarySpecial.length; z++)
            {
                if(hexSpecial[z].equals(breakdown)) {
                    outputString = outputString + binarySpecial[z] + " ";
                    break;
                }
            }

            if(outputString.equals(preString))
                return "ERROR: Non Hex text found!";

            if(x+3 > text.length())
            {
                x = x + 2;
            }
            else
            {
                if(text.substring(x+2,x+3).equals(" "))
                    x = x + 3;
                else
                    x = x + 2;
            }
        }while(x < text.length());
        return outputString;    }

    //Done
    public String decimalToText(String text)
    {
        text = text.replace(" ","");
        String preString = "";

        if(text.length() < 3)
            return "ERROR: Non Decimal text found!";
        do{
            preString = outputString;
            if(text.substring(x,x+1).equals("1"))
            {
                breakdown = text.substring(x,x+3);
            }
            else
                breakdown = text.substring(x,x+2);

            if(decimalsSpace.equals(breakdown))
            {
                outputString = outputString + " ";
            }
            for(int z = 0; z < alphabetLower.length(); z++)
            {
                if(decimalsLower[z].equals(breakdown)) {
                    outputString = outputString + alphabetLower.substring(z,z+1);
                    break;
                }
            }
            for(int z = 0; z < alphabetUpper.length(); z++)
            {
                if(decimalsUpper[z].equals(breakdown)) {
                    outputString = outputString + alphabetUpper.substring(z,z+1);
                    break;
                }
            }
            for(int z = 0; z < numbers.length(); z++)
            {
                if(decimalsNumber[z].equals(breakdown)) {
                    outputString = outputString + numbers.substring(z,z+1);
                    break;
                }
            }
            for(int z = 0; z < special.length(); z++)
            {
                if(decimalsSpecial[z].equals(breakdown)) {
                    outputString = outputString + special.substring(z,z+1);
                    break;
                }
            }

            if(outputString.equals(preString))
                return "ERROR: Non Decimal text found!";

            if(text.substring(x,x+1).equals("1"))
            {
                x=x+3;
            }
            else
                x=x+2;

        }while(x < text.length());
        return outputString;    }

    //Done
    public String decimalToHex(String text)
    {
        text = text.replace(" ", "");
        String preString = "";

        if(text.length() < 3)
            return "ERROR: Non Decimal text found!";
        do{
            preString = outputString;
            if(text.substring(x,x+1).equals("1"))
            {
                breakdown = text.substring(x,x+3);
            }
            else
                breakdown = text.substring(x,x+2);


            if(decimalsSpace.equals(breakdown))
            {
                outputString = outputString + hexSpace + " ";
            }
            for(int z = 0; z < hexLower.length; z++)
            {
                if(decimalsLower[z].equals(breakdown)) {
                    outputString = outputString + hexLower[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < hexUpper.length; z++)
            {
                if(decimalsUpper[z].equals(breakdown)) {
                    outputString = outputString + hexUpper[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < hexNumber.length; z++)
            {
                if(decimalsNumber[z].equals(breakdown)) {
                    outputString = outputString + hexNumber[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < hexSpecial.length; z++)
            {
                if(decimalsSpecial[z].equals(breakdown)) {
                    outputString = outputString + hexSpecial[z] + " ";
                    break;
                }
            }

            if(outputString.equals(preString))
                return "ERROR: Non Decimal text found!";

            if(text.substring(x,x+1).equals("1"))
            {
                x=x+3;
            }
            else
                x=x+2;

        }while(x < text.length());
        return outputString;    }

    //Done
    public String decimalToBinary(String text)
    {
        text = text.replace(" ", "");
        String preString = "";

        if(text.length() < 3)
            return "ERROR: Non Decimal text found!";

        do{
            preString = outputString;
            if(text.substring(x,x+1).equals("1"))
            {
                breakdown = text.substring(x,x+3);
            }
            else
                breakdown = text.substring(x,x+2);


            if(decimalsSpace.equals(breakdown))
            {
                outputString = outputString + binarySpace + " ";
            }
            for(int z = 0; z < binaryLower.length; z++)
            {
                if(decimalsLower[z].equals(breakdown)) {
                    outputString = outputString + binaryLower[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < binaryUpper.length; z++)
            {
                if(decimalsUpper[z].equals(breakdown)) {
                    outputString = outputString + binaryUpper[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < binaryNumber.length; z++)
            {
                if(decimalsNumber[z].equals(breakdown)) {
                    outputString = outputString + binaryNumber[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < binarySpecial.length; z++)
            {
                if(decimalsSpecial[z].equals(breakdown)) {
                    outputString = outputString + binarySpecial[z] + " ";
                    break;
                }
            }

            if(outputString.equals(preString))
                return "ERROR: Non Decimal text found!";

            if(text.substring(x,x+1).equals("1"))
            {
                x=x+3;
            }
            else
                x=x+2;

        }while(x < text.length());
        return outputString;    }

    //Done
    public String binaryToText(String text)
    {
        text = text.replace(" ", "");
        String preString = "";

        if(text.length() < 8)
            return "ERROR: Non Binary number found!";

        do {
            boolean spacer = false;
            preString = outputString;
            breakdown = text.substring(x,x+8);

            if(breakdown.equals(binarySpace))
            {
                outputString = outputString + " ";
                spacer = true;
            }
            for(int z = 0; z < alphabetLower.length(); z++)
            {
                if(binaryLower[z].equals(breakdown))
                {
                    outputString = outputString + alphabetLower.substring(z,z+1);
                    break;
                }
            }
            for(int z = 0; z < alphabetUpper.length(); z++)
            {
                if(binaryUpper[z].equals(breakdown))
                {
                    outputString = outputString + alphabetUpper.substring(z,z+1);
                    break;
                }
            }
            for(int z = 0; z < special.length(); z++)
            {
                if(binarySpecial[z].equals(breakdown))
                {
                    outputString = outputString + special.substring(z,z+1);
                    break;
                }
            }
            for(int z = 0; z < numbers.length(); z++)
            {
                if(binaryNumber[z].equals(breakdown))
                {
                    outputString = outputString + numbers.substring(z,z+1);
                    break;
                }
            }

            if(spacer == false)
            {
                if(outputString.equals(preString))
                    return "ERROR: Non Binary number found!";
            }

            x = x + 8;
        }while(x < text.length());
        return outputString;    }

    //Done
    public String binaryToHex(String text)
    {
        text = text.replace(" ", "");
        String preString = "";

        if(text.length() < 8)
            return "ERROR: Non Binary number found!";

        do {
            boolean spacer = false;
            preString = outputString;
            breakdown = text.substring(x,x+8);

            if(breakdown.equals(binarySpace))
            {
                outputString = outputString + hexSpace + " ";
                spacer = true;
            }
            for(int z = 0; z < hexLower.length; z++)
            {
                if(binaryLower[z].equals(breakdown))
                {
                    outputString = outputString + hexLower[z] + " ";
                    break;
                }
            }
            for(int z =0; z < hexUpper.length; z++)
            {
                if(binaryUpper[z].equals(breakdown))
                {
                    outputString = outputString + hexUpper[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < hexSpecial.length; z++)
            {
                if(binarySpecial[z].equals(breakdown))
                {
                    outputString = outputString + hexSpecial[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < hexNumber.length; z++)
            {
                if(binaryNumber[z].equals(breakdown))
                {
                    outputString = outputString + hexNumber[z] + " ";
                    break;
                }
            }

            if(spacer == false)
            {
                if(outputString.equals(preString))
                    return "ERROR: Non Binary number found!";
            }

            x = x + 8;
        }while(x < text.length());
        return outputString;    }

    //Done
    public String binaryToDecimal(String text)
    {
        text = text.replace(" ", "");
        String preString = "";

        if(text.length() < 8)
            return "ERROR: Non Binary number found!";

        do {
            boolean spacer = false;
            preString = outputString;
            breakdown = text.substring(x,x+8);

            if(breakdown.equals(binarySpace))
            {
                outputString = outputString + decimalsSpace + " ";
                spacer = true;
            }
            for(int z = 0; z < decimalsLower.length; z++)
            {
                if(binaryLower[z].equals(breakdown))
                {
                    outputString = outputString + decimalsLower[z] + " ";
                    break;
                }
            }
            for(int z =0; z < decimalsUpper.length; z++)
            {
                if(binaryUpper[z].equals(breakdown))
                {
                    outputString = outputString + decimalsUpper[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < decimalsSpecial.length; z++)
            {
                if(binarySpecial[z].equals(breakdown))
                {
                    outputString = outputString + decimalsSpecial[z] + " ";
                    break;
                }
            }
            for(int z = 0; z < decimalsNumber.length; z++)
            {
                if(binaryNumber[z].equals(breakdown))
                {
                    outputString = outputString + decimalsNumber[z] + " ";
                    break;
                }
            }

            if(spacer == false)
            {
                if(outputString.equals(preString))
                    return "ERROR: Non Binary number found!";
            }

            x = x + 8;
        }while(x < text.length());
        return outputString;
    }

    //Done
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
