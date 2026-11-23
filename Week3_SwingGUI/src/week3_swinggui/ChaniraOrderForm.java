package week3_swinggui;
import javax.swing.*;
import java.awt.*;

public class ChaniraOrderForm {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Chanira C Order Form");
            frame.setSize(450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

            JLabel scentLabel = new JLabel("Choose Fragrance:");

            String[] scents = {
                "Mulberry", "Burgundy", "Pecan", "Asali"
            };

            JComboBox<String> scentBox = new JComboBox<>(scents);

            JLabel quantityLabel = new JLabel("Quantity:");
            JTextField quantityField = new JTextField();

            JLabel priceLabel = new JLabel("Price per Bottle: KSh 450");

            JButton calculateButton = new JButton("Calculate Total");
            JLabel totalLabel = new JLabel("Total: KSh 0");

            calculateButton.addActionListener(e -> {

                try {
                    int quantity = Integer.parseInt(quantityField.getText());

                    if (quantity <= 0) {
                        JOptionPane.showMessageDialog(frame,
                                "Please enter a valid quantity!");
                        return;
                    }

                    int price = 450;
                    int total = quantity * price;

                    String scent = (String) scentBox.getSelectedItem();

                    totalLabel.setText("Total: KSh " + total);

                    JOptionPane.showMessageDialog(frame,
                            "Chanira C Order Summary\n"
                            + "Fragrance: " + scent + "\n"
                            + "Quantity: " + quantity + "\n"
                            + "Total: KSh " + total);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter a number for quantity!");
                }
            });

            panel.add(scentLabel);
            panel.add(scentBox);
            panel.add(quantityLabel);
            panel.add(quantityField);
            panel.add(priceLabel);
            panel.add(new JLabel(""));
            panel.add(calculateButton);
            panel.add(totalLabel);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
