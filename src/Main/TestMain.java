package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class calculator extends JFrame implements ActionListener{
    static JFrame frame;
    static JTextField textField;
    String operand1,operator,
     operand2 = "";
    calculator() {
        operand1=operator=operand2="";
    }
    public static void main(String[] args){
        frame = new JFrame("Calculator");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        calculator c = new calculator();
        textField = new JTextField(16);
        textField.setEditable(false);

        JButton b_0,b_1,b_2,b_3,b_4,b_5,b_6,b_7,b_8,b_9,b_equal,b_add,b_sub,b_mul,b_div,b_clear,b_dot;

        b_0 = new JButton("0");
        b_1 = new JButton("1");
        b_2 = new JButton("2");
        b_3 = new JButton("3");
        b_4 = new JButton("4");
        b_5 = new JButton("5");
        b_6 = new JButton("6");
        b_7 = new JButton("7");
        b_8 = new JButton("8");
        b_9 = new JButton("9");
        b_add = new JButton("+");
        b_sub = new JButton("-");
        b_mul = new JButton("*");
        b_div = new JButton("/");
        b_equal = new JButton("=");
        b_clear = new JButton("C");
        b_dot = new JButton(".");

        JPanel panel = new JPanel();

        b_0.addActionListener(c);
        b_1.addActionListener(c);
        b_2.addActionListener(c);
        b_3.addActionListener(c);
        b_4.addActionListener(c);
        b_5.addActionListener(c);
        b_6.addActionListener(c);
        b_7.addActionListener(c);
        b_8.addActionListener(c);
        b_9.addActionListener(c);
        b_add.addActionListener(c);
        b_sub.addActionListener(c);
        b_mul.addActionListener(c);
        b_div.addActionListener(c);
        b_equal.addActionListener(c);
        b_clear.addActionListener(c);
        b_dot.addActionListener(c);

        panel.add(textField);
        panel.add(b_add);
        panel.add(b_1);
        panel.add(b_2);
        panel.add(b_3);
        panel.add(b_sub);
        panel.add(b_4);
        panel.add(b_5);
        panel.add(b_6);
        panel.add(b_mul);
        panel.add(b_7);
        panel.add(b_8);
        panel.add(b_9);
        panel.add(b_div);
        panel.add(b_dot);
        panel.add(b_0);
        panel.add(b_clear);
        panel.add(b_equal);

        panel.setBackground(Color.gray);

        frame.add(panel);
        frame.setSize(200,220);
        frame.show();
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!operator.equals(""))
                operand2 = operand2 + s;
            else
                operand1 = operand1 + s;
            textField.setText(operand1 + operator + operand2);
        }
        else if (s.charAt(0) == 'C') {
            operand1 = operator = operand2 = "";
            textField.setText(operand1 + operator + operand2);
        }
        else if (s.charAt(0) == '=') {
            double te;
            switch (operator) {
                case "+":
                    te = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
                    break;
                case "-":
                    te = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
                    break;
                case "/":
                    te = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
                    break;
                default:
                    te = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
                    break;
            }
            textField.setText(operand1 + operator + operand2 + "=" + te);
            operand1 = Double.toString(te);
            operator = operand2 = "";
        }
        else {
            if (operator.equals("") || operand2.equals(""))
                operator = s;
            else {
                double te;
                switch (operator) {
                    case "+":
                        te = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
                        break;
                    case "-":
                        te = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
                        break;
                    case "/":
                        te = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
                        break;
                    default:
                        te = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
                        break;
                }
                operand1 = Double.toString(te);
                operator = s;
                operand2 = "";
            }
            textField.setText(operand1 + operator + operand2);
        }
    }
}
