package main.java.org.roksolana;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Poker adviser application.
 */
public class PokerAdviserApp {

    public static void main(String[] args)  {
        String fileName = "data.txt";        
        try {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {
                String advice = PokerAdviser.advice(scanner.nextLine());
                System.out.println(advice);
            }
            scanner.close();
        }catch (FileNotFoundException e) {
                e.printStackTrace();      
        } 
    }

}
