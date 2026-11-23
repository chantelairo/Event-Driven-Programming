
package week5_advancedswing;

import javax.swing.*;
import java.awt.*;

public class FragranceSelectorDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Chanira C Fragrance Selector");
            frame.setSize(450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1, 10, 10));
            panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
            );

            JLabel title = new JLabel(
                "Find Your Chanira C Fragrance",
                SwingConstants.CENTER
            );

            String[] fragrances = {
                "Select a fragrance",
                "Vanilla Sugar",
                "Mulberry",
                "Burgundy",
                "Pecan",
                "Asali"
            };

            JComboBox<String> fragranceBox =
                new JComboBox<>(fragrances);

            JLabel result = new JLabel(
                "Choose a fragrance above",
                SwingConstants.CENTER
            );

            fragranceBox.addActionListener(e -> {

                String selected =
                    (String) fragranceBox.getSelectedItem();

                switch (selected) {
                    case "Vanilla Sugar":
                        result.setText("Sweet, creamy vanilla scent");
                        break;
                    case "Mulberry":
                        result.setText("Sweet and bold fragrance");
                        break;
                    case "Burgundy":
                        result.setText("Soft and romantic fragrance");
                        break;
                    case "Pecan":
                        result.setText("Oudy, musky and bold fragrance");
                        break;
                    case "Asali":
                        result.setText("Seductive and mysterious scent");
                        break;
                    default:
                        result.setText("Choose a fragrance above");
                }
            });

            panel.add(title);
            panel.add(fragranceBox);
            panel.add(result);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
