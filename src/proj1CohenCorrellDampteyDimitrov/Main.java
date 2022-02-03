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
    /**
     * Creates a Menubar for the Application
     * 1 Menu item: File
     * has "exit" and "clear" actions
     * @return      MenuBar
     * @see        Menu
    */
    private MenuBar createMenu(){
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().addAll(menuFile);

        MenuItem clear = new MenuItem("Clear");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //stage.setVisible(false);
            }
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        menuFile.getItems().addAll(clear, new SeparatorMenuItem(), exit);
        return menuBar;
    }

    /**
     * Creates a Button for the Application
     * Button stuff
     * button click events
     * @return      Button
     * @see        Button
    */
    private Button createButton(){
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
        return btn;
    }

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
        Button button = createButton();
        Scene scene = new Scene(new VBox(), 400, 350);
        MenuBar menuBar = createMenu();
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);
        ((VBox) scene.getRoot()).getChildren().addAll(button);

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
