package org.jangolano.wordsearch;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleReaderTest {

    @Test
    public void parsePuzzleTest() throws IOException {
        PuzzleReader puzzleReader = new PuzzleReader("src/test/resources/test.txt");
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
    public void parsePuzzleNotFound()throws IOException{
        PuzzleReader puzzleReader = new PuzzleReader("invalid.txt");
        puzzleReader.parsePuzzle();
    }

    @Test
    public void parseHeaderTest() throws IOException{
        PuzzleReader puzzleReader = new PuzzleReader("src/test/resources/test.txt");
        String [] header = puzzleReader.parseHeader();
        assert(header.length==7);
        assert(header[0].equals("CASE"));
        assert(header[1].equals("HOUSE"));
        assert(header[2].equals("LAMP"));
        assert(header[3].equals("MARKER"));
        assert(header[4].equals("PHONE"));
        assert(header[5].equals("PRINTER"));
        assert(header[6].equals("ROUTER"));
    }

    /* This test is very comprehensive, testing to make sure that each value in the puzzle
     * is read correctly.  A much smaller test could be written to test that no row matches
     * another row and that the puzzle is 15 x 15 square.  Values could also be spot checked
     * across the data.  While that would bring a high degree of confidence, it would check
     * every value for a match.
     */
    @Test
    public void getPuzzleDataTest() throws IOException{
        PuzzleReader puzzleReader = new PuzzleReader("src/test/resources/test.txt");
        char [][] data = puzzleReader.getPuzzleData();
        //Check to make sure there are 15 rows and columns
        assert(data.length==15);
        for(int row = 0; row<data.length;row++){
            assert(data[row].length==15);
        }
        //Check the values in each row.
        char [] row0 = {'P','Y','K','G','C','O','U','V','F','P','X','X','M','X','R'};
        assert(Arrays.equals(data[0], row0));
        char [] row1= {'H','O','Y','D','U','N','U','R','H','Z','H','Z','W','E','U'};
        assert(Arrays.equals(data[1], row1));
        char [] row2= {'P','X','L','T','C','Y','Q','R','M','V','F','O','K','O','Y'};
        assert(Arrays.equals(data[2], row2));
        char [] row3= {'C','O','A','F','K','U','R','F','B','K','H','R','N','T','X'};
        assert(Arrays.equals(data[3], row3));
        char [] row4= {'T','S','M','B','I','V','Z','E','D','P','A','R','P','E','A'};
        assert(Arrays.equals(data[4], row4));
        char [] row5= {'Y','U','P','Z','A','W','U','A','T','M','B','S','Q','S','O'};
        assert(Arrays.equals(data[5], row5));
        char [] row6= {'R','U','K','F','W','Z','V','I','T','N','W','S','E','T','F'};
        assert(Arrays.equals(data[6], row6));
        char [] row7= {'P','U','F','F','V','V','K','A','R','V','I','Z','P','B','R'};
        assert(Arrays.equals(data[7], row7));
        char [] row8= {'T','U','F','F','J','R','S','H','M','E','S','R','A','J','U'};
        assert(Arrays.equals(data[8], row8));
        char [] row9= {'O','A','G','R','J','I','L','D','R','G','F','I','P','Z','L'};
        assert(Arrays.equals(data[9], row9));
        char [] row10= {'N','V','N','Y','Y','B','O','C','E','Y','C','T','C','T','L'};
        assert(Arrays.equals(data[10], row10));
        char [] row11= {'H','O','U','S','E','H','E','N','T','G','P','A','D','G','M'};
        assert(Arrays.equals(data[11], row11));
        char [] row12= {'D','I','T','C','C','A','X','B','U','B','S','U','X','L','E'};
        assert(Arrays.equals(data[12], row12));
        char [] row13= {'G','S','V','U','D','X','D','Q','O','E','Q','O','M','O','C'};
        assert(Arrays.equals(data[13], row13));
        char [] row14= {'T','M','F','Q','W','M','P','I','R','I','P','Z','O','W','I'};
        assert(Arrays.equals(data[14], row14));
    }
}
