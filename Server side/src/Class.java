import java.util.ArrayList;

public class Class {

    int id;
    String name;
    String description;
    String notification;
    int roomNumber;
    ArrayList<User> teachers;
    ArrayList<User> stuents;

    public Class(int id, String name, String description, int roomNumber) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.roomNumber = roomNumber;
    }

    public Class(String name, String description, int roomNumber) {
        this.name = name;
        this.description = description;
        this.roomNumber = roomNumber;
    }

    public Class(String name, String description, int roomNumber, ArrayList<User> teachers, ArrayList<User> stuents) {
        this.name = name;
        this.description = description;
        this.roomNumber = roomNumber;
        this.teachers = teachers;
        this.stuents = stuents;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }

    ArrayList<Class> classes = new ArrayList<>();
}
