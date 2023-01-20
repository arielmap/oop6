package OOP_Home_work_6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    protected String nickName;
    protected Status status;
    protected String login;
    protected String password;
    protected List<Person> contactList = new ArrayList<>();

    protected static Path path = Path.of("");

    public Person(String nickName) {
        this.nickName = nickName;
    }

    public List<Person> getContactList() {
        return contactList;
    }

    public void addInFriendsFromFile() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(Path.of(String.valueOf(path)));
        } else {
            List<String> readedList = Files.readAllLines(path);
            for (String person : readedList) {
                String[] nickName = person.split(" ");
                getContactList().add(new User(nickName[0]));
            }
        }
    }

    public void updateFriendListFile() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(Path.of(String.valueOf(path)));
        } else {
            String allFriends = "";
            for (Person friend: contactList) {
                allFriends += friend.nickName + "\n";
            }
            Files.writeString(path, allFriends);
            System.out.println("writing to friend list complete");
        }
    }

    public void showFriends() {
        for (Person friend: contactList) {
            System.out.println(friend.nickName);
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}