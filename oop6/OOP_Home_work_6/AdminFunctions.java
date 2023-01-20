package OOP_Home_work_6;

public interface AdminFunctions extends ModeratorFunctions{
    public void removeUserFromConversation(Person person);
    public void addUserInConversation(Person person, Conversation conversation);
    public void giveStatus(Person person);
}
