package OOP_Home_work_6;

import java.util.Scanner;

public class Admin extends Person implements AdminFunctions{

    public Admin(String nickName) {
        super(nickName);
        login = "Admin";
        password = "Admin";
    }

    @Override
    public void removeUserFromConversation(Person person) {
    }

    @Override
    public void addUserInConversation(Person person, Conversation conversation) {
    }

    @Override
    public void giveStatus(Person person) {
        System.out.println("Enter user status: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("Moderator")) {
            person.status = Status.MODERATOR;
        } else {
            System.out.println("To be continued");
        }
    }

    @Override
    public void removeMessage() {
    }

    @Override
    public void banUser(Person user) {
    }

    @Override
    public void editMessage() {
    }
}