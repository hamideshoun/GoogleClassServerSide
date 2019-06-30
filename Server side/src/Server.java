import java.io.IOException;
        import java.net.ServerSocket;
        import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        User user = new User("hamideshoun" , "elahishoun");
        User.users.add(user);
        ServerSocket serverSocket = new ServerSocket(6666);
        while(true){
            try
            {
                System.out.println("listening...");
                Socket temp = serverSocket.accept();
                System.out.println("client connected");
                ClientHandler client = new ClientHandler(temp);
                client.start();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }



        }

    }


}
