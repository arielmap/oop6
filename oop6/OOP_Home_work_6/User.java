package OOP_Home_work_6;

public class User extends Person implements UserFunctions{

    public User(String nickName) {
        super(nickName);
        login = "User";
        password = "User";
    }

    @Override
    public void editMessage() {
    }
}