/*
 * Course: SE2030-041
 * Fall 2019
 * Lab: Word Counter
 * Author: Stuart Harley
 * Created: 10/3/2019
 */

package wordCounter;

/**
 * Represents a word from the file opened. Contains the actual word, the line
 * the word is on, and whether or not it is a valid word.
 */
public class Word {

    private boolean isValid;
    private int line;
    private String word;

    /**
     * Constructor for a Word
     * @param line what line the word is on
     * @param word the actual word
     */
    public Word(int line, String word) {
        this.line = line;
        this.word = word;
        this.isValid = isValidWord();
    }

    public boolean getValid() {
        return isValid;
    }

    public int getLine() {
        return line;
    }

    public String getWord() {
        return word;
    }

    /**
     * Set method for the word attribute. Also updates the isValid attribute
     * @param word the actual word
     */
    public void setWord(String word) {
        this.word = word;
        this.isValid = isValidWord();
    }

    /**
     * Checks whether a word is valid
     * @return a boolean value representing whether or not the word is valid
     */
    private boolean isValidWord() {
        return word != null && word.matches("^[a-zA-Z]*$");
    }
}
