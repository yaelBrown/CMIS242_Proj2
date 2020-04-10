import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    static final int WIDTH = 500;
    static final int HEIGHT = 500;

    public GUI() {
        super("Automobile Sales Tax Calculator");
        setFrame(WIDTH, HEIGHT);
    }

    public void display() {
        setVisible(true);
    }

    private void setFrame(int width, int height) {
        JTextArea textArea = new JTextArea("this is some text");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);
        textArea.setBounds(50,50,200,200);

        JButton button = new JButton("This is a button");
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button was pressed !");
            }
        };

        button.addActionListener(al);

        JLabel label = new JLabel("Whats up ?", JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);


        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textArea);
        panel.add(button);

        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(panel);

    }

}
