package chattingapplication.client;






import javax.swing.*;

import chattingapplication.client.LoginUI;

public class Main {

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {

            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {

            new LoginUI();

        });
    }
}