package dev.IESFranciscodelosRios.Domain.Model;

import java.util.Objects;

public class Message {
    private String text;
    private String sendDate;
    private String user;

    public Message(String text, String sendDate, String user) {
        this.text = text;
        this.sendDate = sendDate;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public String getSendDate() {
        return sendDate;
    }

    public String getUser() {
        return user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public void setUser(String user) {
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
