package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame {

    // GameOfLife uses Swing framework to display UI to user

    JLabel generationLabel;
    JLabel aliveLabel;

    CellPanel cellPanel;

    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JToggleButton playButton = new JToggleButton();
        playButton.setName("PlayToggleButton");
        playButton.setText("Pause/Restart");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playButton.isSelected()) {
                    playButton.setText("Restart");
                    cellPanel.tm.stop();
                } else {
                    playButton.setText("Pause");
                    cellPanel.tm.start();
                }
            }
        });

        add(playButton);

        JButton resetButton = new JButton();
        resetButton.setName("ResetButton");
        resetButton.setText("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameOfLife newGame = new GameOfLife();
            }
        });
        add(resetButton);

        generationLabel = new JLabel();
        generationLabel.setName("GenerationLabel");
        generationLabel.setText("Generation #");
        add(generationLabel);

        aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");
        aliveLabel.setText("Alive: ");
        add(aliveLabel);

        add(Box.createRigidArea(new Dimension(10,0)));
        cellPanel = new CellPanel(generationLabel, aliveLabel);
        cellPanel.setName("cellPanel");

        add(cellPanel);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);

    }

    public static void main(String[] args) throws InterruptedException {

        new GameOfLife();

    }
}
