
package com.chanirac.week7_eventhandling;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class EventFilterDemo extends Application {

    @Override
    public void start(Stage stage) {

        Label message = new Label("Click the button to see the event order!");
        Button button = new Button("Order Chanira C Perfume");

        VBox root = new VBox(20, button, message);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 300);

        // Event filter: Capturing phase
        root.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("1. Event Filter: Parent receives event first");
        });

        // Event handler: Bubbling phase
        button.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("2. Event Handler: Button receives event");
            message.setText("Chanira C perfume selected!");
        });

        // Parent event handler
        root.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("3. Parent Handler: Event bubbles back up");
        });

        stage.setTitle("Week 7 - Event Filters and Handlers");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
