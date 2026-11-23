
package week4_eventhandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemEventDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Chanira C Gift Package");
            frame.setSize(450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

            JLabel titleLabel = new JLabel(
                    "Choose your Chanira C gift items:",
                    SwingConstants.CENTER
            );

            JCheckBox perfumeBox = new JCheckBox("Body Splash - KSh 450");
            JCheckBox chocolateBox = new JCheckBox("Chocolate - KSh 300");
            JCheckBox cardBox = new JCheckBox("Gift Card - KSh 100");

            JLabel totalLabel = new JLabel(
                    "Total: KSh 0",
                    SwingConstants.CENTER
            );

            ItemListener itemListener = e -> {

                int total = 0;

                if (perfumeBox.isSelected()) {
                    total += 450;
                }

                if (chocolateBox.isSelected()) {
                    total += 300;
                }

                if (cardBox.isSelected()) {
                    total += 100;
                }

                totalLabel.setText("Total: KSh " + total);
            };

            perfumeBox.addItemListener(itemListener);
            chocolateBox.addItemListener(itemListener);
            cardBox.addItemListener(itemListener);

            panel.add(titleLabel);
            panel.add(perfumeBox);
            panel.add(chocolateBox);
            panel.add(cardBox);
            panel.add(totalLabel);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
