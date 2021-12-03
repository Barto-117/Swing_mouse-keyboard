import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Kanwa extends JPanel {
    public ArrayList<Point> pointsS = new ArrayList<>();
    public ArrayList<Point> pointsO = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawRect(g2d);
        repaint();

        drawOval(g2d);
        repaint();
    }

    private void drawOval(Graphics2D g2d) {
        for(Point p: pointsO) {
            int x = (int) p.getX();
            int y = (int) p.getY();
            g2d.fillOval(x,y,40,40);
        }
    }

    private void drawRect(Graphics2D g2d) {
        for(Point p: pointsS) {
            int x = (int) p.getX();
            int y = (int) p.getY();
            g2d.fillRect(x, y, 30, 30);
        }
    }
}
