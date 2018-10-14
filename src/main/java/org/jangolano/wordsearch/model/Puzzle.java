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
        return new ArrayList<Point>();
    }

}
