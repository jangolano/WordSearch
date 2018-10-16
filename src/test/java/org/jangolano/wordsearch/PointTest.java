package org.jangolano.wordsearch;

import org.jangolano.wordsearch.Point;
import org.junit.Before;
import org.junit.Test;

public class PointTest {

    Point point;
    @Before
    public void setPointForTests(){
        point = new Point(1,2);
    }

    @Test
    public void testGetRight(){
        Point right  = point.getRight(point);
        assert(point.getColumn()+1==right.getColumn());
    }

    @Test
    public void testGetLeft(){
        Point left  = point.getLeft(point);
        assert(point.getColumn()-1==left.getColumn());
    }

    @Test
    public void testGetAbove(){
        Point above  = point.getAbove(point);
        assert(point.getRow()-1==above.getRow());
    }

    @Test
    public void testGetBelow(){
        Point below  = point.getBelow(point);
        assert(point.getRow()+1==below.getRow());
    }

    @Test
    public void testGetTopRight(){
        Point topRight = point.getTopRight(point);
        assert(point.row-1==topRight.row);
        assert(point.column+1==topRight.column);
    }

    @Test
    public void testGetTopLeft(){
        Point topLeft = point.getTopLeft(point);
        assert(point.row-1==topLeft.row);
        assert(point.column-1==topLeft.column);
    }

    @Test
    public void testGetBottomRight(){
        Point bottomrRight = point.getBottomRight(point);
        assert(point.row+1==bottomrRight.row);
        assert(point.column+1==bottomrRight.column);
    }

    @Test
    public void testGetBottomLeft(){
        Point bottomLeft = point.getBottomLeft(point);
        assert(point.row+1==bottomLeft.row);
        assert(point.column-1==bottomLeft.column);
    }
}
