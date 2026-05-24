package chattingapplication.server;



import java.util.HashSet;
import java.util.Set;

public class UserManager {

    private static Set<String> onlineUsers =
            new HashSet<>();

    public static void addUser(String username){

        onlineUsers.add(username);

        System.out.println(username + " joined");
    }

    public static void removeUser(String username){

        onlineUsers.remove(username);

        System.out.println(username + " left");
    }

    public static Set<String> getOnlineUsers(){

        return onlineUsers;
    }
}