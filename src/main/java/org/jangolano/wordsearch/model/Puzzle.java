package org.jangolano.wordsearch.model;

import java.util.ArrayList;

public class Puzzle {

    char [][] data;
    Puzzle(char [][] data){
        this.data = data;
    }

    //Method get the character at location in the array
    char getValueAt(Point point){
       return data[point.getRow()][point.getColumn()];
    }

    //Method to set the value at a location in the array.
    void setValueAt(Point point, char value){
        data[point.getRow()][point.getColumn()] = value;
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

}
