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

public class Main extends Application{
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
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
                /**
                 * Returns an Image object that can then be painted on the screen. 
                 * The url argument must specify an absolute <a href="#{@link}">{@link URL}</a>. The name
                 * argument is a specifier that is relative to the url argument. 
                 * <p>
                 * This method always returns immediately, whether or not the 
                 * image exists. When this applet attempts to draw the image on
                 * the screen, the data will be loaded. The graphics primitives 
                 * that draw the image will incrementally paint on the screen. 
                 *
                 * @param  event the location of the image, relative to the url argument
                 * @return      the image at the specified URL
                 * @see        Image
                */
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });//btn.setOnAction
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
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
