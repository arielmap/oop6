package OOP_Home_work_6;

import java.util.Scanner;

public interface UserFunctions {

    public default void writeMessage(Conversation conversation, Person person){
        Scanner scanner = new Scanner(System.in);
        System.out.println(person.nickName);
        conversation.getMessagesData().add(new Message(person, scanner.nextLine()));
    }

    public default Person addPersonInFriends(){
        Scanner nickName = new Scanner(System.in);
        System.out.println("Enter your friend's nickname: ");
        String nick = nickName.nextLine();
        for (ID id: MemberStorage.getIdStorage()) {
            if (nick.equals(id.getPerson().nickName)) {
                return id.getPerson();
            } else System.out.println("This person is not in the database");
        }
        System.out.println("This person is not in the database");
        return null;
    }
    public void editMessage();
}