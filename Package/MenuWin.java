package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuWin extends MainWindow implements ActionListener{
    JButton beginnerButton;
    JButton mediumButton;
    JButton advancedButton;
    JButton exitButton;
    JLabel minesweeperLabel;
    public MenuWin(){
        super();
        initComponents();


    }
    public void initComponents(){

        minesweeperLabel = new JLabel("Minesweeper");
        beginnerButton = new JButton("Beginner");
        mediumButton = new JButton("Medium");
        advancedButton = new JButton("Advanced");
        exitButton = new JButton("Exit");

        Container container = this.getContentPane();
        container.setLayout(null);

        minesweeperLabel.setLocation(262,150);
        minesweeperLabel.setSize(100,50);
        beginnerButton.setLocation(250,250);
        beginnerButton.setSize(100,50);
        mediumButton.setLocation(250,350);
        mediumButton.setSize(100,50);
        advancedButton.setLocation(250,450);
        advancedButton.setSize(100,50);
        exitButton.setLocation(250,650);
        exitButton.setSize(100,50);

        beginnerButton.addActionListener(this);
        mediumButton.addActionListener(this);
        advancedButton.addActionListener(this);
        exitButton.addActionListener(this);


        container.add(minesweeperLabel);
        container.add(beginnerButton);
        container.add(mediumButton);
        container.add(advancedButton);
        container.add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==beginnerButton){
            new BegiWin().setVisible(true);
            this.dispose();
        }
        if(e.getSource()==mediumButton){

            new BegiWin().setVisible(true);
            this.dispose();
        }
        if(e.getSource()==advancedButton){

            new AdvWin().setVisible(true);
            this.dispose();
        }
        if(e.getSource()==exitButton){

            this.dispose();
        }
    }
}
