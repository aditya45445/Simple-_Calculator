//Advance Calculator Creation

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame implements ActionListener{
    
    //Creating extra variable to store operator,num1,num2 and thier result values
    char opr;
    Double num1,num2,result;

    //Creating TextField to show the values and buttons to interact
    JTextField screen;
    JButton numBtn[] = new JButton[10];
    JButton btnPlus,btnMinus,btnMult,btnDiv,btnRem,btnZero,btnEqual,btnDec,btnAC,btnDel,btnSqrt;

    Font ff1 = new Font("Ink.Free",Font.BOLD,35);
    Font ff2 = new Font("Ink.Free",Font.BOLD,20);

    JPanel panel;

    //Creating Constructor
    MainUI(){
        setTitle("Calculator");
        setIconImage(new ImageIcon("image\\calc-preview.png").getImage());
        setSize(400,560);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(new Color(66, 63, 63));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        screen = new JTextField("");
        screen.setFont(ff1);
        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.RIGHT); //Starting the values from the right side
        screen.setBounds(25,25,340,50);
        add(screen);

        panel = new JPanel(); //Creating an extra panel for the buttons position
        panel.setBounds(25,100,340,390);
        panel.setLayout(new GridLayout(5,4));
        add(panel);

        //Assigning the buttons of 1 to 10 properties
        for(int i = 1;i<10;i++) {
            numBtn[i] = new JButton(String.valueOf(i));
            panel.add(numBtn[i]);
            numBtn[i].setFont(ff2);
            numBtn[i].setBackground(new Color(40,40,40));
            numBtn[i].setForeground(Color.WHITE);

            numBtn[i].addActionListener(this);
        }

        //Plus Button
        btnPlus = new JButton("+");
        btnPlus.setFont(ff2);
        btnPlus.setBackground(new Color(40,40,40));
        btnPlus.setForeground(Color.GREEN);

        //Minus Button
        btnMinus = new JButton("-");
        btnMinus.setFont(ff2);
        btnMinus.setBackground(new Color(40,40,40));
        btnMinus.setForeground(Color.GREEN);

        //Multiply Button
        btnMult = new JButton("x");
        btnMult.setFont(ff2);
        btnMult.setBackground(new Color(40,40,40));
        btnMult.setForeground(Color.GREEN);

        //Division Button
        btnDiv = new JButton("/");
        btnDiv.setFont(ff2);
        btnDiv.setBackground(new Color(40,40,40));
        btnDiv.setForeground(Color.GREEN);

        //Remainder Button
        btnRem = new JButton("%");
        btnRem.setFont(ff2);
        btnRem.setBackground(new Color(40,40,40));
        btnRem.setForeground(Color.GREEN);

        //Zero Button
        btnZero = new JButton("0");
        btnZero.setFont(ff2);
        btnZero.setBackground(new Color(40,40,40));
        btnZero.setForeground(Color.WHITE);

        //Equal Button
        btnEqual = new JButton("=");
        btnEqual.setFont(ff2);
        btnEqual.setBackground(Color.ORANGE);
        btnEqual.setForeground(Color.WHITE);

        //Decimal Button
        btnDec = new JButton(".");
        btnDec.setFont(ff2);
        btnDec.setBackground(new Color(40,40,40));
        btnDec.setForeground(Color.WHITE);

        //All Clear(AC) Button
        btnAC = new JButton("AC");
        btnAC.setFont(ff2);
        btnAC.setBackground(new Color(40,40,40));
        btnAC.setForeground(Color.GREEN);

        //C Button
        btnSqrt = new JButton("√");
        btnSqrt.setFont(ff2);
        btnSqrt.setBackground(new Color(40,40,40));
        btnSqrt.setForeground(Color.GREEN);

        //Delete Button
        btnDel = new JButton("DEL");
        btnDel.setFont(ff2);
        btnDel.setBackground(new Color(40,40,40));
        btnDel.setForeground(Color.GREEN);

        panel.add(btnAC);
        panel.add(btnDel);
        panel.add(btnSqrt);
        panel.add(btnDiv);
        panel.add(numBtn[7]);
        panel.add(numBtn[8]);
        panel.add(numBtn[9]);
        panel.add(btnMult);
        panel.add(numBtn[4]);
        panel.add(numBtn[5]);
        panel.add(numBtn[6]);
        panel.add(btnMinus);
        panel.add(numBtn[3]);
        panel.add(numBtn[2]);
        panel.add(numBtn[1]);
        panel.add(btnPlus);
        panel.add(btnZero);
        panel.add(btnDec);
        panel.add(btnEqual);
        panel.add(btnRem);

        btnZero.addActionListener(this);
        btnDec.addActionListener(this);
        btnAC.addActionListener(this);
        btnDel.addActionListener(this);
        btnSqrt.addActionListener(this);
        btnRem.addActionListener(this);
        btnDiv.addActionListener(this);
        btnMult.addActionListener(this);
        btnMinus.addActionListener(this);
        btnPlus.addActionListener(this);
        btnEqual.addActionListener(this);
    }

    //ActionListener implementation for Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        //For buttons 1 to 10
        for(int i=1;i<10;i++){
            if(e.getSource() == numBtn[i]){
                screen.setText(screen.getText().concat(String.valueOf(i)));
            }
        }
        //For Button Zero
        if(e.getSource() == btnZero){
            screen.setText(screen.getText().concat("0"));
        }
        //For Decimal Button
        if(e.getSource() == btnDec){
            screen.setText(screen.getText().concat("."));
        }
        //For All Clear Button
        if(e.getSource() == btnAC){
            screen.setText("");
        }
        //For Delete Button
        if(e.getSource() == btnDel){
            String backspace = null;
            if(screen.getText().length()>0){
                StringBuilder str = new StringBuilder(screen.getText());
                str.deleteCharAt(screen.getText().length()-1);
                backspace = str.toString();
                screen.setText(backspace);
            }
        }
        //For Plus Button
        if(e.getSource() == btnPlus){
            num1 = Double.parseDouble(screen.getText());
            opr='+';
            screen.setText("");
        }
        //For Minus Button
        if(e.getSource() == btnMinus){
            num1 = Double.parseDouble(screen.getText());
            opr='-';
            screen.setText("");
        }
        //For Multiplication Button
        if(e.getSource() == btnMult){
            num1 = Double.parseDouble(screen.getText());
            opr='*';
            screen.setText("");
        }
        //For Division Button
        if(e.getSource() == btnDiv){
            num1 = Double.parseDouble(screen.getText());
            opr='/';
            screen.setText("");
        }
        //For Remainder Button
        if(e.getSource() == btnRem){
            num1 = Double.parseDouble(screen.getText());
            opr='%';
            screen.setText("");
        }
        //For Square Root Button
        if (e.getSource() == btnSqrt) {
            num1 = Double.parseDouble(screen.getText());
            result = Math.sqrt(num1);
            screen.setText(String.valueOf(result));
        }
        //For Equalstoo Button
        if(e.getSource() == btnEqual){
            try {
                num2 = Double.parseDouble(screen.getText());

                switch(opr){
                    case '+':
                        result = num1+num2;
                        break;

                    case '-':
                        result = num1-num2;
                        break;

                    case '*':
                        result = num1*num2;
                        break;

                    case '/':
                        result = num1--/num2;
                        break;

                    case '%':
                        result = num1%num2;
                        break;
                }
                screen.setText(String.valueOf(result));
                num1 = result;
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"OPERATOR ERROR");
                screen.setText("");
            }
        }
    }

    //Main method
    public static void main(String[] args){
        @SuppressWarnings("unused")
        MainUI m = new MainUI();
    }
}