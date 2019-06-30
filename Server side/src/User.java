import java.util.ArrayList;

public class User {
    String username;
    String password;
    byte[] picture;
    ArrayList<Class> classes = new ArrayList<>();
    boolean logedIn = false;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, boolean logedIn) {
        this.username = username;
        this.password = password;
        this.logedIn = logedIn;
    }

    static ArrayList<User> users = new ArrayList<>();

}