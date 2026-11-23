
package week5_advancedswing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class ProductTreeDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Chanira C Product Categories");
            frame.setSize(450, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Main category
            DefaultMutableTreeNode root =
                new DefaultMutableTreeNode("Chanira C Products");

            // Women's fragrances
            DefaultMutableTreeNode women =
                new DefaultMutableTreeNode("Women's Fragrances");

            women.add(new DefaultMutableTreeNode("Vanilla Sugar"));
            women.add(new DefaultMutableTreeNode("Mulberry"));
            women.add(new DefaultMutableTreeNode("Burgundy"));

            // Men's fragrances
            DefaultMutableTreeNode men =
                new DefaultMutableTreeNode("Men's Fragrances");

            men.add(new DefaultMutableTreeNode("Pecan"));
            men.add(new DefaultMutableTreeNode("Asali"));

            root.add(women);
            root.add(men);

            // Create the tree
            JTree productTree = new JTree(root);

            JLabel result = new JLabel(
                "Select a product from the tree",
                SwingConstants.CENTER
            );

            // Respond when a product is selected
            productTree.addTreeSelectionListener(e -> {

                DefaultMutableTreeNode selected =
                    (DefaultMutableTreeNode)
                    productTree.getLastSelectedPathComponent();

                if (selected != null && selected.isLeaf()) {
                    result.setText(
                        "Selected Product: " + selected.toString()
                    );
                }
            });

            JScrollPane scrollPane =
                new JScrollPane(productTree);

            JLabel title = new JLabel(
                "Chanira C Product Categories",
                SwingConstants.CENTER
            );

            JPanel panel = new JPanel(new BorderLayout(10, 10));
            panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
            );

            panel.add(title, BorderLayout.NORTH);
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(result, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
