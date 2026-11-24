
package com.chanirac.week8_propertiesbindings;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyListenersDemo extends Application {

    @Override
    public void start(Stage stage) {

        IntegerProperty stock = new SimpleIntegerProperty(20);

        Label title = new Label("Chanira C Stock Monitor");
        Label stockLabel = new Label("Bottles in stock: 20");
        Label statusLabel = new Label("Waiting for stock changes...");

        // ChangeListener: detects old and new values
        stock.addListener((observable, oldValue, newValue) -> {
            stockLabel.setText("Bottles in stock: " + newValue);
            statusLabel.setText(
                "Stock changed from " + oldValue + " to " + newValue
            );

            System.out.println(
                "ChangeListener: " + oldValue + " -> " + newValue
            );
        });

        // InvalidationListener: detects property invalidation
        InvalidationListener invalidationListener = observable -> {
            System.out.println("InvalidationListener: Stock property invalidated!");
        };

        stock.addListener(invalidationListener);

        Button sellButton = new Button("Sell One Perfume");

        sellButton.setOnAction(e -> {
            if (stock.get() > 0) {
                stock.set(stock.get() - 1);
            } else {
                statusLabel.setText("Out of stock!");
            }
        });

        VBox root = new VBox(
            20, title, stockLabel, sellButton, statusLabel
        );
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 300);

        stage.setTitle("Week 8 - Property Listeners");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
