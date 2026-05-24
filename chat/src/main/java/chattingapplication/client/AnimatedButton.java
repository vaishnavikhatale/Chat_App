package chattingapplication.client;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedButton extends JButton {

    Color normal = new Color(0,255,255);
    Color hover = new Color(0,180,180);

    public AnimatedButton(String text){

        super(text);

        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.BLACK);
        setFont(new Font("Arial",Font.BOLD,18));
        setBackground(normal);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                setBackground(hover);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                setBackground(normal);
            }
        });
    }
}