/**
 * Main starting point for the program.
 */
package org.jangolano.wordsearch;

import java.io.IOException;

public class WordSearch {

    public static void main(String [] args){
        if(args.length==0){
            System.out.println("You must pass in a filename to continue");
            System.exit(0);
        }

        try {
            PuzzleReader puzzleReader = new PuzzleReader(args[0]);
            String [] words = puzzleReader.parseHeader();
            char [][] data = puzzleReader.getPuzzleData();
            ResultPrinter resultPrinter = new ResultPrinter();
            Puzzle puzzle = new Puzzle(data);
            String results = resultPrinter.getResults(words, puzzle);
            System.out.print(results);
        }catch(IOException e){
            System.out.println("Couldn't read input puzzle file");
        }catch(IllegalArgumentException e){
            System.out.println("The puzzle is not square");
        }
    }
}
