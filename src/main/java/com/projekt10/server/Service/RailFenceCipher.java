package com.projekt10.server.Service;


public class RailFenceCipher {
    public static String Decode(String encodedString,int railHeight) throws Exception {
        char[][] rail = new char[railHeight][encodedString.length()];

        for (int i = 0; i < railHeight; i++){
            for (int j = 0; j < encodedString.length(); j++){
                rail[i][j] = '.';
            }
        }
        int row = 0;
        int check =0;
        for (int i = 0; i <encodedString.length(); i++) {
            if (check == 0) {
                rail[row][i] = encodedString.charAt(i);
                row++;
                if (row == railHeight) {
                    check = 1;
                    row--;
                }
            }else if (check == 1){
                row--;
                rail[row][i]=encodedString.charAt(i);
                if (row== 0){
                    check =0 ;
                    row =1;
                }

            }

        }
        int ordr = 0 ;
        for (int i = 0; i <railHeight ; i++) {
            for (int j = 0; j < encodedString.length(); j++) {
                String temp = rail[i][j] + "";
                if (temp.matches("\\.")){
                    continue;
                } else{
                    rail[i][j] = encodedString.charAt(ordr);
                    ordr++;
                }
            }
        }
        String decodedString = "";
        check =0;
        row =0;
        for (int i = 0; i < encodedString.length(); i++) {
            if(check == 0){
                decodedString +=  rail[row][i];
                row++;
                if(row == railHeight ){
                    check = 1;
                    row--;
                }
            }
            else if(check == 1){
                row--;
                decodedString +=  rail[row][i];
                if(row == 0){
                    check = 0;
                    row =1;
                }

            }
        }
       return decodedString;
    }



    public static String Encode(String stringToEncode, int railHeight) throws Exception {
        char[][] rail = new char[railHeight][stringToEncode.length()];

        for (int i = 0; i < railHeight; i++){
            for (int j = 0; j < stringToEncode.length(); j++){
                rail[i][j] = '.';
            }
        }

        int row = 0;
        int check =0;
        for (int i = 0; i <stringToEncode.length(); i++) {
            if (check == 0) {
                rail[row][i] = stringToEncode.charAt(i);
                row++;
                if (row == railHeight) {
                    check = 1;
                    row--;
                }
            }else if (check == 1){
                row--;
                rail[row][i]=stringToEncode.charAt(i);
                if (row== 0){
                    check =0 ;
                    row =1;
                }

            }

        }

        String encodedString = "";
        for (int i = 0; i < railHeight; i++) {
            for (int j = 0; j <stringToEncode.length() ; j++) {
                encodedString +=  rail[i][j];

            }
        }
        encodedString= encodedString.replaceAll("\\.","");
        return encodedString;
    }
}
