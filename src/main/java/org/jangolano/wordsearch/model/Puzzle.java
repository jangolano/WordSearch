package org.jangolano.wordsearch.model;

import java.util.ArrayList;

public class Puzzle {

    char [][] data;
    final char NULL_VALUE = '\u0000';

    Puzzle(char [][] data){
        this.data = data;
    }

    //Method get the character at location in the array
    char getValueAt(Point point){
        try {
            return data[point.getRow()][point.getColumn()];
        }catch(IndexOutOfBoundsException e){
            return NULL_VALUE;
        }
    }

    //Method to set the value at a location in the array.
    void setValueAt(Point point, char value){
        try {
            data[point.getRow()][point.getColumn()] = value;
        }catch(IndexOutOfBoundsException e){

        }
    }

    //Method to get locations of a value in the array.
    ArrayList<Point> getLocationsOf(char value){
        ArrayList<Point> instances = new ArrayList<Point>();
        for (int row = 0; row<data.length; row++){

            for(int col = 0; col<data[row].length ;col++){
                   if(data[row][col]==value){
                       Point point = new Point(row, col);
                       instances.add(point);
                   }
            }
        }
        return instances;
    }

    //Find a character and then search to the right for the rest of the values with the word.
    ArrayList<Point> searchHorizontal(String word){
        return new ArrayList<Point>();
    }


}
