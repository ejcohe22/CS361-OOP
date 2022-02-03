/**
 * Erik Cohen, Cassidy Correll, Kuukua Damptey, Anton Dimitrov
 * Spring 2022
 * CS361: Object Oriented Programming
 * Project 1 - MyButtons.java
 * Class that creates different types of buttons
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

public class MyButtons {
    /**
     * Creates a Button for the Application
     * Button stuff
     * button click events
     * @return      Button
     * @see        Button
    */
    public Button createButton(){
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
}
