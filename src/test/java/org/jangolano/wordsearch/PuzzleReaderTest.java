package org.jangolano.wordsearch;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PuzzleReaderTest {

    @Test
    public void parsePuzzleTest(){
        PuzzleReader puzzleReader = new PuzzleReader("test.txt");
        ArrayList<String> rows = puzzleReader.parsePuzzle();
        assert(rows.size()==16);
        assert(rows.get(0).equals("CASE,HOUSE,LAMP,MARKER,PHONE,PRINTER,ROUTER"));
        assert(rows.get(1).equals("P,Y,K,G,C,O,U,V,F,P,X,X,M,X,R"));
        assert(rows.get(2).equals("H,O,Y,D,U,N,U,R,H,Z,H,Z,W,E,U"));
        assert(rows.get(3).equals("P,X,L,T,C,Y,Q,R,M,V,F,O,K,O,Y"));
        assert(rows.get(4).equals("C,O,A,F,K,U,R,F,B,K,H,R,N,T,X"));
        assert(rows.get(5).equals("T,S,M,B,I,V,Z,E,D,P,A,R,P,E,A"));
        assert(rows.get(6).equals("Y,U,P,Z,A,W,U,A,T,M,B,S,Q,S,O"));
        assert(rows.get(7).equals("R,U,K,F,W,Z,V,I,T,N,W,S,E,T,F"));
        assert(rows.get(8).equals("P,U,F,F,V,V,K,A,R,V,I,Z,P,B,R"));
        assert(rows.get(9).equals("T,U,F,F,J,R,S,H,M,E,S,R,A,J,U"));
        assert(rows.get(10).equals("O,A,G,R,J,I,L,D,R,G,F,I,P,Z,L"));
        assert(rows.get(11).equals("N,V,N,Y,Y,B,O,C,E,Y,C,T,C,T,L"));
        assert(rows.get(12).equals("H,O,U,S,E,H,E,N,T,G,P,A,D,G,M"));
        assert(rows.get(13).equals("D,I,T,C,C,A,X,B,U,B,S,U,X,L,E"));
        assert(rows.get(14).equals("G,S,V,U,D,X,D,Q,O,E,Q,O,M,O,C"));
        assert(rows.get(15).equals("T,M,F,Q,W,M,P,I,R,I,P,Z,O,W,I"));
    }

    @Test(expected = FileNotFoundException.class)
    public void parsePuzzleNotFound(){
        PuzzleReader puzzleReader = new PuzzleReader("invalid.txt");
        puzzleReader.parsePuzzle();
    }

}
