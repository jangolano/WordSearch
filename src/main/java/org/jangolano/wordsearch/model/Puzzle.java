package org.jangolano.wordsearch.model;

import java.util.ArrayList;
import java.util.function.Function;

public class Puzzle {

    char [][] data;
    final private char NULL_VALUE = '\u0000';

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
        ArrayList<Point> instances = new ArrayList<>();
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


    //Method to get the all the locations of the first character of a string.
    private ArrayList<Point> getInitalLocations(char aChar) {
        return getLocationsOf(aChar);
    }


    //Search for values within the puzzle
    private ArrayList<Point> findValues(String word, Function<Point, Point > f){
        char [] chars = word.toCharArray();
        ArrayList<Point> locations = getInitalLocations(chars[0]);

        for(Point point:locations){
            ArrayList<Point> results = new ArrayList<>();
            results.add(point);
            Point nextPoint = point ;
            for(int index = 1; index<chars.length; index++){
                nextPoint = f.apply(nextPoint);
                if(getValueAt(nextPoint)==chars[index]){
                    results.add(nextPoint);
                }
            }

            //If all the letters are found return
            if(results.size()==chars.length){
                return results;
            }
        }
        return new ArrayList<>();
    }


    //Find a character and then search to the right for the rest of the values with the word.
    ArrayList<Point> searchHorizontal(String word){
        return findValues(word, Point::getRight);
    }

    //Find a character and then search to the left.
    ArrayList<Point> searchHorizontalBackwards(String word){
        return findValues(word, Point::getLeft);
    }

    //Find a character and then search down
    ArrayList<Point> searchVertical(String word){
        return findValues(word, Point::getBelow);
    }

    //Find a character and then search up
    ArrayList<Point> searchVerticalBackwards(String word){
        return findValues(word, Point::getAbove);
    }

    //Find a character and then search diagnal to the top right
    ArrayList<Point> searchDiagnalTopRight(String word){
        return findValues(word, Point::getTopRight);
    }

    //Find a character and then search diagnal to the top left
    ArrayList<Point> searchDiagnalTopLeft(String word){
        return findValues(word, Point::getTopLeft);
    }

    //Find a character and then search diagnal to the bottom right
    ArrayList<Point> searchDiagnalBottomRight(String word){
        return findValues(word, Point::getBottomRight);
    }

    //Find a character and then search diangol to the bottom left
    ArrayList<Point> searchDiagnalBottomLeft(String word){
        return findValues(word, Point::getBottomLeft);
    }

    //Search the whole puzzle for a word
    ArrayList<Point> searchPuzzle(String word){
        ArrayList<Point> result = new ArrayList<>();
        return result;
    }
}
