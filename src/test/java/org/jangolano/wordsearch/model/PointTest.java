package org.jangolano.wordsearch.model;


import org.junit.Test;

public class PointTest {

    @Test
    public void testGetRight(){
        Point point = new Point(1,2);
        Point right  = point.getRight(point);
        assert(point.getColumn()+1==right.getColumn());
    }

    @Test
    public void testGetLeft(){
        Point point = new Point(1,2);
        Point left  = point.getLeft(point);
        assert(point.getColumn()-1==left.getColumn());
    }

    @Test
    public void testGetAbove(){
        Point point = new Point(1,2);
        Point above  = point.getAbove(point);
        assert(point.getRow()==above.getRow()-1);
    }
}
