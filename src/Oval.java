import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Oval extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (MyApp.pos.x == -100 && MyApp.pos.y == -100) {
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(MyApp.pos.getX(), MyApp.pos.getY(), 30, 30);
        g2d.draw(circle);
        repaint();
    }
}

