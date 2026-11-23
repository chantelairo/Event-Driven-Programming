
import javax.swing.*;

public class MySwingApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("My First Swing Application");

            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();

            JLabel label = new JLabel("Click the button!");
            JButton button = new JButton("Click Me");

            button.addActionListener(e -> {
                label.setText("Button clicked!");
            });

            panel.add(label);
            panel.add(button);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}
