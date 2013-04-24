package darts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andy
 */
public class StartScreen {

    private JFrame f;
    private JPanel p, pBottom;
    private JPanel pMain;
    private JButton b1;
    private JLabel lab, label, lab2;

    public StartScreen() {
        gui();
    }

    public void gui() {

        f = new JFrame("Darts");
        f.setVisible(true);
        f.setSize(600, 425);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBackground(Color.RED);
        
        pBottom = new JPanel();
        pBottom.setBackground(Color.RED);


        pMain = new JPanel();
        pMain.setBackground(Color.LIGHT_GRAY);

        b1 = new JButton("Start 501 Leg");
        lab = new JLabel("Darts Scorer");
        lab2 = new JLabel("Andy Cornforth 2013");
        
        /*
         * action listeners
         */

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                MatchGUI w = new MatchGUI();

            }
        });
        
       // add picture
       label = new JLabel(new ImageIcon("C:/Users/Andy/Documents/Home/Darts/src/darts/image.png"));
       
       /*
        * add component to panels and frame
        */
                
        pMain.add(b1);

        p.add(lab);       
        pMain.add(label);
        pBottom.add(lab2);

        f.add(p, BorderLayout.NORTH);
        f.add(pBottom, BorderLayout.SOUTH);
        f.add(pMain);
    }
}
