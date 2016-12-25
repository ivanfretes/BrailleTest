/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlegallenge;

import BrailleApp.*;

/**
 *
 * @author ivan
 */
public class Answer1 {
    
    /**
     *
     * @param plaintext
     * @return
     */
    public static String answer(String plaintext) { 
        byte column = 2;
        byte row = 3;
        
        
        byte cantPlaitexChart;
        cantPlaitexChart = (byte) plaintext.length();
        
        // character default
        String abxyz = new String();
        abxyz = "abcdefghijklnopqrstuvxyz";
        
        // Braille base structure 
        byte[][] brailleStructure = new byte[column][row];
        
        // Character to point convalid the alphabeth
        int[][] basicAlphabethBraile = {    {1},            // a 
                                            {1,2},          // b 
                                            {1,4},          // c 
                                            {1,4,5},        // d 
                                            {1,5},          // e 
                                            {1,2,4},        // f 
                                            {1,2,4,5},      // g 
                                            {1,2,5},        // h 
                                            {2,4},          // i
                                            {2,4,5},        // j
                                        };
        
        
        System.out.println();
        
        // Buble var
        byte positionAlphabeth;
        char characterPlaintex;
        int Alphabeth;
        // Traductor 
        for (byte i = 0; i < cantPlaitexChart; i++) {
            characterPlaintex = plaintext.charAt(i);
            positionAlphabeth = (byte) abxyz.indexOf(characterPlaintex);
            
            
            for (int j = 0; j < basicAlphabethBraile[positionAlphabeth].length; j++) {
                //if (basicAlphabethBraile[positionAlphabeth][j] < column) {
                     //brailleStructure[0][basicAlphabethBraile[positionAlphabeth][j] - 1] = 1;
                //}
                /*else {
                     brailleStructure[0][basicAlphabethBraile[positionAlphabeth][j] - 1] = 1;
                }*/
                System.out.println(basicAlphabethBraile[positionAlphabeth][j]);
            }
            System.out.println("asalsa");
            //if (positionAlphabeth > 10 && positionAlphabeth < 20){
                
            //}  
        }
        
        // Your code goes here.
        return "brailecode";
    }


}
