package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import static life.Universe.*;

public class GameOfLife extends JFrame implements ActionListener{

    // GameOfLife uses Swing framework to display UI to user
    //JFrame frame;
    JLabel generationLabel;
    JLabel aliveLabel;
    private Timer timer;



    public GameOfLife() throws InterruptedException {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        //frame.setLocationRelativeTo(null);
        //frame.setVisible(true);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(0,2));



        generationLabel = new JLabel();
        generationLabel.setName("GenerationLabel");
        //generationLabel.setText("Generation #" + generations);
        controlPanel.add(generationLabel);

        aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");
        //aliveLabel.setText("Alive: " + alive);
        controlPanel.add(aliveLabel);


        JToggleButton playButton = new JToggleButton();
        playButton.setName("PlayToggleButton");
        playButton.setText("Pause/Restart");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean paused = true;
                if (playButton.isSelected()) {
                    playButton.setText("Restart");
                } else {
                    paused = false;
                    playButton.setText("Paused");
                }
            }
        });
        controlPanel.add(playButton);

        JButton resetButton = new JButton();
        resetButton.setName("ResetButton");
        resetButton.setText("Reset");
        controlPanel.add(resetButton);


        add(controlPanel);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {


        Scanner scn = new Scanner(System.in);
        int size = 10;  //scn.nextInt();
        long seed = 10;  //scn.nextInt();
        int generation = 100; // scn.nextInt();
        Universe universe = new Universe();
        universe.setSize(size);
        universe.setSeed(seed);
        universe.setGenerations(generation);

        String[][] newUniverse = universe.creatingUniverse();
        //universe.displayGenerations(newUniverse);
        System.out.println();
        String[][] resultingUniverse = universe.endState(newUniverse);
        universe.displayGenerations(resultingUniverse);








    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}