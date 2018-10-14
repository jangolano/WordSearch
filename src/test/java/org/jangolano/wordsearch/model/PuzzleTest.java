package org.jangolano.wordsearch.model;

import org.junit.Test;

import java.util.ArrayList;

public class PuzzleTest {

    final char NULL_VALUE = '\u0000';
    @Test
    public void getValueAt(){
        char [][] data = {
            { 'A', 'B', 'C', 'D'},
            { 'E', 'F', 'G', 'H'},
            { 'I', 'J', 'K', 'L'},
            { 'M', 'N', 'O', 'P'}
        };
        Puzzle puzzle = new Puzzle(data);
        Point point = new Point(3,2);
        char value  = puzzle.getValueAt(point);
        assert(value =='O');
    }

    @Test
    public void getValueAtOutOfBounds(){
        char [][] data = {
                { 'A', 'B', 'C', 'D'},
                { 'E', 'F', 'G', 'H'},
                { 'I', 'J', 'K', 'L'},
                { 'M', 'N', 'O', 'P'}
        };
        Puzzle puzzle = new Puzzle(data);
        Point point = new Point(10,5);
        char value = puzzle.getValueAt(point);
        assert(value==NULL_VALUE);
    }

    @Test
    public void setValueAt(){
        char [][] data = {
                { 'A', 'B', 'C', 'D'},
                { 'E', 'F', 'G', 'H'},
                { 'I', 'J', 'K', 'L'},
                { 'M', 'N', 'O', 'P'}
        };
        Puzzle puzzle = new Puzzle(data);
        Point point = new Point(3,2);
        puzzle.setValueAt(point, 'A');
        char value = puzzle.getValueAt(point);
        assert(value =='A');
    }


    @Test
    public void getLocationsOf(){
        char [][] data = {
                { 'A', 'B', 'C', 'D'},
                { 'E', 'F', 'G', 'H'},
                { 'I', 'C', 'K', 'L'},
                { 'M', 'N', 'O', 'C'}
        };
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> instances = puzzle.getLocationsOf('C');
        assert(instances.size()==3);
        assert(instances.contains(new Point(0,2)));
        assert(instances.contains(new Point(2, 1)));
        assert(instances.contains(new Point(3,3)));
    }

}