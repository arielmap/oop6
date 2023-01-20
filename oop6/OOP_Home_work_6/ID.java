package OOP_Home_work_6;

public class ID {
    private Person person;
    private int ID;

    public ID(Person person) {
        this.person = person;
        ID = MemberStorage.count++;
        System.out.printf("%s ID is %d\n",person.nickName, ID);
        MemberStorage.getIdStorage().add(this);
    }

    public Person getPerson() {
        return person;
    }

    public int getID() {
        return ID;
    }
}