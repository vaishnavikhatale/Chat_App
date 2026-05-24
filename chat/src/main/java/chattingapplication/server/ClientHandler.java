package chattingapplication.server;



import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    Socket socket;

    BufferedReader br;
    PrintWriter out;

    public ClientHandler(Socket socket) {

        try {

            this.socket = socket;

            br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String message;

        try {

            while ((message = br.readLine()) != null) {

                System.out.println(message);

                for (ClientHandler ch : ChatServer.clients) {

                    ch.out.println(message);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}