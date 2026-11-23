
import javax.swing.*;
import java.awt.*;

public class LoginForm {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Login Form");
            frame.setSize(350, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2, 10, 10));

            JLabel usernameLabel = new JLabel("Username:");
            JTextField usernameField = new JTextField();

            JLabel passwordLabel = new JLabel("Password:");
            JPasswordField passwordField = new JPasswordField();

            JButton loginButton = new JButton("Login");

            loginButton.addActionListener(e -> {

                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                if (username.equals("admin")
                        && new String(password).equals("1234")) {

                    JOptionPane.showMessageDialog(frame,
                            "Login Successful!");

                } else {

                    JOptionPane.showMessageDialog(frame,
                            "Invalid Username or Password");

                }

                java.util.Arrays.fill(password, '\0');
            });

            panel.add(usernameLabel);
            panel.add(usernameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(new JLabel(""));
            panel.add(loginButton);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}
