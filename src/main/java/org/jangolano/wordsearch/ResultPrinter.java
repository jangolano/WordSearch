/**
 * This class is used to print the results of the program to the screen.
 */
package org.jangolano.wordsearch;

import java.util.ArrayList;

public class ResultPrinter {

    public  ResultPrinter(){

    }

    //Get the string results
    public String getResults(String[] words, Puzzle puzzle) {
        StringBuffer results = new StringBuffer("");
        for (String word : words) {
            ArrayList<Point> points = puzzle.searchPuzzle(word);
            results.append(word + ": ");
            for (Point point : points) {
                results.append("(" + point.getColumn() + "," + point.getRow() + "),");
            }
            results.deleteCharAt(results.lastIndexOf(","));
            results.append("\n");
        }
        results.deleteCharAt(results.lastIndexOf("\n"));
        return results.toString();
    }
}
