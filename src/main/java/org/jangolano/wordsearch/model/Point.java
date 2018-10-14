package org.jangolano.wordsearch.model;

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
    public Point getRight(Point point){
        return new Point(point.row, point.column+1);
    }


    //Get the point to the left
    public Point getLeft(Point point){
        return point;
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
