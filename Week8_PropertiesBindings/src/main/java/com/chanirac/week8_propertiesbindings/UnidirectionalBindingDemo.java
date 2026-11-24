
package com.chanirac.week8_propertiesbindings;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnidirectionalBindingDemo extends Application {

    @Override
    public void start(Stage stage) {

        int pricePerBottle = 450;

        // Property storing the number of perfumes ordered
        IntegerProperty quantity = new SimpleIntegerProperty(1);

        // Property storing the total price
        IntegerProperty total = new SimpleIntegerProperty();

        // One-way binding: total depends on quantity
        total.bind(quantity.multiply(pricePerBottle));

        Label title = new Label("Chanira C Order Calculator");
        Label quantityLabel = new Label();
        Label totalLabel = new Label();

        quantityLabel.textProperty().bind(
                quantity.asString("Quantity: %d")
        );

        totalLabel.textProperty().bind(
                total.asString("Total: KSh %d")
        );

        Button addButton = new Button("Add One Perfume");
        Button removeButton = new Button("Remove One Perfume");

        addButton.setOnAction(e -> quantity.set(quantity.get() + 1));

        removeButton.setOnAction(e -> {
            if (quantity.get() > 1) {
                quantity.set(quantity.get() - 1);
            }
        });

        VBox root = new VBox(
                20, title, quantityLabel, totalLabel,
                addButton, removeButton
        );

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 350);

        stage.setTitle("Week 8 - Unidirectional Binding");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
