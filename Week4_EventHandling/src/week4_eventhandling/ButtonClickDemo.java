package week4_eventhandling;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonClickDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Button Click Demo");
            frame.setSize(400, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new FlowLayout());

            JLabel messageLabel = new JLabel("Click the button!");

            JButton button = new JButton("Click Me");

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    messageLabel.setText("Button clicked successfully!");
                }
            });

            panel.add(messageLabel);
            panel.add(button);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
