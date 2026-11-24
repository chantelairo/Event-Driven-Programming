
package com.chanirac.week8_propertiesbindings;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BidirectionalBindingDemo extends Application {

    @Override
    public void start(Stage stage) {

        StringProperty customerName =
                new SimpleStringProperty("");

        Label title = new Label("Chanira C Customer Form");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter customer name");

        TextField secondField = new TextField();
        secondField.setPromptText("Customer name copy");

        Label message = new Label("Customer: ");

        // Two-way binding between the property and first field
        nameField.textProperty().bindBidirectional(customerName);

        // Two-way binding between the property and second field
        secondField.textProperty().bindBidirectional(customerName);

        // Display the name automatically
        message.textProperty().bind(
                customerName.concat(" - Chanira C Customer")
        );

        VBox root = new VBox(
                20, title, nameField, secondField, message
        );

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 30;");

        Scene scene = new Scene(root, 450, 300);

        stage.setTitle("Week 8 - Bidirectional Binding");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
