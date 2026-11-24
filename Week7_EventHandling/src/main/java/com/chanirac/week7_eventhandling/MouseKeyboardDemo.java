
package com.chanirac.week7_eventhandling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class MouseKeyboardDemo extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Chanira C Event Demo");
        Label message = new Label("Try interacting with the window!");

        Button button = new Button("Explore Chanira C");

        // Action event
        button.setOnAction(e -> {
            message.setText("Welcome to Chanira C!");
        });

        // Mouse enters the button
        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-background-color: pink;");
            message.setText("You're hovering over the button!");
        });

        // Mouse leaves the button
        button.setOnMouseExited(e -> {
            button.setStyle("");
        });

        VBox root = new VBox(20, title, button, message);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 300);

        // Keyboard event
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                message.setText("ENTER key pressed!");
            } else if (e.getCode() == KeyCode.ESCAPE) {
                message.setText("ESCAPE key pressed!");
            }
        });

        stage.setTitle("Week 7 - Mouse and Keyboard Events");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
