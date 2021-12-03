import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyApp extends JFrame {
    JButton bRun, bCancel;

    Kanwa k;
    int x;
    int y;


    public MyApp() {


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        setFocusable(true);

        k = new Kanwa();
        k.setOpaque(true);
        k.setBackground(Color.cyan);
        add(k);

        k.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                System.out.println(x + "," + y);
            }
        });

        bRun = new JButton("RUN");
        k.add(bRun);
        bRun.setBackground(Color.white);
        bRun.setBounds(610, 710, 100, 50);
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
        k.add(bCancel);
        bCancel.setBackground(Color.white);
        bCancel.setBounds(840, 710, 100, 50);
        bCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                bRun.setBackground(Color.white);
                bRun.setLocation(600, 710);
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char m = e.getKeyChar();
                switch (m) {
                    case 'o':
                        k.pointsO.add(new Point(x, y));
                        break;
                    case 'k':
                        k.pointsS.add(new Point(x, y));
                        break;
                }
            }
        });

    }
}