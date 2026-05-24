package chattingapplication.client;



import java.io.*;
import java.net.Socket;

public class ChatClient {

    Socket socket;

    BufferedReader br;

    PrintWriter out;

    public ChatClient() {

        try {

            socket = new Socket("localhost",5000);

            br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );

            out = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

            System.out.println("Connected to Server");

        } catch (Exception e) {

            System.out.println("Server Not Started");

            e.printStackTrace();
        }
    }
}