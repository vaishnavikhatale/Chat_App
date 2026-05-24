package chattingapplication.client;



import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        Color color1 = new Color(20,20,20);
        Color color2 = new Color(0,255,255);

        GradientPaint gp =
                new GradientPaint(
                        0,0,color1,
                        width,height,color2);

        g2d.setPaint(gp);

        g2d.fillRect(0,0,width,height);
    }
}
