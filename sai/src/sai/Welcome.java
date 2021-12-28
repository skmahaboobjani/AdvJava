package sai;

import java.awt.TextField;

import javax.swing.JFrame;

import javax.swing.*;  
public class Welcome {  
JFrame f;  
Welcome(){  
    f=new JFrame();   
    f.setSize(600,800);
    TextField t=new TextField();
    t.setBounds(50, 100, 30, 10);
    f.add(t);
    String name=JOptionPane.showInputDialog(f,"Enter Name");   
    JOptionPane.showMessageDialog(f," Welcome "+name);   
}  
public static void main(String[] args) {  
    new Welcome();  
}  
}  




 /*class Label extends JFrame {
    private JLabel text;
    private JLabel text1;
    private TextField tf;
    public Label() {
        super("JLabel Demo");
        setLayout(new FlowLayout());
        text = new JLabel("Enter Name.");
       // text.setToolTipText("Mouse is being hovered on text");
        add(text);
        tf=new TextField();
        add(tf);
        tf.setSize(100,100);
        JOptionPane.showMessageDialog(this, tf.getText());
    }
}


public class Welcome {
    public static void main (String args []) {
        Label Object = new Label();
        Object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object.setSize(400,500);
        Object.setVisible(true);
    }
}
*/
