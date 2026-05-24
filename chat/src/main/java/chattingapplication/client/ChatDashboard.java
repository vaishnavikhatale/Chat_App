package chattingapplication.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatDashboard extends JFrame {

    JPanel chatPanel;

    JTextField messageField;

    AnimatedButton sendButton;

    ChatClient client;

    String username;

    public ChatDashboard(String username) {

        this.username = username;

        client = new ChatClient();

        setTitle("ChatVerse");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(10,10,10));

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();

        sidebar.setPreferredSize(
                new Dimension(250,100));

        sidebar.setBackground(
                new Color(12,12,12));

        sidebar.setLayout(null);

        add(sidebar,BorderLayout.WEST);

        // LOGO

        JLabel logo =
                new JLabel("CHATAPP");

        logo.setBounds(20,40,230,50);

        logo.setForeground(
                new Color(0,255,255));

        logo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        36));

        sidebar.add(logo);

        // BUTTONS

        AnimatedButton chats =
                new AnimatedButton("Chats");

        chats.setBounds(25,170,180,55);

        sidebar.add(chats);

        AnimatedButton groups =
                new AnimatedButton("Groups");

        groups.setBounds(25,260,180,55);

        sidebar.add(groups);

        AnimatedButton profile =
                new AnimatedButton("Profile");

        profile.setBounds(25,350,180,55);

        sidebar.add(profile);

        // ================= MAIN PANEL =================

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                new Color(15,15,15));

        add(mainPanel,BorderLayout.CENTER);

        // ================= HEADER =================

        JPanel header =
                new JPanel(new BorderLayout());

        header.setPreferredSize(
                new Dimension(100,70));

        header.setBackground(
                new Color(18,18,18));

        JLabel title =
                new JLabel("  Global Chat");

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24));

        header.add(title,BorderLayout.WEST);

        mainPanel.add(header,BorderLayout.NORTH);

        // ================= CHAT AREA =================

        chatPanel = new JPanel();

        chatPanel.setLayout(
                new BoxLayout(
                        chatPanel,
                        BoxLayout.Y_AXIS));

        chatPanel.setBackground(
                new Color(15,15,15));

        JScrollPane scrollPane =
                new JScrollPane(chatPanel);

        scrollPane.setBorder(null);

        scrollPane.getViewport().setBackground(
                new Color(15,15,15));

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        mainPanel.add(scrollPane,
                BorderLayout.CENTER);

        // ================= BOTTOM PANEL =================

        JPanel bottomPanel =
                new JPanel(new BorderLayout(15,0));

        bottomPanel.setBorder(
                new EmptyBorder(
                        15,
                        15,
                        15,
                        15));

        bottomPanel.setBackground(
                new Color(18,18,18));

        // MESSAGE FIELD

        messageField = new JTextField();

        messageField.setPreferredSize(
                new Dimension(100,55));

        messageField.setBackground(
                new Color(35,35,35));

        messageField.setForeground(
                Color.WHITE);

        messageField.setCaretColor(
                Color.WHITE);

        messageField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        18));

        messageField.setBorder(
                new EmptyBorder(
                        10,
                        20,
                        10,
                        20));

        bottomPanel.add(
                messageField,
                BorderLayout.CENTER);

        // SEND BUTTON

        sendButton =
                new AnimatedButton("SEND");

        sendButton.setPreferredSize(
                new Dimension(170,55));

        bottomPanel.add(
                sendButton,
                BorderLayout.EAST);

        mainPanel.add(
                bottomPanel,
                BorderLayout.SOUTH);

        // ================= BUTTON ACTIONS =================

        sendButton.addActionListener(e -> {

            sendMessage();
        });

        messageField.addActionListener(e -> {

            sendMessage();
        });

        receiveMessages();

        setVisible(true);
    }

    // ================= SEND MESSAGE =================

    void sendMessage() {

        String text =
                messageField.getText().trim();

        if(text.isEmpty()) return;

        String msg =
                username + " : " + text;

        client.out.println(msg);

        messageField.setText("");
    }

    // ================= RECEIVE =================

    void receiveMessages() {

        Thread t = new Thread(() -> {

            try {

                String msg;

                while((msg = client.br.readLine()) != null){

                    boolean isMine =
                            msg.startsWith(
                                    username + " :");

                    JPanel wrapper =
                            new JPanel(
                                    new BorderLayout()
                            );

                    wrapper.setBackground(
                            new Color(15,15,15)
                    );

                    MessageBubble bubble =
                            new MessageBubble(
                                    msg,
                                    isMine
                            );

                    if(isMine){

                        wrapper.add(
                                bubble,
                                BorderLayout.EAST
                        );

                    } else {

                        wrapper.add(
                                bubble,
                                BorderLayout.WEST
                        );
                    }

                    wrapper.setBorder(
                            BorderFactory.createEmptyBorder(
                                    5,
                                    15,
                                    5,
                                    15
                            )
                    );

                    chatPanel.add(wrapper);

                    chatPanel.revalidate();

                    chatPanel.repaint();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        });

        t.start();
    }
}