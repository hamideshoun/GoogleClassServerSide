import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {

    static ArrayList<ClientHandler> clients = new ArrayList<>();

    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    public ClientHandler(Socket socket){
        System.out.println("socket");
        this.socket = socket;
        //clients.add(this);
    }

    @Override
    public void run() {
        try {
//            System.out.println("client run");
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
//            System.out.println("here here");
            String[] str = (String[])in.readObject();
            System.out.println(str[0]);
//            for (int i = 0; i < b.length; i++) {
//                System.out.println(b[i]);
//            }

            if (str[0].equals("sign_in")){
                boolean sign = false;
                int i;
                System.out.println("sign in");
                for (i = 0; i < User.users.size(); i++) {
                    if (User.users.get(i).username.equals(str[1]) && User.users.get(i).password.equals(str[2])){
                        sign = true;
                        System.out.println("user signed in");
                        break;
                    }
                }
                out.writeBoolean(sign);
                out.flush();
                if (sign){
                    out.writeObject(User.users.get(i));
                    out.flush();
                }
            }
            else if (str[0].equals("username_check")){
                boolean b = false;

                System.out.println("username finding");

                for (int i = 0; i < User.users.size(); i++) {
                    if(User.users.get(i).username.equals(str[1])){
                        b = true;
                    }
                }

                out.writeBoolean(b);
                out.flush();

            }
            else if (str[0].equals("register")){

                boolean b = true;

                System.out.println("registration");

                for (int i = 0; i < User.users.size(); i++) {
                    if (User.users.get(i).username.equals(str[1])){
                        b = false;
                    }
                }

                out.writeBoolean(b);
                out.flush();

            }


            in.close();
            out.close();
            socket.close();

        }
        catch (IOException e2){
            e2.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
