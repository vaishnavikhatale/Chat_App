package chattingapplication.server;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server Started...");

            while (true) {

                Socket socket = serverSocket.accept();

                ClientHandler client =
                        new ClientHandler(socket);

                clients.add(client);

                Thread thread = new Thread(client);

                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}