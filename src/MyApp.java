import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyApp extends JFrame {
    JButton bRun, bCancel;
    JPanel p;
    static Point pos = new Point(-100,-100);

    public MyApp() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pos.x = e.getX();
                pos.y = e.getY();
                System.out.println(pos.getX() + "," + pos.getY());
            }
        });

        p = new JPanel(null);
        p.setOpaque(true);
        add(p);

        p.setFocusable(true);
        p.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char m = e.getKeyChar();
                if (m == 111) {
                    System.out.println("o");
                    Oval o = new Oval();
                    o.paintComponent(getGraphics());
                }
                if (m == 107) {
                    System.out.println("k");
                    Square s = new Square();
                    p.add(s);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        bRun = new JButton("RUN");
        add(bRun);
        bRun.setBounds(600, 710, 100, 50);
        bRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Point x = getMousePosition();
                if (x.getX() > bRun.getX() + 50) {
                    super.mouseEntered(e);
                    bRun.setBackground(Color.GREEN);
                    bRun.setLocation((int) (20 + Math.random() * 1400), (int) (20 + Math.random() * 710));
                    return;
                }
                bRun.setBackground(Color.RED);
            }
        });

        bCancel = new JButton("Cancel");
        add(bCancel);
        bCancel.setBounds(840, 710, 100, 50);
        bCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                bRun.setLocation(600, 710);
            }
        });

    }
}
