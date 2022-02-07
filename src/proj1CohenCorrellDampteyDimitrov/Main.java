/*
* File: Main.java
* Names: Erik Cohen, Cassidy Correll, Kuukua Damptey, Anton Dimitrov
* Class: CS 361
* Project 1
* Date: February 9
*/
package proj1CohenCorrellDampteyDimitrov;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.util.Optional;

public class Main extends Application{
    /**
     * Creates a MenuBar, a ToolBar with two Buttons, and a TextField
     * All elements are added to a scene
     * Shows scene on PrimaryStage and handles button "clicked" events
     * <p>
     * Required Inheriterd Subclass Method 
     * The main entry point for all JavaFX applications.
     * Called on the JavaFX Application Thread.
     *
     * @author Erik Cohen, Cassidy Correll, Anton Dimitrov
     * @param  primaryStage  Main window used by Application
     * @return     
     * @see        Application
    */
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new VBox(), 400, 350);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().addAll(menuFile);

        ToolBar toolBar = new ToolBar();
        Button hello = new Button();
        hello.setText("Hello");
        hello.setStyle("-fx-background-color: #90EE90; -fx-border-radius: .25em; -fx-background-radius: .25em; -fx-border-color: #000000;");
        Button goodbye = new Button();
        goodbye.setText("Goodbye");
        goodbye.setStyle("-fx-background-color: #FFC0CB; -fx-border-radius: .25em; -fx-background-radius: .25em;  -fx-border-color: #000000;");
        toolBar.getItems().add(hello);
        toolBar.getItems().add(goodbye);

        TextField textField = new TextField("Sample text");
        textField.setPrefHeight(290);
        textField.setAlignment(Pos.TOP_LEFT);

        MenuItem clear = new MenuItem("Clear");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        menuFile.getItems().addAll(clear, new SeparatorMenuItem(), exit);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                textField.setText("Sample text");
                hello.setText("Hello");
            }
        });

        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);
        ((VBox) scene.getRoot()).getChildren().addAll(toolBar);
        ((VBox) scene.getRoot()).getChildren().addAll(textField);
        
        goodbye.setOnAction(new EventHandler<ActionEvent>() {
        /**
         * Appends "Goodbye" to text field on click
         *
         * @param  event event created on button click
         * @return      
        */
        @Override
        public void handle(ActionEvent event) {
            textField.appendText("Goodbye");
        }
    });//goodbye.setOnAction
        
        hello.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Opens Dialog Box to change button text
             *
             * @param  event event created on button press
             * @return
            */
        @Override
        public void handle(ActionEvent event) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Give me a number");
            dialog.setHeaderText("Give me an integer from 0 to 255:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(number -> {hello.setText(number);});
        }
    });//hello.setOnAction
        primaryStage.setTitle("EC, CC, KD, AD, et al.'s Project 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Creates a window with interactable buttons
     * Method automatically called on start
     * @param  args Command line arguments used in Application "launch" method
     * @return     an interactable window
     * @see        start
    */
    public static void main(String[] args) {
        launch(args);
    }
}
