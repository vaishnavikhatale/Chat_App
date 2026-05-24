package chattingapplication.client;



import javax.swing.*;
import java.awt.*;

public class UserListPanel extends JPanel {

    DefaultListModel<String> model;
    JList<String> userList;

    public UserListPanel(){

        setLayout(new BorderLayout());

        setBackground(new Color(25,25,25));

        JLabel title =
                new JLabel("ONLINE USERS");

        title.setForeground(Color.CYAN);

        title.setFont(
                new Font("Arial",
                        Font.BOLD,
                        18));

        add(title,BorderLayout.NORTH);

        model = new DefaultListModel<>();

        model.addElement("Nikita");
        model.addElement("Admin");
        model.addElement("Developer");

        userList = new JList<>(model);

        userList.setBackground(
                new Color(35,35,35));

        userList.setForeground(Color.WHITE);

        userList.setFont(
                new Font("Arial",
                        Font.PLAIN,
                        16));

        add(new JScrollPane(userList),
                BorderLayout.CENTER);
    }
}
