package org.jangolano.wordsearch.model;


import org.junit.Test;

public class PointTest {

    @Test
    public void testGetRight(){
        Point point = new Point(1,2);
        Point right  = point.getRight(point);
        assert(point.getColumn()+1==right.getColumn());
    }
}
