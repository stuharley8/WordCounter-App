package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wordCounter.WordCounter;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;


/**
 * Tester class for WordCounter application
 */
public class JUnitTest {

    /**
     * Tests for the number of lines in Mixed_Invalid_with_Valid.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void mixedValidInvalidNumberLines() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\Mixed_Invalid_with_Valid.txt");
        try {
            wc.load(file.toPath());
            int expected = 5;
            int actual = wc.getNumLines();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of lines in Mixed_Invalid_with_Valid.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void mixedValidInvalidValidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\Mixed_Invalid_with_Valid.txt");
        try {
            wc.load(file.toPath());
            int expected = 5;
            int actual = wc.getNumValidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of lines in Mixed_Invalid_with_Valid.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void mixedValidInvalidInvalidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\Mixed_Invalid_with_Valid.txt");
        try {
            wc.load(file.toPath());
            int expected = 11;
            int actual = wc.getNumInvalidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of lines in morewords.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void moreWordsLines() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\morewords.txt");
        try {
            wc.load(file.toPath());
            int expected = 13;
            int actual = wc.getNumLines();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of Valid words in morewords.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void moreWordsValidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\morewords.txt");
        try {
            wc.load(file.toPath());
            int expected = 4;
            int actual = wc.getNumValidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of Invalid words in morewords.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void moreWordsInvalidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\morewords.txt");
        try {
            wc.load(file.toPath());
            int expected = 3;
            int actual = wc.getNumInvalidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of lines in Valid_Words_and_Skip_A_Line.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void validWordsSkipLineLines() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\Valid_Words_and_Skip_A_Line.txt");
        try {
            wc.load(file.toPath());
            int expected = 5;
            int actual = wc.getNumLines();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of Valid words in Valid_Words_and_Skip_A_Line.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void validWordsSkipLineValid() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\Valid_Words_and_Skip_A_Line.txt");
        try {
            wc.load(file.toPath());
            int expected = 7;
            int actual = wc.getNumValidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of Invalid Words in Valid_Words_and_Skip_A_Line.txt.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void validWordsSkipLineInvalid() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\Valid_Words_and_Skip_A_Line.txt");
        try {
            wc.load(file.toPath());
            int expected = 0;
            int actual = wc.getNumInvalidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of lines in words2014.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void words2014Lines() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\words2014.txt");
        try {
            wc.load(file.toPath());
            int expected = 3;
            int actual = wc.getNumLines();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of Valid words in words2014.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void words2014Valid() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\words2014.txt");
        try {
            wc.load(file.toPath());
            int expected = 16;
            int actual = wc.getNumValidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for the number of invalid words in words2014.txt
     *
     * @author Joey Rundlett
     */
    @Test
    public void words2014Invalid() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\words2014.txt");
        try {
            wc.load(file.toPath());
            int expected = 7;
            int actual = wc.getNumInvalidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException e){
            fail();
        }
    }

    /**
     * Tests for number of lines in 1word.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void oneWordNumberLines() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\1 word.txt");
        try {
            wc.load(file.toPath());
            int expected = 1;
            int actual = wc.getNumLines();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe){
            fail();
        }
    }

    /**
     * Tests for number of valid words in 1word.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void oneWordValidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\1 word.txt");
        try {
            wc.load(file.toPath());
            int expected = 1;
            int actual = wc.getNumValidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe){
            fail();
        }
    }

    /**
     * Tests for number of invalid words in 1word.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void oneWordInvalidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\1 word.txt");
        try {
            wc.load(file.toPath());
            int expected = 0;
            int actual = wc.getNumInvalidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe){
            fail();
        }
    }

    /**
     * Tests for number of lines in blanks.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void blanksNumberLines() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\blanks.txt");
        try {
            wc.load(file.toPath());
            int expected = 6;
            int actual = wc.getNumLines();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe){
            fail();
        }
    }

    /**
     * Tests for number of valid words in blanks.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void blanksValidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\blanks.txt");
        try {
            wc.load(file.toPath());
            int expected = 0;
            int actual = wc.getNumValidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe){
            fail();
        }
    }

    /**
     * Tests for number of invalid words in blanks.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void blanksInvalidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\blanks.txt");
        try {
            wc.load(file.toPath());
            int expected = 0;
            int actual = wc.getNumInvalidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe){
            fail();
        }
    }

    /**
     * Tests for number of lines in empty.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void emptyNumberLines() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\empty.txt");
        try {
            wc.load(file.toPath());
            int expected = 0;
            int actual = wc.getNumLines();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe) {
            fail();
        }
    }

    /**
     * Tests for number of valid words in empty.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void emptyValidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\empty.txt");
        try {
            wc.load(file.toPath());
            int expected = 0;
            int actual = wc.getNumValidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe) {
            fail();
        }
    }

    /**
     * Tests for number of invalid words in empty.txt
     *
     * @author Anthony lohmiller
     */
    @Test
    public void emptyInvalidWords() {
        WordCounter wc = new WordCounter();
        File file = new File("testfiles\\empty.txt");
        try {
            wc.load(file.toPath());
            int expected = 0;
            int actual = wc.getNumInvalidWords();
            Assertions.assertEquals(expected, actual);
        } catch (IOException ioe){
            fail();
        }
    }
}
