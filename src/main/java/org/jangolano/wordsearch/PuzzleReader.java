package org.jangolano.wordsearch;

import java.io.*;
import java.util.ArrayList;

public class PuzzleReader {

    private String fileName;

    private ArrayList<String> rows;
    PuzzleReader(String fileName) throws IOException{
        this.fileName = fileName;
        this.rows = parsePuzzle();
    }

    //Method to read the puzzle and parse into rows
    private ArrayList<String> parsePuzzle() throws IOException {
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
    public String [] parseHeader() {
        String header = rows.get(0);
        return header.split(",");
    }

    //Method to get the puzzle data
    public char [][] getPuzzleData(){
        char [][] results = new char[rows.size()-1][];
        for(int row =1;row<rows.size();row++){
             String [] rowData = rows.get(row).split(",");
             results[row-1]=getCharArray(rowData);
        }
        return results;
    }

    //Method to convert String array to Character Data.
    private char [] getCharArray(String[] rowData) {
        String s ="";
        for(String n:rowData){
            s+=n;
        }
        return s.toCharArray();
    }

}
