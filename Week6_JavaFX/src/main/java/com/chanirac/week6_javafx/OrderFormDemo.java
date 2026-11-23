
package com.chanirac.week6_javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OrderFormDemo extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Chanira C Order Form");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter customer name");

        ComboBox<String> fragranceBox = new ComboBox<>();
        fragranceBox.getItems().addAll(
            "Vanilla Sugar", "Mulberry", "Burgundy",
            "Pecan", "Asali"
        );
        fragranceBox.setPromptText("Choose fragrance");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter quantity");

        Button orderButton = new Button("Place Order");

        Label resultLabel = new Label();

        orderButton.setOnAction(e -> {

            String name = nameField.getText().trim();
            String fragrance = fragranceBox.getValue();
            String quantityText = quantityField.getText().trim();

            if (name.isEmpty() || fragrance == null
                    || quantityText.isEmpty()) {

                resultLabel.setText("Please fill in all fields!");
                return;
            }

            try {
                int quantity = Integer.parseInt(quantityText);

                if (quantity <= 0) {
                    resultLabel.setText(
                        "Quantity must be greater than zero!"
                    );
                    return;
                }

                resultLabel.setText(
                    "Order placed for " + name
                    + ": " + quantity + " x " + fragrance
                );

            } catch (NumberFormatException ex) {
                resultLabel.setText(
                    "Please enter a valid quantity!"
                );
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(15);

        grid.add(title, 0, 0, 2, 1);

        grid.add(new Label("Customer Name:"), 0, 1);
        grid.add(nameField, 1, 1);

        grid.add(new Label("Fragrance:"), 0, 2);
        grid.add(fragranceBox, 1, 2);

        grid.add(new Label("Quantity:"), 0, 3);
        grid.add(quantityField, 1, 3);

        grid.add(orderButton, 1, 4);
        grid.add(resultLabel, 0, 5, 2, 1);

        Scene scene = new Scene(grid, 500, 350);

        stage.setTitle("Chanira C - Order Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
