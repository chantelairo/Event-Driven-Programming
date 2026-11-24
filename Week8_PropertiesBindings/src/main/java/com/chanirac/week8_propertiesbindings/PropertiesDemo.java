
package com.chanirac.week8_propertiesbindings;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertiesDemo extends Application {

    @Override
    public void start(Stage stage) {

        // JavaFX properties for Chanira C products
        StringProperty perfumeName =
                new SimpleStringProperty("Vanilla Sugar");

        IntegerProperty perfumePrice =
                new SimpleIntegerProperty(450);

        Label title = new Label("Chanira C Perfume Store");

        Label nameLabel = new Label();
        Label priceLabel = new Label();

        // Bind labels to properties
        nameLabel.textProperty().bind(perfumeName);
        priceLabel.textProperty().bind(
                perfumePrice.asString("Price: KSh %d")
        );

        Button updateButton = new Button("Change Perfume");

        updateButton.setOnAction(e -> {
            perfumeName.set("Mulberry");
            perfumePrice.set(350);
        });

        VBox root = new VBox(
                20, title, nameLabel, priceLabel, updateButton
        );

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 300);

        stage.setTitle("Week 8 - JavaFX Properties");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
