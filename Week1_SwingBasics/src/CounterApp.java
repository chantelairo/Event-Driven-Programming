
import javax.swing.*;

public class CounterApp {

    static int count = 0;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Counter Application");
            frame.setSize(400, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();

            JLabel label = new JLabel("Count: 0");
            JButton button = new JButton("Increase Count");

            button.addActionListener(e -> {
                count++;
                label.setText("Count: " + count);
            });

            panel.add(label);
            panel.add(button);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}
