package chattingapplication.client;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MessageBubble extends JPanel {

    public MessageBubble(String text, boolean isSender) {

        setLayout(new BorderLayout());

        setOpaque(false);

        JLabel label =
                new JLabel("<html>"+text+"</html>");

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        17
                )
        );

        label.setBorder(
                new EmptyBorder(
                        12,
                        18,
                        12,
                        18
                )
        );

        label.setOpaque(true);

        // MY MESSAGE

        if(isSender){

            label.setBackground(
                    new Color(0,255,255)
            );

            label.setForeground(Color.BLACK);

        }

        // OTHER USER MESSAGE

        else{

            label.setBackground(
                    new Color(45,45,45)
            );

            label.setForeground(Color.WHITE);
        }

        label.setBorder(
                new CompoundBorder(

                        new LineBorder(
                                new Color(0,0,0,20),
                                1,
                                true
                        ),

                        new EmptyBorder(
                                10,
                                15,
                                10,
                                15
                        )
                )
        );

        add(label,BorderLayout.CENTER);

        setMaximumSize(
                new Dimension(
                        450,
                        1000
                )
        );
    }
}