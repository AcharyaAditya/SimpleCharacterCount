/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charcountershakesplays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Aditya
 */
public class CharCounterShakesPlays {

    /**
     * I have renamed the text files containing the plays to play1 == Hamlet
     * play2 == JuliusCaesar play3 == KingLear play4 == McBeth play5 == Merchant
     * to encompass all of them with one program, so renaming as per the above
     * convention will be required to run this program. Also change the path in
     * the " BufferedReader reader = new BufferedReader(new
     * FileReader("C:\\Users\\adi_a\\Desktop\\Fall 16\\ece 520\\exercise
     * 1\\play" + playcounter + ".txt")); " line 36 to the path as per the local
     * computer
     *
     * @param args
     */
    public static void main(String[] args) {

        int ch;
        char highestOccChar = ' ';

        try {
            for (int playcounter = 1; playcounter < 6; playcounter++) {
                BufferedReader reader = new BufferedReader(new FileReader("play" + playcounter + ".txt"));
                String test = "abcdefghijklmnopqrstuvwxyz";

                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                /**
                 * Reads all the content of the 5 files one by one as governed
                 * by the above for loop and maps each character to its
                 * occurrence
                 */
                while ((ch = reader.read()) != -1) {
                    Integer val = map.get(new Integer(ch));
                    if (val != null) {
                        map.put(ch, new Integer(val + 1));
                    } else {
                        map.put(ch, 1);
                    }
                }

                reader.close();

                if (playcounter == 1) {
                    System.out.println("HAMLET");
                }
                if (playcounter == 2) {
                    System.out.println("JULIUS CAESAR");
                }
                if (playcounter == 3) {
                    System.out.println("KING LEAR");
                }
                if (playcounter == 4) {
                    System.out.println("MACBETH");
                }
                if (playcounter == 5) {
                    System.out.println("MERCHANT");
                }

                int highestOccVal = 0;
                for (int i = 0; i < test.length(); i++) {
                    char testch = test.charAt(i);
                    //Prints the values along with their occurrences
                    System.out.println("Character: " + testch + " Frequency: " + map.get((int) testch));

                    //Finds the character that occurs most frequently
                    if (map.get((int) testch) != null) {
                        if (map.get((int) testch) > highestOccVal) {
                            highestOccVal = map.get((int) testch);
                            highestOccChar = testch;
                        }
                    }
                }
                System.out.println("");
                System.out.println("Character that occurs most frequently = " + highestOccChar
                        + " and has a frequency of occurrence = " + highestOccVal);
                System.out.println("");
            }
        } catch (IOException ioe) {

        }
    }

}
