package week4_eventhandling;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Mouse Event Demo");
            frame.setSize(450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel messageLabel = new JLabel(
                    "Move your mouse into the box!",
                    SwingConstants.CENTER
            );

            JPanel mousePanel = new JPanel();
            mousePanel.setBackground(Color.LIGHT_GRAY);
            mousePanel.setLayout(new BorderLayout());
            mousePanel.add(messageLabel, BorderLayout.CENTER);

            mousePanel.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    messageLabel.setText("Mouse entered the box!");
                    mousePanel.setBackground(Color.CYAN);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    messageLabel.setText("Mouse left the box!");
                    mousePanel.setBackground(Color.LIGHT_GRAY);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    messageLabel.setText("Mouse clicked!");
                    mousePanel.setBackground(Color.PINK);
                }
            });

            frame.add(mousePanel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
