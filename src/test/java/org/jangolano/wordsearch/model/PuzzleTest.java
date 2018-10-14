package org.jangolano.wordsearch.model;

import org.junit.Test;

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


}