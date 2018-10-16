package org.jangolano.wordsearch;

import org.jangolano.wordsearch.Point;
import org.jangolano.wordsearch.Puzzle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PuzzleTest {

    final char NULL_VALUE = '\u0000';  //The default null value for a character.

    char data [][];  //2D Array used to hold test data.

    Puzzle puzzle;  //Instance of the puzzle object that can be used within the tests.

    @Before
    public void setData(){
        data = new char[][]{
                { 'A', 'B', 'C', 'D'},
                { 'E', 'F', 'G', 'H'},
                { 'I', 'J', 'K', 'L'},
                { 'M', 'N', 'O', 'P'}
        };
        puzzle = new Puzzle(data);
    }

    @Test
    public void getValueAt(){
        Point point = new Point(3,2);
        char value  = puzzle.getValueAt(point);
        assert(value =='O');
    }

    @Test
    public void getValueAtOutOfBounds(){
        Point point = new Point(10,5);
        char value = puzzle.getValueAt(point);
        assert(value==NULL_VALUE);
    }

    @Test
    public void setValueAt(){
        Point point = new Point(3,2);
        puzzle.setValueAt(point, 'A');
        char value = puzzle.getValueAt(point);
        assert(value =='A');
    }

    @Test
    public void setValueAtOutOfBounds(){
        Point point = new Point(10,13);
        puzzle.setValueAt(point, 'A');
        char value = puzzle.getValueAt(point);
        assert(value ==NULL_VALUE);
    }


    @Test //Vertical
    public void searchPuzzleForWordsDHL(){
        ArrayList<Point> locations = puzzle.searchPuzzle("DHL");
        assert(locations.size()==3);
        assert(locations.get(0).equals(new Point(0,3)));
        assert(locations.get(1).equals(new Point(1,3)));
        assert(locations.get(2).equals(new Point(2,3)));
    }

    @Test //Horizontal
    public void searchPuzzleForWordsNO(){
        ArrayList<Point> locations = puzzle.searchPuzzle("NO");
        assert(locations.size()==2);
        assert(locations.get(0).equals(new Point(3,1)));
        assert(locations.get(1).equals(new Point(3,2)));
    }

    @Test //Single Letter
    public void searchPuzzleSingleLetter(){
        ArrayList<Point> locations = puzzle.searchPuzzle("A");
        assert(locations.size()==1);
        assert(locations.get(0).equals(new Point(0,0)));
    }

    @Test //Vertical Backwards
    public void searchPuzzleForWordsNJFB(){
        ArrayList<Point> locations = puzzle.searchPuzzle("NJFB");
        assert(locations.size()==4);
        assert(locations.get(0).equals(new Point(3, 1)));
        assert(locations.get(1).equals(new Point(2, 1)));
        assert(locations.get(2).equals(new Point(1, 1)));
        assert(locations.get(3).equals(new Point(0, 1)));
    }

    @Test //Horizontal Backwards
    public void searchPuzzleForWordsPON(){
        ArrayList<Point> locations = puzzle.searchPuzzle("PON");
        assert(locations.size()==3);
        assert(locations.get(0).equals(new Point(3,3)));
        assert(locations.get(1).equals(new Point(3,2)));
        assert(locations.get(2).equals(new Point(3,1)));
    }

    @Test //Top Right to Bottom Left
    public void searchPuzzleForWordsJM(){
        ArrayList<Point> locations = puzzle.searchPuzzle("JM");
        assert(locations.size()==2);
        assert(locations.get(0).equals(new Point(2,1)));
        assert(locations.get(1).equals(new Point(3,0)));
    }

    @Test  //Top Left to Bottom Right
    public void searchPuzzleForWordsEJO(){
        ArrayList<Point> locations = puzzle.searchPuzzle("EJO");
        assert(locations.size()==3);
        assert(locations.get(0).equals(new Point(1,0)));
        assert(locations.get(1).equals(new Point(2,1)));
        assert(locations.get(2).equals(new Point(3,2)));
    }

    @Test //Bottom Left to Top Right
    public void searchPuzzleForWordsEb(){
        ArrayList<Point> locations = puzzle.searchPuzzle("EB");
        assert(locations.size()==2);
        assert(locations.get(0).equals(new Point(1,0)));
        assert(locations.get(1).equals(new Point(0,1)));
    }

    @Test //Bottom Right to Top Left
    public void searchPuzzleForWordsPKFA(){
        ArrayList<Point> locations = puzzle.searchPuzzle("PKFA");
        assert(locations.size()==4);
        assert(locations.get(0).equals(new Point(3,3)));
        assert(locations.get(1).equals(new Point(2,2)));
        assert(locations.get(2).equals(new Point(1,1)));
        assert(locations.get(3).equals(new Point(0,0)));
    }

    @Test //Look for value that that isn't in the puzzle
    public void searchPuzzleForWordsInvalid(){
        ArrayList<Point> locations = puzzle.searchPuzzle("INVALID");
        assert(locations.size()==0);
    }

}