# CS361-OOP
Code from CS361 Object Oriented Programming Spring 2022

---
# Project 1: Learning to Use JavaFX
Erik Cohen, Cassidy Correll, Anton Dimitrov, Jasper Loverude
CS361: Object-Oriented Programming

## Design Overview
 
Our design process in this project was to break the instructions into smaller testable chunks. This was useful not only to divide work amongst the team but also to create working code that meets our build specifications. This was the first project so part of the project was figuring out the first place to start. We copied an example and then decided how to use methods to encapsulate code blocks. We created the toolbar, menubar, and text field objects in methods in order to hide some of the created actions and styling code. This is useful because each code block has a single responsibility. A good example of this is the “Start” function. While it would have been much simpler to keep all of the code in this one method, our solution allows the start function to only handle creating and organizing the “stage”. Likewise, the “createToolBar” method is only expected to create the toolbar, its buttons, and the button events.
 
## Elegant Design Features
 
As previously mentioned, we tried making more cohesive code blocks by subdividing them into methods. This is more elegant because the reader is assured that all code in a section will be about the same thing. Having that, if someone else wanted to work on the same code in the future, they would have an easier time updating it - since all the GUI elements are defined in separate methods, making errors would be less likely to happen, or if they did, they would be easier to fix. 
 
## Class Structure
	
One of the requirements for this project is to keep all of the code in a Main.java class. While we’d ideally define the GUI elements as different Java classes, we did our best to stay within Main.java by defining separate methods for each required GUI element instead. As a result, we have created methods for the menu (“createMenuBar”), toolbar (“createToolBar”), textfield (“createTextField”), and the creation of the stage (“Start”). With the restriction of having all the code in Main.java, we made do by having the relevant GUI elements that interact with another element be passed as parameters in the method designated for the element they interact with. Hence that is why, for example, a method such as createMenuBar takes the parameters TextField textField and Button hello. 
Shortcomings
	
An aspect of our code that is slightly inelegant is that the “createMenuBar” and “createToolBar” methods are tightly coupled with other methods/objects. This is a problem for future maintainability. We are unsure of a solution that would not use additional classes or objects as parameters.
 
 
## Division of Labor
 
We met in Davis to work on the project with “Pair Programming” in mind. We worked together each taking turns writing code on our personal machines (and debugging the javaFX install!). The code from our project is stored on Github. 

---

# Project 2: Using FXML and CSS files
Izge Bayyurt, Erik Cohen, Nico Hillison
CS361: Object-Oriented Programming


## Design Overview

The design of this project is almost the same as the one from project 1. To have cleaner code, we added two new files to the project: main.fxml and main.css. While the .fxml file takes care of the hierarchy of the GUI elements, .css file lets us easily edit the styling of the components. This way, we can reduce the clutter in the main.java file.What differentiates this project from the first one is the use of these three different files. We used the SceneBuilder tool to build the .FXML file and the template for our “controller” file.

## Class Structure

Within our controller “Main.java” file there is only one class. It contains fields of objects with specified Id’s in the SceneBuilder tool. It also has methods tied to the buttons and menu actions.

## Elegant Design Features
	
It is elegant because it completely separates the style of the window from other parts of the code. In addition, fxml id’s and “onAction” property made it possible to handle button pressed events without also having to set up the action, eventhandler, and handle boiler plate code. Our new source code is easier to read and understand.

## Shortcomings

An inelegant part of our solution is the dialog box that pops up when the “hello” button is pressed.There was only a “dialog pane” object in the SceneBuilder application. Since we were unsure how to make the pane visible or not we used a “TextInputDialog” object in the “helloPressed” handling method.

## Division of Labor

We got together in Davis and worked on the SceneBuilder to build the new project. The SceneBuilder took care of creation of the code, while we just had to adjust the hierarchy of the elements manually.

---

# Project 3: Adding new menus, menu items, and tabs

## Design Overview

We started this project with Wen’s Project 2. In Scene Builder, we added the 12 required menu items and moved the “TextArea” into a “TabPane”. Each tab of the “TabPane” represents a file that is being edited. We added the option to create a new tab, open an existing file, save a file, save a file with a new name, and close a file. We have private helper methods that allow the user to read and write to files in their directory. In order to know if the file in a tab is saved or not we kept track of the filePath of the current tab in a “filePaths” map (stored as a private variable in Controller.java). The filePath is stored when a file is opened and when the action for “save as…” is called. When the save action is started, we check if the filePath exists/ is valid, then overwrite the file. If it is not, we call the saveFileAs method instead. Likewise, when we close a file, we can first open the file at the specified location and check that the content is equal to the current content of the “TextArea” if it is not the same a dialog appears asking the user to save.

The other major part of this project was implementing the undo/redo functionality in a “TextHistory” class. The “TextHistory” is a stack of strings that hold the content of the TextArea at different time points. The “saveState'' function of our controller is called every time a key is released in the “TabPane” object. This function pushes the current “TextArea” text onto the matching “TextHistory” undo stack. When the user wishes to undo, the “TextHistory” class moves the current state to a redo stack and then retrieves the last state from the “TextHistory” undo stack. Redo works the same way but in reverse.

## Elegant Design Features

One example of an elegant design feature is the use of java’s “Map” to store the file path and TextHistory of each tab. This allows the user to manage which file is open in each tab and also make independent undo/redo actions for each open tab. By keeping the TextHistory information independent of JavaFX dependencies, we have a file that could be used in other java projects. In addition, we were able to create and test this file before including it in the larger spiderweb that is our Controller class.

Another elegant decision we made was to separate the start method from all the other “controller” methods by creating a new class. This makes it a lot easier to understand what the code does to whoever is reading it and it makes it a lot more scalable too.

## Class Structure

We have two classes that handle purely JavaFX actions. The Controller class is the one in charge of telling JavaFX what elements exist and what to do when the user interacts with them, most of the functionality of the program resides in this class. The Main class is the one in charge of starting the program. We also have a TextHistory class that holds two stacks representing undo and redo states. This encapsulates the technical aspects of the undo and redo functionality.
We also have a CSS file for managing the style of the buttons and a Main.fxml file created with SceneBuilder that sets up the main window of our program.

## Shortcomings

At first, we wrote our entire program inside the main.java file, which made it very hard for anyone to understand what was going on. When we realized this we decided to break up the program into smaller files that would do specific things. We are unsure of how to break up our fxml files/objects so that they are separate, but able to communicate with each other. For example, we wanted to put all FIle operations in a separate controller class ( open…, save, save as…, close). However, these methods would not have access to the textArea that holds the content to be saved. We found some online discussion about using a “Model View Controller” design pattern but it was confusing and was too time-consuming for any of us to implement properly.

Although we were not able to do a lot of testing of our system, we are confident that we have handled major bugs+errors/ NullPointerExceptions.
 
## Division of Labor

We met in Davis to go over the goals of the project and then each one of us worked on the tasks that were best suited for our skills. Dylan worked on implementing most of the file menu buttons, Erik implemented most of the edit menu (especially the undo and redo buttons), which took some extra effort. Wen was the one in charge of cleaning up the code and making it look elegant, she also helped to break out the methods and classes in different files.

