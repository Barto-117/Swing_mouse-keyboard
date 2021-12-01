import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyApp extends JFrame {
    JButton bRun, bCancel;
    JPanel p;


    public MyApp() {

        setExtendedState (JFrame.MAXIMIZED_BOTH);
        setTitle("Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);


        p = new JPanel(null);
        p.setOpaque(true);
        p.setBackground(Color.GRAY);
        add(p);

        bRun = new JButton("RUN");
        add(bRun);
        bRun.setBounds(600,710,100,50);
        bRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Point x = getMousePosition();
                if (x.getX() > bRun.getX() + 50 ){
                    super.mouseEntered(e);
                    bRun.setLocation((int) (20 + Math.random() * 1400), (int) (20 + Math.random() * 710));
                }
            }
        });

        bCancel = new JButton("Cancel");
        add(bCancel);
        bCancel.setBounds(840,710,100,50);
        bCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                bRun.setLocation(600, 710);
            }
        });


    }

    static public void main(String[] args) {
        EventQueue.invokeLater(MyApp::new);
    }
}
