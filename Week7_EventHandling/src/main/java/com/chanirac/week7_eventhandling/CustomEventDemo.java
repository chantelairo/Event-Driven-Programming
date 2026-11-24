
package com.chanirac.week7_eventhandling;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomEventDemo extends Application {

    // Create our own custom event
    public static class OrderEvent extends Event {

        public static final EventType<OrderEvent> ORDER_PLACED =
                new EventType<>(Event.ANY, "ORDER_PLACED");

        public OrderEvent() {
            super(ORDER_PLACED);
        }
    }

    @Override
    public void start(Stage stage) {

        Label title = new Label("Chanira C Order System");
        Label message = new Label("No order placed yet.");

        Button orderButton = new Button("Order Vanilla Sugar");

        VBox root = new VBox(20, title, orderButton, message);
        root.setAlignment(Pos.CENTER);

        // Listen for our custom event
        root.addEventHandler(OrderEvent.ORDER_PLACED, event -> {
            message.setText("Vanilla Sugar order placed successfully!");
            System.out.println("Custom Event: Chanira C order received!");
        });

        // Trigger the custom event when button is clicked
        orderButton.setOnAction(event -> {
            Event.fireEvent(root, new OrderEvent());
        });

        Scene scene = new Scene(root, 450, 300);

        stage.setTitle("Week 7 - Custom JavaFX Events");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
