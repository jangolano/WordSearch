package org.jangolano.wordsearch.model;

import java.util.ArrayList;

public class Puzzle {

    char [][] data;
    Puzzle(char [][] data){
        this.data = data;
    }

    //Method get the character at location in the array
    char getValueAt(int row, int column){
       return data[row][column];
    }

    //Method to set the value at a location in the array.
    void setValueAt(int row, int column, char value){
        data[row][column] = value;
    }

    //Method to get locations of a value in the array.
    ArrayList<Point> getInstancesOf(char value){
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
