/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrailleApp;

/**
 *
 * @author ivan
 */
public class Answer {
    
    /**
     *
     * @param plaintext
     * @return
     */
    public static String answer(String plaintext) { 
        byte column = 2;
        byte row = 3;
        
        //
        byte baseDecimal = 10;
        // Cantidad de caracteres
        byte cantPlaitexChart;
        cantPlaitexChart = (byte) plaintext.length();
        // Position of the character
        byte positionAlphabeth;
        char characterPlaintex;
        
        
        
        // character default
        String[] abxyz = { "abcdefghijklmnopqrstuvxyzw",
                           "ABCDEFGHIJKLMNOPQRSTUVXYZW"};
      
        
        int[][][] basicAlphabethBraile = {      {{1,0},{0,0},{0,0}},   // a 1
                                                {{1,0},{1,0},{0,0}},   // b 1-2
                                                {{1,1},{0,0},{0,0}},   // c 1-4
                                                {{1,1},{0,1},{0,0}},   // d 1-4-5
                                                {{1,0},{0,1},{0,0}},   // e 
                                                {{1,1},{1,0},{0,0}},   // f 
                                                {{1,1},{1,1},{0,0}},   // g 
                                                {{1,0},{1,1},{0,0}},   // h 
                                                {{0,1},{1,0},{0,0}},   // i
                                                {{0,1},{1,1},{0,0}},   // j
                                                {{0,1},{1,1},{0,1}}    // w
                                        };

       
        //System.out.println(basicAlphabethBraile[1][1].length);
        String brailleText = "";
        byte mayOrMin = 0;
        
        
        // Traductor 
        for (byte i = 0; i < cantPlaitexChart; i++) {
            positionAlphabeth = 0;
            mayOrMin = 0;
            
            characterPlaintex = plaintext.charAt(i);
            if (characterPlaintex == ' '){
                brailleText += "000000";
                continue;
            }
          
            
            for (int m = 0; m < abxyz.length; m++) {
                if (abxyz[m].indexOf(characterPlaintex) != -1){
                    positionAlphabeth = (byte) abxyz[m].indexOf(characterPlaintex);
                    mayOrMin = (byte) m;
                    
                    if (m == 1){
                        brailleText += "000001"; 
                    }
                    m = abxyz.length;
                }
            }
            
            
           
            
            
            //System.out.println(positionAlphabeth);
            //System.out.println(positionAlphabeth / baseDecimal);
            
            
            // determina si la le letra tiene mas de 10 caracteres
            byte masc = 0;
            if (positionAlphabeth / baseDecimal == 1) masc = 1;
            else if (positionAlphabeth / baseDecimal == 2) masc = 2;
            
            
            
            positionAlphabeth = (byte) (positionAlphabeth % baseDecimal);
            //System.out.println(positionAlphabeth);
            
            
            int [][] brailleTempCharacter = new int[row][column];
            
            
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < row; k++) {
                    brailleTempCharacter[k][j] = basicAlphabethBraile[positionAlphabeth][k][j];
                    
                    
                    if (masc == 1){
                      
                        brailleTempCharacter[row - 1][0] = 1;
                    }
                    else if (masc == 2){
                        brailleTempCharacter[row - 1][0] = 1;
                        brailleTempCharacter[row - 1][1] = 1;
                    }
                    brailleText += brailleTempCharacter[k][j];
                }
            }
            
           //brailleText += " ";
        }
       
       return brailleText;
    }


}
