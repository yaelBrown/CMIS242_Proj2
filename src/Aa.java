import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aa implements ActionListener {

    private int numOfClicks = 0;

    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public Aa() {
        frame = new JFrame();

        JButton button = new JButton("button :)");
        button.addActionListener(this);
        label = new JLabel("Number of clicks: ");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300,300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setTitle("This is title");
        frame.pack();
        frame.setVisible(true);

        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        numOfClicks++;
        label.setText("Number of clicks: " + this.numOfClicks);
    }

    public static void main(String[] args) {
        new Aa();
    }

}
