
package week5_advancedswing;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderListDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Chanira C Order List");
            frame.setSize(450, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new BorderLayout(10, 10));
            panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
            );

            JLabel title = new JLabel(
                "Select Your Chanira C Fragrances",
                SwingConstants.CENTER
            );

            String[] fragrances = {
                "Vanilla Sugar",
                "Mulberry",
                "Burgundy",
                "Pecan",
                "Asali"
            };

            JList<String> fragranceList = new JList<>(fragrances);

            fragranceList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
            );

            fragranceList.setVisibleRowCount(5);

            JScrollPane scrollPane =
                new JScrollPane(fragranceList);

            JButton orderButton = new JButton("View My Selection");

            JLabel result = new JLabel(
                "Select one or more fragrances",
                SwingConstants.CENTER
            );

            orderButton.addActionListener(e -> {

                List<String> selected =
                    fragranceList.getSelectedValuesList();

                if (selected.isEmpty()) {
                    result.setText("Please select a fragrance!");
                } else {
                    result.setText(
                        "Selected: " + String.join(", ", selected)
                    );
                }
            });

            JPanel bottomPanel = new JPanel(
                new GridLayout(2, 1, 5, 5)
            );

            bottomPanel.add(orderButton);
            bottomPanel.add(result);

            panel.add(title, BorderLayout.NORTH);
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(bottomPanel, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
