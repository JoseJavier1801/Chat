package dev.IESFranciscodelosRios.Domain.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "Room")
public class Room {

    private  String roomName;
    private Chat chat;

    private String description;

    // Constructor por defecto
    public Room() {
        // Puedes inicializar algunos valores predeterminados aquí si es necesario
        this.roomName = "";
        this.chat = new Chat();
        this.description = "";
    }
    public Room(String roomName) {
        // Puedes inicializar algunos valores predeterminados aquí si es necesario
        this.roomName = roomName;
        this.chat = new Chat();
        this.description = "";
    }

    public Room(String roomName, Chat chat, String description) {
        this.roomName = roomName;
        this.chat = chat;
        this.description = description;
    }

    public String getRoomName() {
        return roomName;
    }


    public Chat getChat() {
        return chat;
    }

    public String getDescription() {
        return description;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomName, room.roomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", chat=" + chat +
                ", description='" + description + '\'' +
                '}';
    }
}