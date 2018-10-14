package org.jangolano.wordsearch.model;

public class Puzzle {

    char [][] data;
    Puzzle(char [][] data){
        this.data = data;
    }

    char getValueAt(int row, int column){
       return data[row][column];
    }

}
