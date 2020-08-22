package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellPanel extends JPanel implements ActionListener {
    Timer tm = new Timer(1000, this);
    //public int size = 0;
    //public int seed;
    private int boxSize = 20;
    Universe game = new Universe();
    String[][] beginningUniverse;//= game.creatingUniverse();;
    JLabel generationLabel;
    JLabel aliveLabel;
    int count = 1;


    CellPanel(JLabel generationLabel, JLabel aliveLabel) {
        //this.size = size;
        //this.seed = seed;
        this.generationLabel = generationLabel;
        this.aliveLabel = aliveLabel;
        beginningUniverse = game.creatingUniverse();
        tm.start();
    }
    public void paint(Graphics g)
    {
        int x = 0;
        int y = 0;
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        //game.displayAll(beginningUniverse);

        for (int row = 0; row < beginningUniverse.length; row++) {
            for (int col = 0; col < beginningUniverse.length; col++) {
                x = col * boxSize;
                y = row * boxSize;
                g.drawRect(x, y, boxSize, boxSize);
                if (beginningUniverse[row][col].equals("O")) {
                    g.fillRect(x, y, boxSize, boxSize);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tm) {
            String[][] nextGeneration;
            if (count == 1) {
                nextGeneration = beginningUniverse;
            } else {
                nextGeneration = game.displayCurrent(beginningUniverse);
            }

            repaint();
            for (int i = 0; i < beginningUniverse.length; i++) {
                for (int j = 0; j < beginningUniverse.length; j++) {
                    beginningUniverse[i][j] = nextGeneration [i][j];
                }
            }

            generationLabel.setText("Generation #" + count);
            aliveLabel.setText("Alive: " + game.countAlive(beginningUniverse));
            count++;

        }
    }
}


