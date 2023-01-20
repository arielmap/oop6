package OOP_Home_work_6;

public class Moderator extends Person implements ModeratorFunctions{

    public Moderator(String nickName) {
        super(nickName);
        login = "Moderator";
        password = "Moderator";
    }

    @Override
    public void editMessage() {
    }

    @Override
    public void removeMessage() {
    }

    @Override
    public void banUser(Person user) {
    }
}