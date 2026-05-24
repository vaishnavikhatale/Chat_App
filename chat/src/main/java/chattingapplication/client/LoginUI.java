package chattingapplication.client;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame {

    JTextField username;
    JPasswordField password;
    JButton login;

    public LoginUI() {

        setTitle("ChatApp");
        setSize(500, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(18,18,18));

        JLabel title = new JLabel("CHATVERSE");

        title.setBounds(120, 50, 300, 50);

        title.setFont(new Font("Arial", Font.BOLD, 36));

        title.setForeground(Color.CYAN);

        add(title);

        username = new JTextField();

        username.setBounds(80, 180, 320, 45);

        username.setBackground(new Color(40,40,40));

        username.setForeground(Color.WHITE);

        username.setFont(new Font("Arial", Font.PLAIN, 18));

        add(username);

        password = new JPasswordField();

        password.setBounds(80, 260, 320, 45);

        password.setBackground(new Color(40,40,40));

        password.setForeground(Color.WHITE);

        add(password);

        login = new JButton("LOGIN");

        login.setBounds(130, 360, 220, 50);

        login.setBackground(Color.CYAN);

        login.setFont(new Font("Arial", Font.BOLD, 20));

        add(login);

        login.addActionListener(e -> {

            new ChatDashboard(username.getText());

            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new LoginUI();
    }
}
    

