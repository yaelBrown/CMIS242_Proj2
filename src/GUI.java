import javax.swing.*;

public class GUI extends JFrame {
    static final int WIDTH = 300;
    static final int HEIGHT = 300;

    public GUI() {
        super("Automobile Sales Tax Calculator");
        setFrame(WIDTH, HEIGHT);
    }

    public void display() {
        setVisible(true);
    }

    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
