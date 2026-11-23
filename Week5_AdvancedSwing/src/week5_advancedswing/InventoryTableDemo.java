
package week5_advancedswing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryTableDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Chanira C Inventory");
            frame.setSize(650, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String[] columns = {
                "Product", "Price (KSh)", "Stock"
            };

            Object[][] products = {
                {"Vanilla Sugar", 450, 20},
                {"Mulberry", 450, 15},
                {"Burgundy", 450, 12},
                {"Pecan", 350, 10},
                {"Asali", 350, 8}
            };

            DefaultTableModel model =
                    new DefaultTableModel(products, columns) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            JTable table = new JTable(model);
            table.setRowHeight(30);

            JScrollPane scrollPane = new JScrollPane(table);

            JLabel titleLabel = new JLabel(
                    "Chanira C Product Inventory",
                    SwingConstants.CENTER
            );
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

            JButton addButton = new JButton("Add Product");

            addButton.addActionListener(e -> {

                String name = JOptionPane.showInputDialog(
                        frame, "Enter product name:"
                );

                if (name == null || name.trim().isEmpty()) {
                    return;
                }

                try {
                    String priceInput = JOptionPane.showInputDialog(
                            frame, "Enter price:"
                    );

                    if (priceInput == null) {
                        return;
                    }

                    int price = Integer.parseInt(priceInput);

                    String stockInput = JOptionPane.showInputDialog(
                            frame, "Enter stock quantity:"
                    );

                    if (stockInput == null) {
                        return;
                    }

                    int stock = Integer.parseInt(stockInput);

                    if (price < 0 || stock < 0) {
                        JOptionPane.showMessageDialog(
                                frame, "Price and stock cannot be negative."
                        );
                        return;
                    }

                    model.addRow(new Object[]{
                        name, price, stock
                    });

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            frame, "Please enter valid numbers."
                    );
                }
            });

            JPanel panel = new JPanel(new BorderLayout(10, 10));
            panel.setBorder(
                    BorderFactory.createEmptyBorder(15, 15, 15, 15)
            );

            panel.add(titleLabel, BorderLayout.NORTH);
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(addButton, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
