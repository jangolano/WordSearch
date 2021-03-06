/**
 * This class represents a point (x, y) on the puzzle.
 * This class can also calulate the (x,y) of a point to the left, right
 * above, below, top right, bottom right, top left and bottom left of a point.
 */
package org.jangolano.wordsearch;

import java.util.Objects;

public class Point {
    int row;
    int column;

    Point(int row, int column){
        this.row = row;
        this.column = column;
    }

    int getRow(){
        return row;
    }

    int getColumn(){
        return column;
    }

    //Get the point to the right
    public static Point getRight(Point point){
        return new Point(point.row, point.column+1);
    }


    //Get the point to the left
    public static Point getLeft(Point point){
        return new Point(point.row, point.column-1);
    }

    //Get the point above
    public static Point getAbove(Point point){
        return new Point(point.row-1, point.column);
    }

    //Get the point below
    public static Point getBelow(Point point){
        return new Point(point.row+1, point.column);
    }

    //Get the point to the topright
    public static Point getTopRight(Point point){
        return new Point(point.row-1, point.column+1);
    }

    //Get the point to the topleft
    public static Point getTopLeft(Point point){
        return new Point(point.row-1, point.column-1);
    }

    //Get the point to the bottomRight
    public static Point getBottomRight(Point point){
        return new Point(point.row+1, point.column+1);
    }


    //Get the point to the bottomLeft
    public static Point getBottomLeft(Point point){
        return new Point(point.row+1, point.column-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                column == point.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
