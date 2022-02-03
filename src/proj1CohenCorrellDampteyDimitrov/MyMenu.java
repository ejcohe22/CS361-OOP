/**
 * Erik Cohen, Cassidy Correll, Kuukua Damptey, Anton Dimitrov
 * Spring 2022
 * CS361: Object Oriented Programming
 * Project 1 - MyMenu.java
 * Create MenuBar
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

public class MyMenu {
        /**
     * Creates a Menubar for the Application
     * 1 Menu item: File
     * has "exit" and "clear" actions
     * @return      MenuBar
     * @see        Menu
    */
    public MenuBar createMenu(){
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
}
