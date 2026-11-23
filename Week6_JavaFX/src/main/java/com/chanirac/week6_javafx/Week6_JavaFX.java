
package com.chanirac.week6_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Week6_JavaFX extends Application {

    @Override
    public void start(Stage stage) {

        Label welcomeLabel = new Label(
            "Welcome to Chanira C!"
        );

        Button button = new Button("Click Me");

        button.setOnAction(e -> {
            welcomeLabel.setText(
                "Thank you for choosing Chanira C!"
            );
        });

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(welcomeLabel, button);

        Scene scene = new Scene(root, 450, 300);

        stage.setTitle("Chanira C - JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
