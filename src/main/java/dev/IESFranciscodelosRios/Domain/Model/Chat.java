package dev.IESFranciscodelosRios.Domain.Model;

import dev.IESFranciscodelosRios.Interface.IChat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "Chat")
public class Chat implements IChat {
    List<Message> messages = new ArrayList<>();
    public Chat() {
    }

    public Chat(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean addParticipant() {
        return false;
    }

    public boolean SendMessage(){
        return false;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
