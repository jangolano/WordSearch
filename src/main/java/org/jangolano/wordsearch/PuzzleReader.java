package org.jangolano.wordsearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    //Method to parse out the header
    public ArrayList<String> parseHeader() throws IOException{
        ArrayList<String> rows = parsePuzzle();
        String header = rows.get(0);
        String [] words = header.split(",");
        return new ArrayList(Arrays.asList(words));
    }

    //Method to get the puzzle data
    public char [][] getPuzzleData() throws IOException{
        char [][] data = {{'A'},{'B'}};
        return data;
    }

}
