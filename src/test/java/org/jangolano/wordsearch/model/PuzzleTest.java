package org.jangolano.wordsearch.model;

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

    @Test
    public void searchHorizontal(){
        ArrayList<Point> locations =puzzle.searchHorizontal("FGH");
        assert(locations.size()==3);
        assert(locations.contains(new Point(1,1)));
        assert(locations.contains(new Point(1, 2)));
        assert(locations.contains(new Point(1,3)));
    }

    @Test
    public void searchHorizontalNotFound(){
        ArrayList<Point> locations =puzzle.searchHorizontal("FGHI");
        assert(locations.size()==0);
    }

    @Test
    public void searchHorizontalBackwards(){
        ArrayList<Point> locations =puzzle.searchHorizontalBackwards("LKJI");
        assert(locations.size()==4);
        assert(locations.contains(new Point(2,3)));
        assert(locations.contains(new Point(2, 2)));
        assert(locations.contains(new Point(2,1)));
        assert(locations.contains(new Point(2,0)));
    }

    @Test
    public void searchHorizontalBackwardsNotFound(){
        ArrayList<Point> locations =puzzle.searchHorizontalBackwards("FGHI");
        assert(locations.size()==0);
    }

    @Test
    public void searchVertical(){
        ArrayList<Point> locations = puzzle.searchVertical("CGK");
        assert(locations.size()==3);
        assert(locations.contains(new Point(0,2)));
        assert(locations.contains(new Point(1,2)));
        assert(locations.contains(new Point(2,2)));
    }

    @Test
    public void searchVerticalNotFound(){
        ArrayList<Point> locations = puzzle.searchVertical("KGC");
        assert(locations.size()==0);
    }

    @Test
    public void searchVerticalBackwards(){
        ArrayList<Point> locations = puzzle.searchVerticalBackwards("KGC");
        assert(locations.size()==3);
        assert(locations.contains(new Point(2,2)));
        assert(locations.contains(new Point(1,2)));
        assert(locations.contains(new Point(0,2)));
    }

    @Test
    public void searchDiagnalTopRight(){
        ArrayList<Point> locations = puzzle.searchDiagnalTopRight("NKH");
        assert(locations.size()==3);
        assert(locations.contains(new Point(3,1)));
        assert(locations.contains(new Point(2,2)));
        assert(locations.contains(new Point(1,3)));
    }

    @Test
    public void searchDiagnalTopRightNotFound(){
        ArrayList<Point> locations = puzzle.searchDiagnalTopRight("HKN");
        assert(locations.size()==0);
    }

    @Test
    public void searchDiagnalTopLeft(){
        ArrayList<Point> locations = puzzle.searchDiagnalTopLeft("KFA");
        assert(locations.size()==3);
        assert(locations.contains(new Point(2,2)));
        assert(locations.contains(new Point(1,1)));
        assert(locations.contains(new Point(0,0)));
    }


    @Test
    public void searchDiagnalTopLeftNotFound(){
        ArrayList<Point> locations = puzzle.searchDiagnalTopLeft("AFK");
        assert(locations.size()==0);
    }


    @Test
    public void searchDiagnalBottomRight(){
        ArrayList<Point> locations = puzzle.searchDiagnalBottomRight("AFK");
        assert(locations.size()==3);
        assert(locations.contains(new Point(0,0)));
        assert(locations.contains(new Point(1,1)));
        assert(locations.contains(new Point(2,2)));

    }

    @Test
    public void searchDiagnalBottomRightNotFound(){
        ArrayList<Point> locations = puzzle.searchDiagnalBottomRight("KFA");
        assert(locations.size()==0);
    }

    @Test
    public void searchDiangalBottomLeft(){
        ArrayList<Point> locations = puzzle.searchDiagnalBottomLeft("GJM");
        assert(locations.size()==3);
        assert(locations.contains(new Point(1,2)));
        assert(locations.contains(new Point(2,1)));
        assert(locations.contains(new Point(3,0)));
    }


    @Test
    public void searchDiangalBottomLeftNotFound(){
        ArrayList<Point> locations = puzzle.searchDiagnalBottomLeft("MJG");
        assert(locations.size()==0);
    }


    @Test //Vertical
    public void searchPuzzleForWordsDHL(){
        ArrayList<Point> locations = puzzle.searchPuzzle("DHL");
        assert(locations.size()==3);
    }

    @Test //Horizontal
    public void searchPuzzleForWordsNO(){
        ArrayList<Point> locations = puzzle.searchPuzzle("NO");
        assert(locations.size()==2);
    }

    @Test //Single Letter
    public void searchPuzzleSingleLetter(){
        ArrayList<Point> locations = puzzle.searchPuzzle("A");
        assert(locations.size()==1);
    }

    @Test //Vertical Backwards
    public void searchPuzzleForWordsNJFB(){
        ArrayList<Point> locations = puzzle.searchPuzzle("NJFB");
        assert(locations.size()==4);
    }

}