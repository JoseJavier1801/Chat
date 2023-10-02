package dev.IESFranciscodelosRios.Domain.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Message {
    private String text;
    private LocalDate sendDate;
    private User user;

    public Message() {
    }

    public Message(String text, User user) {
        this.text = text;
        this.sendDate = LocalDate.now();
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public LocalDate getSendDate() {
        return sendDate;
    }

    public User getUser() {
        return user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(text, message.text) && Objects.equals(sendDate, message.sendDate) && Objects.equals(user, message.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, sendDate, user);
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
