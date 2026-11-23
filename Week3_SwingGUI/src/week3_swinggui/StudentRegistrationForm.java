package week3_swinggui;


import javax.swing.*;
import java.awt.*;

public class StudentRegistrationForm {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Student Registration Form");
            frame.setSize(450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

            JLabel nameLabel = new JLabel("Student Name:");
            JTextField nameField = new JTextField();

            JLabel idLabel = new JLabel("Student ID:");
            JTextField idField = new JTextField();

            JLabel courseLabel = new JLabel("Course:");
            JTextField courseField = new JTextField();

            JButton registerButton = new JButton("Register");

            registerButton.addActionListener(e -> {

                String name = nameField.getText();
                String id = idField.getText();
                String course = courseField.getText();

                if (name.isEmpty() || id.isEmpty() || course.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Please fill in all fields!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Registration Successful!\n"
                            + "Name: " + name + "\n"
                            + "Student ID: " + id + "\n"
                            + "Course: " + course);
                }
            });

            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(idLabel);
            panel.add(idField);
            panel.add(courseLabel);
            panel.add(courseField);
            panel.add(new JLabel(""));
            panel.add(registerButton);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
