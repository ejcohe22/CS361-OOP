/*
* File: Main.java
* Names: Izge Bayyurt, Erik Cohen, Nico Hillison
* Class: CS 361
* Project 2
* Date: February 13, 2022
*/

package proj2BayyurtCohenHillison;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

/**
 * Creates the Project2 GUI
 * @author Izge Bayyurt
 * @author Erik Cohen
 * @author Nico Hillison
 * @version 1.0
 * @since 1.0
*/
public class Main extends Application{

    @FXML
    private MenuItem reset;

    @FXML
    private MenuItem exit;

    @FXML
    private Button helloButton;

    @FXML
    private Button goodbyeButton;

    @FXML
    private TextArea textArea;

    /**
     * Opens dialog box to edit the "hello" button text
     *
     * @return
    */
    public void helloPressed() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Give me a number");
        dialog.setHeaderText("Give me an integer from 0 to 255:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(number -> {helloButton.setText(number);});
    }

    /**
     * Appends goodbye to textarea on button press
     *
     * @return
    */
    public void goodbyePressed() {
        textArea.appendText("Goodbye");
    }

    /**
     * Quit when "Exit" is pressed
     * 
     * @return
    */
    public void exit() {
        System.exit(0);
    }

    /**
     * reset textarea and hello text when clear is pressed
     * 
     * @return
    */
    public void reset() {
        textArea.setText("Sample text");
        helloButton.setText("Hello");
    }

    /**
     * The main entry point for all JavaFX applications.
     * Called on the JavaFX Application Thread.
     * Creates GUI using FXML loader
     *
     * @param  primaryStage  Main window used by Application
     * @return     
     * @see        Application
    */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
            primaryStage.setTitle("IB, EC, NH et al.'s Project 2");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a window with interactable buttons
     * 
     * @param  args Command line arguments used in Application "launch" method
     * @return     an interactable window
     * @see        start
    */
    public static void main(String[] args) {
        launch(args);
    }
}
