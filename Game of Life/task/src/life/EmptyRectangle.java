package life;

import javax.swing.*;
import java.awt.*;

public class EmptyRectangle extends JPanel{

    private int squareX = 0;
    private int squareY = 0;
    private int squareW = 20;
    private int squareH = 20;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // do your superclass's painting routine first, and then paint on top of it.
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);
    }

}