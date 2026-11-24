
package com.chanirac.week7_eventhandling;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DragDropDemo extends Application {

    @Override
    public void start(Stage stage) {

        Label perfume = new Label("Vanilla Sugar Perfume");
        Label shoppingBag = new Label("Drop Perfume Here");
        Label message = new Label("Drag the perfume into your bag!");

        perfume.setStyle("-fx-background-color: pink; -fx-padding: 15;");
        shoppingBag.setStyle("-fx-border-color: purple; -fx-padding: 30;");

        // Start dragging the perfume
        perfume.setOnDragDetected(event -> {
            Dragboard dragboard = perfume.startDragAndDrop(TransferMode.COPY);

            ClipboardContent content = new ClipboardContent();
            content.putString(perfume.getText());

            dragboard.setContent(content);
            event.consume();
        });

        // Allow perfume to be dropped into the bag
        shoppingBag.setOnDragOver(event -> {
            if (event.getGestureSource() != shoppingBag
                    && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.COPY);
            }
            event.consume();
        });

        // Handle the dropped perfume
        shoppingBag.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;

            if (dragboard.hasString()) {
                shoppingBag.setText("Bag: " + dragboard.getString());
                message.setText("Perfume added to your shopping bag!");
                success = true;
            }

            event.setDropCompleted(success);
            event.consume();
        });

        VBox root = new VBox(25, perfume, shoppingBag, message);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 350);

        stage.setTitle("Week 7 - Drag and Drop");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
