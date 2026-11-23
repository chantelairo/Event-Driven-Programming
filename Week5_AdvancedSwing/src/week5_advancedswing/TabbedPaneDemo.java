
package week5_advancedswing;

import javax.swing.*;
import java.awt.*;

public class TabbedPaneDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Chanira C Dashboard");
            frame.setSize(500, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JTabbedPane tabs = new JTabbedPane();

            // Products tab
            JPanel productsPanel = new JPanel();
            productsPanel.setLayout(new GridLayout(4, 1, 10, 10));

            productsPanel.add(new JLabel("Chanira C Products"));
            productsPanel.add(new JLabel("Vanilla Sugar - Sweet and creamy"));
            productsPanel.add(new JLabel("Mulberry - Sweet and bold"));
            productsPanel.add(new JLabel("Burgundy - Soft and romantic"));

            // Orders tab
            JPanel ordersPanel = new JPanel();
            ordersPanel.setLayout(new FlowLayout());

            JLabel orderLabel = new JLabel("Total Orders: 0");
            JButton orderButton = new JButton("Add Order");

            final int[] orders = {0};

            orderButton.addActionListener(e -> {
                orders[0]++;
                orderLabel.setText("Total Orders: " + orders[0]);
            });

            ordersPanel.add(orderLabel);
            ordersPanel.add(orderButton);

            // Customers tab
            JPanel customersPanel = new JPanel();
            customersPanel.setLayout(new FlowLayout());

            customersPanel.add(
                new JLabel("Welcome to Chanira C Customer Management!")
            );

            JButton customerButton = new JButton("View Customers");

            customerButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                    frame,
                    "Customer records will appear here."
                );
            });

            customersPanel.add(customerButton);

            // Add tabs to dashboard
            tabs.addTab("Products", productsPanel);
            tabs.addTab("Orders", ordersPanel);
            tabs.addTab("Customers", customersPanel);

            frame.add(tabs);
            frame.setVisible(true);
        });
    }
}
