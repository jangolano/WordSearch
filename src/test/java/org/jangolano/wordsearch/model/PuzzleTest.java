package org.jangolano.wordsearch.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PuzzleTest {

    @Test
    public void getValueAt(){
        char [][] data = {
            { 'A', 'B', 'C', 'D'},
            { 'E', 'F', 'G', 'H'},
            { 'I', 'J', 'K', 'L'},
            { 'M', 'N', 'O', 'P'}
        };
        Puzzle puzzle = new Puzzle(data);
        char value  = puzzle.getValueAt(3, 2);
        assert(value =='O');
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
        puzzle.setValueAt(3, 2, 'A');
        char value = puzzle.getValueAt(3,2);
        assert(value =='A');
    }

    @Test
    public void getInstancesOf(){
        char [][] data = {
                { 'A', 'B', 'C', 'D'},
                { 'E', 'F', 'G', 'H'},
                { 'I', 'C', 'K', 'L'},
                { 'M', 'N', 'O', 'C'}
        };
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> instances = puzzle.getInstancesOf('C');
        assert(instances.size()==3);
        assert(instances.contains(new Point(0,2)));
        assert(instances.contains(new Point(2, 1)));
        assert(instances.contains(new Point(3,3)));

    }
}