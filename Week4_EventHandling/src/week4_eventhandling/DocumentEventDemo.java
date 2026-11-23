
package week4_eventhandling;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class DocumentEventDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Chanira C Caption Counter");
            frame.setSize(450, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new BorderLayout(10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel titleLabel = new JLabel(
                    "Write your Chanira C Instagram caption:"
            );

            JTextArea captionArea = new JTextArea();
            captionArea.setLineWrap(true);
            captionArea.setWrapStyleWord(true);

            JLabel countLabel = new JLabel("Characters: 0");

            captionArea.getDocument().addDocumentListener(
                    new DocumentListener() {

                public void insertUpdate(DocumentEvent e) {
                    updateCount();
                }

                public void removeUpdate(DocumentEvent e) {
                    updateCount();
                }

                public void changedUpdate(DocumentEvent e) {
                    updateCount();
                }

                private void updateCount() {
                    int count = captionArea.getText().length();
                    countLabel.setText("Characters: " + count);
                }
            });

            panel.add(titleLabel, BorderLayout.NORTH);
            panel.add(new JScrollPane(captionArea), BorderLayout.CENTER);
            panel.add(countLabel, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
