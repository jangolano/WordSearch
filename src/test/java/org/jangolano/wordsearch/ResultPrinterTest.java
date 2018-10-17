package org.jangolano.wordsearch;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.fail;

public class ResultPrinterTest {

    @Test
    public void resultPrinterTest() {
        try {
            PuzzleReader puzzleReader = new PuzzleReader("src/test/resources/test.txt");
            String[] words = puzzleReader.parseHeader();
            char[][] data = puzzleReader.getPuzzleData();
            Puzzle puzzle = new Puzzle(data);
            ResultPrinter resultPrinter = new ResultPrinter();
            String results = resultPrinter.getResults(words, puzzle);
            String expectedResult = "CASE: (12,10),(11,11),(10,12),(9,13)\n" +
                    "HOUSE: (0,11),(1,11),(2,11),(3,11),(4,11)\n" +
                    "LAMP: (2,2),(2,3),(2,4),(2,5)\n" +
                    "MARKER: (9,5),(10,4),(11,3),(12,2),(13,1),(14,0)\n" +
                    "PHONE: (9,0),(10,1),(11,2),(12,3),(13,4)\n" +
                    "PRINTER: (12,9),(11,8),(10,7),(9,6),(8,5),(7,4),(6,3)\n" +
                    "ROUTER: (8,14),(8,13),(8,12),(8,11),(8,10),(8,9)";
            assert (results.equals(expectedResult));
        }catch(IOException e){
            fail();
        }
    }
}
