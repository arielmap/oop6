package OOP_Home_work_6;

import java.io.IOException;
import java.util.Scanner;

public class UI {
    private Scanner insert = new Scanner(System.in);

    public void start() throws IOException {
        MemberStorage.checkUsersDB();
        enterInSystem();
        System.out.println("Your nickname was not found, do you want to register? Enter yes/no: ");
        if(insert.nextLine().equals("yes")){
            mainMenu(registration());
        } else System.out.println("Good bye");
    }

    public Person registration() throws IOException {
        System.out.println("Enter your nickname: ");
        String nickName = insert.nextLine();
        Person newUser = new User(nickName);
        MemberStorage.addUserInFile(newUser);
        System.out.println("Registration completed");
        System.out.println("Do you want to add someone to your friends list?: Enter yes/no: ");
        return newUser;
    }

    public void enterInSystem() throws IOException {
        System.out.println("Enter your nickname: ");
        String login = insert.nextLine();
        for (ID id: MemberStorage.getIdStorage()) {
            if (login.equals(id.getPerson().nickName)){
                System.out.println("Enter your password: ");
                while (!insert.nextLine().equals(id.getPerson().password)){
                    System.out.println("Wrong password. Try again");
                }
                System.out.println("Authorization was successful");
                id.getPerson().addInFriendsFromFile();
                if (id.getPerson().contactList != null) {
                    id.getPerson().showFriends();
                }
                System.out.println("Do you want to add someone to your friends list?: Enter yes/no: ");
                mainMenu(id.getPerson());
            }
        }
    }

    public void mainMenu(Person person) throws IOException {
        while (insert.nextLine().equals("yes")){
            person.getContactList().add(((User) person).addPersonInFriends());
            person.updateFriendListFile();
            System.out.println("Enter 'yes' to continue, enter 'no' to see your friends list: ");
        }
        for (Person friend: person.getContactList()) {
            System.out.printf("%s %s\n", friend.nickName);
        }
        System.out.println("Enter your friend's name to start a conversation with him: ");
        String name = insert.nextLine();
        for (Person friend: person.getContactList()) {
            if(friend.nickName.equals(name)) {
                chatting(new Conversation(person, friend));
            }
        }
    }

    private void chatting(Conversation conversation) throws IOException {
        System.out.println("Enter '/stop' to end the conversation: ");
        String message = "NoSTOP";
        while(!message.equals("/stop")){
            System.out.println(conversation.getPerson1().nickName);
            message = insert.nextLine();
            if(!message.equals("/stop")) {
                conversation.getMessagesData().add(new Message(conversation.getPerson1(), message));
                System.out.println(conversation.getPerson2().nickName);
                message = insert.nextLine();
                if(!message.equals("/stop")) {
                    conversation.getMessagesData().add(new Message(conversation.getPerson2(), message));
                }
            }
        }
        conversation.writeMessageInFile();
    }
}