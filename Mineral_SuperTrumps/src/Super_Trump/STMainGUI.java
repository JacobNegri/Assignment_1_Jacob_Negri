package Super_Trump;

//import cp2406_2016.ch14_swing.MyActivateButtno;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jnegr3 on 22/10/2016.
 */
public class STMainGUI extends JFrame {

    JLabel question = new JLabel("What is your name?");
    Font bigFont = new Font("Arial", Font.BOLD, 16);
    JTextField answer = new JTextField(10);
    JButton pressMe = new JButton("Press me");
    JLabel greeting = new JLabel("");
    final int WIDTH = 275;
    final int HEIGHT = 225;


    public static void main(String[] args) {
        STMainGUI frame = new STMainGUI();
        frame.setVisible(true);
    }

    public STMainGUI() {

        super("Hello Frame");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        question.setFont(bigFont);
        greeting.setFont(bigFont);
        add(question, BorderLayout.NORTH);
        add(answer);
        add(pressMe);
        pressMe.setToolTipText("I do not have any info, sorry");
        add(greeting, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pressMe.addActionListener((e));
    }
////        pressMe.addActionListener - {
////
////        }
//        pressMe.addActionListener(new MyActivateButtno());
    public void actionPerformed(ActionEvent e)
    {
        String name = answer.getText();
        String greet = "Hello, " + name;
        greeting.setText(greet);
    }


}