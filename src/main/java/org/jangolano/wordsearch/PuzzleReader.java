package org.jangolano.wordsearch;

import java.io.*;
import java.util.ArrayList;

public class PuzzleReader {

    String fileName;

    PuzzleReader(String fileName){
        this.fileName = fileName;
    }

    //Method to read the puzzle and parse into rows
    public ArrayList<String> parsePuzzle() throws IOException, FileNotFoundException {
        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList<String> rows = new ArrayList<>();
        String row;
        while((row = bufferedReader.readLine())!=null){
            rows.add(row);
        }
        return rows;
    }


}
