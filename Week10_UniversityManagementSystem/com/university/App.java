
package com.university;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("University Management System");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Student Full Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Student Email");

        TextField courseField = new TextField();
        courseField.setPromptText("Course");

        TextField yearField = new TextField();
        yearField.setPromptText("Year of Study");

TextArea studentList = new TextArea();
studentList.setEditable(false);
studentList.setPrefHeight(150);

Button viewButton = new Button("View Students");

viewButton.setOnAction(e -> {
    studentList.clear();

    String sql = "SELECT * FROM students";

    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            studentList.appendText(
                "ID: " + rs.getInt("student_id")
                + " | Name: " + rs.getString("full_name")
                + " | Course: " + rs.getString("course")
                + "\n"
            );
        }

    } catch (SQLException ex) {
        new Alert(Alert.AlertType.ERROR,
                "Error loading students: " + ex.getMessage())
                .showAndWait();
    }
});

TextField studentIdField = new TextField();
studentIdField.setPromptText("Enter Student ID");

Button updateButton = new Button("Update Student");

updateButton.setOnAction(e -> {
    try {
        int studentId = Integer.parseInt(
                studentIdField.getText().trim());
        int year = Integer.parseInt(
                yearField.getText().trim());

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String course = courseField.getText().trim();

        if (studentId < 1 || year < 1 || name.isEmpty()
                || email.isEmpty() || course.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String sql = "UPDATE students SET full_name = ?, "
                + "email = ?, course = ?, year_of_study = ? "
                + "WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, course);
            stmt.setInt(4, year);
            stmt.setInt(5, studentId);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                new Alert(Alert.AlertType.INFORMATION,
                        "Student updated successfully!").showAndWait();
            } else {
                new Alert(Alert.AlertType.WARNING,
                        "Student not found!").showAndWait();
            }
        }

    } catch (IllegalArgumentException ex) {
        new Alert(Alert.AlertType.WARNING,
                "Enter a valid Student ID and all student details.")
                .showAndWait();

    } catch (SQLException ex) {
        new Alert(Alert.AlertType.ERROR,
                "Database error: " + ex.getMessage()).showAndWait();
    }
});

Button deleteButton = new Button("Delete Student");

deleteButton.setOnAction(e -> {
    try {
        int studentId = Integer.parseInt(
                studentIdField.getText().trim());

        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                new Alert(Alert.AlertType.INFORMATION,
                        "Student deleted successfully!").showAndWait();
                studentIdField.clear();
            } else {
                new Alert(Alert.AlertType.WARNING,
                        "Student not found!").showAndWait();
            }
        }

    } catch (NumberFormatException ex) {
        new Alert(Alert.AlertType.WARNING,
                "Please enter a valid Student ID.").showAndWait();

    } catch (SQLException ex) {
        new Alert(Alert.AlertType.ERROR,
                "Database error: " + ex.getMessage()).showAndWait();
    }
});

        Button registerButton = new Button("Register Student");

registerButton.setOnAction(e -> {
    String name = nameField.getText().trim();
    String email = emailField.getText().trim();
    String course = courseField.getText().trim();

    try {
        int year = Integer.parseInt(yearField.getText().trim());

        if (name.isEmpty() || email.isEmpty() || course.isEmpty()
                || year < 1) {
            throw new IllegalArgumentException();
        }

        String sql = "INSERT INTO students "
                + "(full_name, email, course, year_of_study) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, course);
            stmt.setInt(4, year);

            stmt.executeUpdate();

            new Alert(Alert.AlertType.INFORMATION,
                    "Student registered successfully!").showAndWait();

            nameField.clear();
            emailField.clear();
            courseField.clear();
            yearField.clear();
       

    } 
} catch (IllegalArgumentException ex) {

        new Alert(Alert.AlertType.WARNING,
                "Please enter all details and a valid year of study.")
                .showAndWait();

    } catch (SQLException ex) {
        new Alert(Alert.AlertType.ERROR,
                "Database error: " + ex.getMessage()).showAndWait();
    }
});



VBox layout = new VBox(15,
        title,
        nameField,
        emailField,
        courseField,
        yearField,
        registerButton,
        viewButton,
        studentList,
        studentIdField,
        updateButton,
        deleteButton
);



        
        layout.setPadding(new Insets(25));

        Scene scene = new Scene(layout, 500, 450);

        stage.setTitle("University Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
