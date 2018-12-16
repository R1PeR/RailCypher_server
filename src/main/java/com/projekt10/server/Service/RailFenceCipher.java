package com.projekt10.server.Service;

public class RailFenceCipher {
    public static String Encode(String stringToEncode, int railHeight) throws Exception {
        char stringInRail[][] = new char[railHeight][stringToEncode.length() / railHeight];
        int index = 0;
        String encodedString = "";
        for (int i = 0; i < stringToEncode.length() / railHeight; i++) {
            for (int j = 0; j < railHeight; j++) {
                if (index != stringToEncode.length())
                    stringInRail[j][i] = stringToEncode.charAt(index++);
                else
                    stringInRail[j][i] = 'X';
            }
        }
        for (int i = 0; i < railHeight; i++) {
            for (int j = 0; j < stringToEncode.length() / railHeight; j++) {
                encodedString += stringInRail[i][j];
            }
        }
        return encodedString;
    }


    public static String Decode(String encodedString, int railHeight) throws Exception {
        char stringInRail[][] = new char[railHeight][encodedString.length() / railHeight];
        int index = 0;
        String decodedString = "";
        for (int i = 0; i < railHeight; i++) {
            for (int j = 0; j < encodedString.length() / railHeight; j++) {
                stringInRail[i][j] = encodedString.charAt(index++);
            }
        }
        for (int i = 0; i < encodedString.length() / railHeight; i++) {
            for (int j = 0; j < railHeight; j++) {
                decodedString += stringInRail[j][i];
            }
        }
        return decodedString;
    }
}
