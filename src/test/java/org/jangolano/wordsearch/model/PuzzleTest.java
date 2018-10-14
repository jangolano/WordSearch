package org.jangolano.wordsearch.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PuzzleTest {

    final char NULL_VALUE = '\u0000';
    char data [][];

    @Before
    public void setData(){
        data = new char[][]{
                { 'A', 'B', 'C', 'D'},
                { 'E', 'F', 'G', 'H'},
                { 'I', 'J', 'K', 'L'},
                { 'M', 'N', 'O', 'P'}
        };
    }

    @Test
    public void getValueAt(){
        Puzzle puzzle = new Puzzle(data);
        Point point = new Point(3,2);
        char value  = puzzle.getValueAt(point);
        assert(value =='O');
    }

    @Test
    public void getValueAtOutOfBounds(){
        Puzzle puzzle = new Puzzle(data);
        Point point = new Point(10,5);
        char value = puzzle.getValueAt(point);
        assert(value==NULL_VALUE);
    }

    @Test
    public void setValueAt(){
        Puzzle puzzle = new Puzzle(data);
        Point point = new Point(3,2);
        puzzle.setValueAt(point, 'A');
        char value = puzzle.getValueAt(point);
        assert(value =='A');
    }

    @Test
    public void setValueAtOutOfBounds(){
        Puzzle puzzle = new Puzzle(data);
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
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations =puzzle.searchHorizontal("FGH");
        assert(locations.size()==3);
        assert(locations.contains(new Point(1,1)));
        assert(locations.contains(new Point(1, 2)));
        assert(locations.contains(new Point(1,3)));
    }

    @Test
    public void searchHorizontalFail(){
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations =puzzle.searchHorizontal("FGHI");
        assert(locations.size()==0);
    }

    @Test
    public void searchHorizontalBackwards(){
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations =puzzle.searchHorizontalBackwards("LKJI");
        assert(locations.size()==4);
        assert(locations.contains(new Point(2,3)));
        assert(locations.contains(new Point(2, 2)));
        assert(locations.contains(new Point(2,1)));
        assert(locations.contains(new Point(2,0)));
    }

    @Test
    public void searchHorizontalBackwardsFail(){
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations =puzzle.searchHorizontalBackwards("FGHI");
        assert(locations.size()==0);
    }

    @Test
    public void searchVertical(){
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations = puzzle.searchVertical("CGK");
        assert(locations.size()==3);
        assert(locations.contains(new Point(0,2)));
        assert(locations.contains(new Point(1,2)));
        assert(locations.contains(new Point(2,2)));
    }

    @Test
    public void searchVerticalFail(){
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations = puzzle.searchVertical("KGC");
        assert(locations.size()==0);
    }

    @Test
    public void searchVerticalBackwards(){
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations = puzzle.searchVerticalBackwards("KGC");
        assert(locations.size()==3);
        assert(locations.contains(new Point(2,2)));
        assert(locations.contains(new Point(1,2)));
        assert(locations.contains(new Point(0,2)));
    }

    @Test
    public void searchDiagnalTopRight(){
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations = puzzle.searchDiagnalTopRight("NKH");
        assert(locations.size()==3);
        assert(locations.contains(new Point(3,1)));
        assert(locations.contains(new Point(2,2)));
        assert(locations.contains(new Point(1,3)));
    }

    @Test
    public void searchDiagnolTopRightNotFound(){
        Puzzle puzzle = new Puzzle(data);
        ArrayList<Point> locations = puzzle.searchDiagnalTopRight("HKN");
        assert(locations.size()==0);

    }

}