
package week4_eventhandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardEventDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Keyboard Event Demo");
            frame.setSize(450, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

            JLabel instructionLabel = new JLabel(
                    "Click the text box and type something!",
                    SwingConstants.CENTER
            );

            JTextField textField = new JTextField();

            JLabel resultLabel = new JLabel(
                    "Waiting for keyboard input...",
                    SwingConstants.CENTER
            );

            textField.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    resultLabel.setText(
                            "Key pressed: " + KeyEvent.getKeyText(e.getKeyCode())
                    );
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    resultLabel.setText(
                            "Key released: " + KeyEvent.getKeyText(e.getKeyCode())
                    );
                }
            });

            panel.add(instructionLabel);
            panel.add(textField);
            panel.add(resultLabel);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
