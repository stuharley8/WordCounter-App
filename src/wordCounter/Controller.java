/*
 * Course: SE2030-041
 * Fall 2019
 * Lab: Word Counter
 * Author: Stuart Harley, Joey Rundlett, Anthony Lohmiller
 * Created: 9/27/2019
 */

package wordCounter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Controller Class for the WordCounter.fxml
 */
public class Controller {

    private static final Alert ALERT = new Alert(Alert.AlertType.ERROR);
    private static int numPopularLetters = 1;

    private static File logFile = new File("log.txt");
    private static File outFile = new File("out.txt");
    String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();

    @FXML
    private Label logPathLabel;

    @FXML
    private Label outputPathLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label numLinesLabel;

    @FXML
    private Label numValidWordsLabel;

    @FXML
    private Label numInvalidWordsLabel;

    @FXML
    private Spinner numPopularLettersSpinner;

    /**
     * Allows the user to specify a file containing an arbitrary number of words separated
     * by whitespace. The number of words on each line may vary from 0 to an arbitrary large
     * number. The length of a word may vary from 1 character to and arbitrarily large number
     * of characters. The file search will start in the project directory for the application.
     * After the document is opened it calls the appropriate methods to deal with the
     * log.txt and out.txt.
     * @author Anthony Lohmiller
     */
    @FXML
    public void openOnAction(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "WordCounter Files", "*.txt"));
        fileChooser.setInitialDirectory(new File(currentPath));
        try {
            statusLabel.setText("   Status:");
            File file = fileChooser.showOpenDialog(null);
            Path path = file.toPath();
            WordCounter wordCounter = new WordCounter();
            wordCounter.load(path);
            wordCounter.log(logFile);
            wordCounter.output(outFile, numPopularLetters, file.getName());
            logPathLabel.setText("   Log Path:     " + logFile.getAbsolutePath());
            outputPathLabel.setText("   Output Path:     " + outFile.getAbsolutePath());
            statusLabel.setText("   Status:     Done");
            numLinesLabel.setText("   Number of Lines:     " + wordCounter.getNumLines());
            numValidWordsLabel.setText("   Number of Valid Words:     " +
                    wordCounter.getNumValidWords());
            numInvalidWordsLabel.setText("   Number of Invalid Words:     " +
                    wordCounter.getNumInvalidWords());
        } catch (NullPointerException npe) {
            // this prevents crashing on cancel
        } catch (IOException e) {
            ALERT.setTitle("Error Dialog");
            ALERT.setHeaderText("File Error");
            ALERT.setContentText(e.getMessage());
            ALERT.showAndWait();
        }
    }

    /**
     * Allows the user to specify an output file. The application will write various
     * statistics to this file. If no output file name is specified, the name of the
     * output file will default to out.txt
     * @author Stuart Harley
     */
    @FXML
    public void outputOnAction(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Output File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "WordCounter Files", "*.txt"));
        fileChooser.setInitialFileName("out");
        fileChooser.setInitialDirectory(new File(currentPath));
        File file = fileChooser.showSaveDialog(null);
        if(file != null) {
            outFile = file;
            outputPathLabel.setText("   Output Path:     " + outFile.getAbsolutePath());
        }
    }

    /**
     * Allows the user to specify a log file. The application will write various messages
     * to this file. If no log file name is specified, the name of the log file will
     * default to log.txt
     * @author Stuart Harley, Joey Rundlett
     */
    @FXML
    public void logOnAction(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Log File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "WordCounter Files", "*.txt"));
        fileChooser.setInitialFileName("log");
        fileChooser.setInitialDirectory(new File(currentPath));
        File file = fileChooser.showSaveDialog(null);
        if(file != null) {
            logFile = file;
            logPathLabel.setText("   Log Path:     " + logFile.getAbsolutePath());
        }
    }

    /**
     * Allows the user to close the application
     */
    @FXML
    public void exitOnAction(){
        Platform.exit();
    }

    /**
     * Updates numPopularLetters when the value is changed in the GUI
     */
    @FXML
    public void updateNumPopularLettersOnAction() {
        numPopularLetters = (int)numPopularLettersSpinner.getValue();
    }
}
