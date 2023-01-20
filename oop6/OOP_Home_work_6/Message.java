package OOP_Home_work_6;

import java.time.LocalDate;
import java.time.LocalTime;

public class Message {
    Person person;
    String message;
    private final LocalDate msgDate;
    private final LocalTime msgTime;

    public Message(Person person, String message) {
        this.person = person;
        this.message = message;
        this.msgDate = LocalDate.now();
        this.msgTime = LocalTime.now();
    }

    public LocalDate getMsgDate() {
        return msgDate;
    }

    public LocalTime getMsgTime() {
        return msgTime;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(msgTime.getHour()).
                append(":").
                append(msgTime.getMinute()).
                append("; ").
                append(person.nickName).
                append(":").
                append(message);
        return builder.toString();
    }
}