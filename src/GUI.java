import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
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

    private JTextArea textArea() {
        JTextArea out = new JTextArea();
        out.setLineWrap(true);
        out.setWrapStyleWord(true);
        out.setEditable(true);
        out.setBounds(50,50,200,200);

        return out;
    }

    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(5,2));

        JTextArea mmInput = textArea();
        JTextArea salesPriceInput = textArea();
        JTextArea mpgInput = textArea();
        JTextArea weightInput = textArea();

//        JButton button = new JButton("This is a button");
//        ActionListener al = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button was pressed !");
//            }
//        };
//
//        button.addActionListener(al);

        ButtonGroup autoType = new ButtonGroup();
        JRadioButton hybridBtn = new JRadioButton("Hybrid");
        JRadioButton electricBtn = new JRadioButton("Electric");
        JRadioButton otherBtn = new JRadioButton("Other");
        otherBtn.isSelected();
        autoType.add(hybridBtn);
        autoType.add(electricBtn);
        autoType.add(otherBtn);

        JPanel radioPanel = new JPanel(new GridLayout(3,1));
        radioPanel.add(hybridBtn);
        radioPanel.add(electricBtn);
        radioPanel.add(otherBtn);

        JLabel mmLabel = new JLabel("Make and Model", JLabel.CENTER);
        mmLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel salesPriceLabel = new JLabel("Sales Price", JLabel.CENTER);
        salesPriceLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel mpgLabel = new JLabel("Miles Per Gallon", JLabel.RIGHT);
        JLabel weightLabel = new JLabel("Weight in Pounds", JLabel.RIGHT);

        JLabel displayTax = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
        displayTax.setBorder(border);
        displayTax.setPreferredSize(new Dimension(100, 25));


        JButton computeBtn = new JButton("Compute Sales Tax");
        ActionListener computeTax = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int p = 0;

                    if (salesPriceInput.getText().isBlank() || salesPriceInput.getText().isEmpty()) {
                        p = 1;
                    } else {
                        p = Integer.parseInt(salesPriceInput.getText());
                    }

                    double res = 0.0;

                    if (otherBtn.isSelected()) {
                        res = p * .05;
                        Automobile temp = new Automobile(mmInput.getText(), (double) p);
                        Project2.autos.add(temp);
                    } else if (electricBtn.isSelected()) {
                        if (Integer.parseInt(weightInput.getText()) < 3000) {
                            res = (p * .05) - 200;
                        } else {
                            res = (p * .05) - 150;
                        }
                        Automobile temp = new Electric(mmInput.getText(), (double) p, Integer.parseInt(weightInput.getText()));
                        Project2.autos.add(temp);
                    } else if (hybridBtn.isSelected()) {
                        if (Integer.parseInt(mpgInput.getText()) < 40) {
                            res = (p * .05) - 100;
                        } else {
                            res = (p * .05) - ((Integer.parseInt(mpgInput.getText()) - 40) * 2);
                        }
                        Automobile temp = new Hybrid(mmInput.getText(), (double) p, Integer.parseInt(mpgInput.getText()));
                        Project2.autos.add(temp);
                    } else {
                        res = 0.0;
                        System.out.println("A radio button must be selected");
                    }
                    displayTax.setText(String.valueOf(res));
                } catch (NumberFormatException exception) {
                    System.out.println(exception);
                    System.out.println("One of your values was not a number");
                    System.out.println("salesPriceInput.getText() = " + salesPriceInput.getText());
                    System.out.println("mpgInput.getText() = " + mpgInput.getText());
                    System.out.println("weightInput.getText() = " + weightInput.getText());
                }
            }
        };
        computeBtn.addActionListener(computeTax);

        JButton clearBtn = new JButton("Clear Fields");
        ActionListener clear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mmInput.setText("");
                salesPriceInput.setText("");
                otherBtn.isSelected();
                mpgInput.setText("");
                weightInput.setText("");
            }
        };
        clearBtn.addActionListener(clear);

        JButton displayRepBtn = new JButton("Display Report");
        ActionListener displayRep = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Project2.displayReport();
            }
        };
        displayRepBtn.addActionListener(displayRep);

        JPanel row1 = new JPanel();
        row1.add(mmLabel);
        row1.add(mmInput);

        JPanel row2 = new JPanel();
        row2.add(salesPriceLabel);
        row2.add(salesPriceInput);

        JPanel row3 = new JPanel(new GridLayout(1,2));
        row3.add(radioPanel);

        JPanel row3a = new JPanel(new GridLayout(1,2));
        row3a.add(mpgLabel);
        row3a.add(mpgInput);

        JPanel row3b = new JPanel(new GridLayout(1,2));
        row3b.add(weightLabel);
        row3b.add(weightInput);

        JPanel row3right = new JPanel();
        row3right.add(row3a);
        row3right.add(row3b);

        row3.add(row3right);

        JPanel row4 = new JPanel();
        row4.add(computeBtn);
        row4.add(displayTax);

        JPanel row5 = new JPanel();
        row5.add(clearBtn);
        row5.add(displayRepBtn);

        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);
    }
}
