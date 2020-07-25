/*
 * Course: SE2030-041
 * Fall 2019
 * Lab: Word Counter
 * Author: Stuart Harley, Joey Rundlett, Anthony Lohmiller
 * Created: 9/27/2019
 */

package wordCounter;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class contains the much of the functionality for the word counter program
 */
public class WordCounter {

    private List<Word> allWords;
    private List<Word> validWords;
    private List<Word> invalidWords;

    private static final int NUM_LETTERS = 26;
    private static final int NUM_CASE_SENSITIVE_LETTERS = 58;
    private static final int CHARACTER_VALUE_CONVERSION = 65;

    /**
     * Default Constructor
     */
    public WordCounter() {
        allWords = new ArrayList<>();
        validWords = new ArrayList<>();
        invalidWords = new ArrayList<>();
    }

    /**
     * this takes the path of the file and uses a buffered reader to parse out the contents of the
     * file and splits the contents into appropriate lists based on each word parsed
     *
     * @param path the path to the file being opened
     * @throws IOException if there is a problem with the buffered reader
     */
    public void load(Path path) throws IOException {
        File file = path.toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine = bufferedReader.readLine();
            int line = 1;
            while (currentLine != null) {
                boolean wordAdded = false;
                String[] currentWord = currentLine.split("[ |\t]");
                for (String aCurrentWord : currentWord) {
                    if (!aCurrentWord.equals("")) {
                        Word word = new Word(line, aCurrentWord);
                        allWords.add(word);
                        wordAdded = true;
                    }
                }
                currentLine = bufferedReader.readLine();
                if (!wordAdded) {
                    Word word = new Word(line, null);
                    allWords.add(word);
                }
                if (currentLine != null) {
                    line++;
                } else if (!wordAdded) {
                    line++;
                }
            }
            for (Word sortedWord : allWords) {
                if (sortedWord.getValid()) {
                    validWords.add(sortedWord);
                } else if (sortedWord.getWord() != null) {
                    invalidWords.add(sortedWord);
                }
            }
            if (allWords.size() > 0) {
                if (allWords.get(allWords.size() - 1).getLine() < line) {
                    Word word = new Word(line, null);
                    allWords.add(word);
                }
            } else {
                Word word = new Word(line, null);
                allWords.add(word);
            }
        }
    }

    /**
     * Writes Log file including number of valid words by line
     * and invalid words and their line number.
     *
     * @param file location that log file should write to, default writes to "log.txt"
     * @throws IOException if an invalid file output is selected
     * @author Joey Rundlett
     */
    public void log(File file) throws IOException {
        try {
            PrintWriter log = new PrintWriter(file);
            if (allWords.size() > 0) {
                int[] wordInc = new int[allWords.get(allWords.size() - 1).getLine() + 1];
                for (Word validWord : validWords) {
                    wordInc[validWord.getLine()] += 1;
                }
                for (int i = 1; i < wordInc.length; i++) {
                    if (wordInc[i] != 0) {
                        log.println("Line " + i + ": contains " + wordInc[i] + " valid words");
                    }
                }
                for (Word invalidWord : invalidWords) {
                    if (invalidWord.getWord() != null) {
                        log.println("Line " + invalidWord.getLine(
                        ) + " invalid word: " + invalidWord.getWord());
                    }
                }
                log.close();
                List<Word> temp = new ArrayList<>();
                for (int i = 0; i < invalidWords.size(); i++) {
                    if (invalidWords.get(i).getWord() != null) {
                        temp.add(invalidWords.get(i));
                    }
                }
                this.invalidWords = temp;
            }
        } catch (IOException e) {
            throw new IOException("Invalid file output selected");
        }
    }

    /**
     * Writes Output file including the number of valid words in the input file
     * and for each letter of the alphabet the number of times that letter occurred
     * across all valid words.
     *
     * @param file              location that output file should write to, default writes to "out.txt"
     * @param numPopularLetters desired number of most frequently occurring case-insensitive letters
     * @param filename          the name of the file being read from
     * @throws IOException if an invalid file output is selected
     * @author Stuart Harley, Joey Rundlett
     */
    public void output(File file, int numPopularLetters, String filename) throws IOException {
        try {
            PrintWriter output = new PrintWriter(file);
            output.println("File " + filename + " contains " +
                    validWords.size() + " valid words.");
            int[] caseLetterCount = new int[NUM_CASE_SENSITIVE_LETTERS];
            for (Word word : validWords) {
                for (int i = 0; i < word.getWord().length(); i++) {
                    char letter = word.getWord().charAt(i);
                    caseLetterCount[(int) letter - CHARACTER_VALUE_CONVERSION] += 1;
                }
            }
            output.println("\n" + numPopularLetters +
                    " Most Frequently Occurring (Case Sensitive) Letters in Valid Words");
            for (int i = 0; i < numPopularLetters; i++) {
                int tempMax = 0;
                int tempCharacter = 0;
                for (int j = 0; j < NUM_CASE_SENSITIVE_LETTERS; j++) {
                    if (caseLetterCount[j] > tempMax) {
                        tempMax = caseLetterCount[j];
                        tempCharacter = j;
                    }
                }
                if (tempMax == 0) { //Means there are no more letters in the document
                    break;
                }
                caseLetterCount[tempCharacter] = 0;
                output.println((char) (tempCharacter + CHARACTER_VALUE_CONVERSION) + ": " + tempMax);
            }
            for (Word word : validWords) {
                word.setWord(word.getWord().toUpperCase());
            }
            int[] letterCount = new int[NUM_LETTERS];
            for (Word word : validWords) {
                for (int i = 0; i < word.getWord().length(); i++) {
                    char letter = word.getWord().charAt(i);
                    letterCount[(int) letter - CHARACTER_VALUE_CONVERSION] += 1;
                }
            }
            output.println("\nNumber of Times (Case Insensitive) Letters Occurred in Valid Words");
            for (int i = 0; i < letterCount.length; i++) {
                if (letterCount[i] != 0) {
                    output.println((char) (i + CHARACTER_VALUE_CONVERSION) + ": " +
                            letterCount[i]);
                }
            }
            output.close();
        } catch (IOException e) {
            throw new IOException("Invalid file output selected");
        }
    }

    /**
     * Returns the number of lines in the file
     *
     * @return num lines
     */
    public int getNumLines() {
        int numLines = 0;
        if (allWords.size() != 0) {
            numLines = allWords.get(allWords.size() - 1).getLine();
        }
        return numLines;
    }

    /**
     * Returns number of valid words
     *
     * @return num valid words
     */
    public int getNumValidWords() {
        return validWords.size();
    }

    /**
     * Returns the number of invalid words
     *
     * @return num invalid words
     */
    public int getNumInvalidWords() {
        int count = 0;
        for(Word word : invalidWords) {
            if(word.getWord() != null) {
                count++;
            }
        }
        return count;
    }
}
