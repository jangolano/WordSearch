package org.jangolano.wordsearch;

import org.junit.Test;

public class PuzzleReaderTest {

    @Test
    public void readPuzzleHeader(){
        PuzzleReader puzzleReader = new PuzzleReader("test.txt");
        String [] words = puzzleReader.parseHeader();
        assert(words.length==7);
        assert(words[0].equals("CASE"));
        assert(words[1].equals("HOUSE"));
        assert(words[2].equals("LAMP"));
        assert(words[3].equals("MARKER"));
        assert(words[4].equals("PHONE"));
        assert(words[5].equals("PRINTER"));
        assert(words[6].equals("ROUTER"));
    }

}
