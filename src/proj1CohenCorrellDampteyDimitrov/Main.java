/**
 * Erik Cohen, Cassidy Correll, Kuukua Damptey, Anton Dimitrov
 * Spring 2022
 * CS361: Object Oriented Programming
 * Project 1 - Main.java
 * Class that sets up the GUI according to the Project 1 specifications.
*/
package proj1CohenCorrellDampteyDimitrov;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//menu imports
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application{
    MyMenu myMenu = new MyMenu();
    MyButtons myButtons = new MyButtons();

    /**
     * Creates Two Buttons and adds to "Stage"
     * Shows stage in window and handles button "click" events
     * <p>
     * Required Inheriterd Subclass Method 
     * The main entry point for all JavaFX applications.
     * Called on the JavaFX Application Thread.
     *
     * @param  primaryStage  Main window used by Application
     * @return     
     * @see        Application
    */
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new VBox(), 400, 350);

        Button button = myButtons.createButton();
        ((VBox) scene.getRoot()).getChildren().addAll(button);

        MenuBar menuBar = myMenu.createMenu();
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);

        primaryStage.setTitle("EC, CC, KD, AD, et al.'s Project 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Creates a window with interactable buttons
     * Method automatically called on start
     *
     * @param  args Command line arguments used in Application "launch" method
     * @return     an interactable window
     * @see        start
    */
    public static void main(String[] args) {
        launch(args);
    }
}
