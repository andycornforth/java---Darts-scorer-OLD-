
package darts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Andy
 */
public class MatchGUI {

    private JFrame f;
    private JPanel p, pMain, pBottom;
    private JButton b1;
    private JLabel lab, lab2, player1Lab, player2Lab, p1Score, p2Score, pic,
            p1Legs, p2Legs, scoreLab, legsLab, p1Average, p2Average, p1Name,
            p2Name, dartAverage, p1lastScore3, p1lastScore2, p1lastScore1,
            p2lastScore3, p2lastScore2, p2lastScore1, scoresLabel, scoresLabel2,
            p1Go, p2Go;
    // add players
    private Player player1 = new Player(1);
    private Player player2 = new Player(2);
    boolean gameOn = true;
    // set whose go it is
    private int go = 1;

    public MatchGUI() {

        gui();
    }

    public void gui() {

        f = new JFrame("Darts 501");
        f.setVisible(true);
        f.setSize(600, 425);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBackground(Color.RED);

        pBottom = new JPanel();
        pBottom.setBackground(Color.RED);

        pMain = new JPanel();
        pMain.setBackground(Color.LIGHT_GRAY);

        // layout
        pMain.setLayout(new GridBagLayout());
        GridBagConstraints gBC = new GridBagConstraints();

        // labels
        lab = new JLabel("Darts Scorer");
        lab2 = new JLabel("Andy Cornforth 2013");
        player1Lab = new JLabel(player1.getName());
        player2Lab = new JLabel(player2.getName());
        // labels for scores
        p1Score = new JLabel(player1.getStringScore());
        p2Score = new JLabel(player2.getStringScore());
        p1Legs = new JLabel(player1.getStringLegs());
        p2Legs = new JLabel(player2.getStringLegs());
        scoreLab = new JLabel("Score");
        legsLab = new JLabel("Legs");
        p1Name = new JLabel(player1.getName());
        p2Name = new JLabel(player2.getName());
        p1Average = new JLabel(player1.average());
        p2Average = new JLabel(player2.average());
        dartAverage = new JLabel("3 Dart Averages");
        p1lastScore3 = new JLabel(player1.getLastScore3());
        p1lastScore2 = new JLabel(player1.getLastScore2());
        p1lastScore1 = new JLabel(player1.getLastScore1());
        p2lastScore3 = new JLabel(player2.getLastScore3());
        p2lastScore2 = new JLabel(player2.getLastScore2());
        p2lastScore1 = new JLabel(player2.getLastScore1());
        scoresLabel = new JLabel(player1.getName());
        scoresLabel2 = new JLabel(player2.getName());
        
        // whos go it is
        if(go == 1){
            p1Go = new JLabel("X");
            p2Go = new JLabel("");
        }else{
            p1Go = new JLabel("");
            p2Go = new JLabel("X");
        }


        /*
         * setting colours
         */
        scoreLab.setForeground(Color.darkGray);
        legsLab.setForeground(Color.darkGray);
        scoresLabel.setForeground(Color.GRAY);
        scoresLabel2.setForeground(Color.GRAY);
        p1lastScore3.setForeground(Color.GRAY);
        p1lastScore2.setForeground(Color.GRAY);
        p1lastScore1.setForeground(Color.GRAY);
        p2lastScore3.setForeground(Color.GRAY);
        p2lastScore2.setForeground(Color.GRAY);
        p2lastScore1.setForeground(Color.GRAY);
        p1Score.setForeground(Color.red);
        p2Score.setForeground(Color.red);
        p1Go.setForeground(Color.white);
        p2Go.setForeground(Color.white);


        // buttons
        JButton player1Input = new JButton("Enter Score");
        JButton player2Input = new JButton("Enter Score");
        JButton newLeg = new JButton("  New Leg   ");
        JButton newMatch = new JButton("New Match");
        JButton name1 = new JButton("Rename P1");
        JButton name2 = new JButton("Rename P2");




        /*
         * ACTION LISTENERS
         * 
         */
        player1Input.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                if (player2.getStringScore().equals("YOU WIN")) {
                    gameOn = false;
                }

                if (gameOn) {

                    String str = JOptionPane.showInputDialog(null, "Enter Score : ",
                            "Please enter a valid score", 1);

                    int score;
                    try {
                        score = Integer.parseInt(str);
                    } catch (Exception e) {
                        score = -1;
                    }
                    player1.visit(score);
                    go = 2;

                    gui();
                }
            }
        });

        player2Input.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                if (player1.getStringScore().equals("YOU WIN")) {
                    gameOn = false;
                }

                if (gameOn) {
                    String str = JOptionPane.showInputDialog(null, "Enter Score : ",
                            "Please enter a valid score", 1);

                    int score;
                    try {
                        score = Integer.parseInt(str);
                    } catch (Exception e) {
                        score = -1;
                    }
                    player2.visit(score);
                    go = 1;


                    gui();
                }
            }
        });

        newLeg.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                gameOn = true;

                player1.setScore(501);
                player2.setScore(501);

                gui();

            }
        });

        newMatch.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                gameOn = true;

                player1.setScore(501);
                player2.setScore(501);
                player1.setLegs(0);
                player2.setLegs(0);

                gui();

            }
        });

        name1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                String str = JOptionPane.showInputDialog(null, "Enter Name : ",
                        "Please enter a name", 1);
                player1.setName(str);

                gui();

            }
        });

        name2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                String str = JOptionPane.showInputDialog(null, "Enter Name : ",
                        "Please enter a name", 1);
                player2.setName(str);

                gui();

            }
        });

        /*
         * 
         * adding buttons and labels to panel in correct position
         * 
         */
        
        p.add(lab);
        pBottom.add(lab2);
        // rename players
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 11;
        pMain.add(name1, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 12;
        pMain.add(name2, gBC);
        // headers
        gBC.weightx = 0.5;
        gBC.gridx = 3;
        gBC.gridy = 0;
        pMain.add(scoreLab, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 0;
        pMain.add(legsLab, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 1;
        gBC.gridy = 1;
        // player 1 information
        pMain.add(player1Lab, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 0;
        gBC.gridy = 1;        
        pMain.add(p1Go, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 2;
        gBC.gridy = 1;
        pMain.add(player1Input, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 3;
        gBC.gridy = 1;
        pMain.add(p1Score, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 1;
        pMain.add(p1Legs, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 1;
        gBC.gridy = 3;
        // player 2 information
        pMain.add(player2Lab, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 0;
        gBC.gridy = 3;        
        pMain.add(p2Go, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 2;
        gBC.gridy = 3;
        pMain.add(player2Input, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 3;
        gBC.gridy = 3;
        pMain.add(p2Score, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 3;
        pMain.add(p2Legs, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 6;
        // new leg and new match buttons
        pMain.add(newLeg, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 7;
        pMain.add(newMatch, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 8;
        // dart averages
        pMain.add(dartAverage, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 3;
        gBC.gridy = 9;
        pMain.add(p1Name, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 9;
        pMain.add(p1Average, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 3;
        gBC.gridy = 10;
        pMain.add(p2Name, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 4;
        gBC.gridy = 10;
        pMain.add(p2Average, gBC);
        // player 1 last scores
        gBC.weightx = 0.5;
        gBC.gridx = 1;
        gBC.gridy = 9;
        pMain.add(scoresLabel, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 1;
        gBC.gridy = 10;
        pMain.add(p1lastScore3, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 1;
        gBC.gridy = 11;
        pMain.add(p1lastScore2, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 1;
        gBC.gridy = 12;
        pMain.add(p1lastScore1, gBC);
        // player 2 last scores
        gBC.weightx = 0.5;
        gBC.gridx = 2;
        gBC.gridy = 9;
        pMain.add(scoresLabel2, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 2;
        gBC.gridy = 10;
        pMain.add(p2lastScore3, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 2;
        gBC.gridy = 11;
        pMain.add(p2lastScore2, gBC);
        gBC.weightx = 0.5;
        gBC.gridx = 2;
        gBC.gridy = 12;
        pMain.add(p2lastScore1, gBC);

        f.add(pBottom, BorderLayout.SOUTH);
        f.add(p, BorderLayout.NORTH);
        f.add(pMain);

    }
}
