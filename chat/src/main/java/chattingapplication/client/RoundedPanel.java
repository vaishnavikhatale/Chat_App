package chattingapplication.client;



import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private Color backgroundColor;
    private int cornerRadius = 15;

    public RoundedPanel(LayoutManager layout, int radius) {

        super(layout);

        cornerRadius = radius;
    }

    public RoundedPanel(LayoutManager layout,
                        int radius,
                        Color bgColor) {

        super(layout);

        cornerRadius = radius;

        backgroundColor = bgColor;
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Dimension arcs =
                new Dimension(cornerRadius, cornerRadius);

        Graphics2D graphics =
                (Graphics2D) g;

        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(backgroundColor);

        graphics.fillRoundRect(0, 0,
                getWidth()-1,
                getHeight()-1,
                arcs.width,
                arcs.height);
    }
}