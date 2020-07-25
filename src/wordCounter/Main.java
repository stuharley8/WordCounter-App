/*
 * Course: SE2030-041
 * Fall 2019
 * Lab: Word Counter
 * Author: Stuart Harley, Joey Rundlett, Anthony Lohmiller
 * Created: 9/27/2019
 */

package wordCounter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class runs the WordCounter program
 */
public class Main extends Application {

    /**
     * Start method of the JavaFX program
     * @param primaryStage the stage
     * @throws IOException if there is a problem loading WordCounter.fxml
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WordCounter.fxml"));
        primaryStage.setTitle("Word Counter");
        primaryStage.setScene(new Scene(root, 800, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
