package dev.IESFranciscodelosRios.Domain.Model;

import java.time.LocalTime;
import java.util.Objects;

public class Room {

    private  String roomName;
    private LocalTime dateStart;
    private Chat chat=new Chat() ;

    private String description;

    public Room(String roomName, LocalTime dateStart, Chat chat, String description) {
        this.roomName = roomName;
        this.dateStart = dateStart;
        this.chat = chat;
        this.description = description;
    }

    public String getRoomName() {
        return roomName;
    }

    public LocalTime getDateStart() {
        return dateStart;
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

    public void setDateStart(LocalTime dateStart) {
        this.dateStart = dateStart;
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
        return Objects.equals(roomName, room.roomName) && Objects.equals(dateStart, room.dateStart) && Objects.equals(chat, room.chat) && Objects.equals(description, room.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName, dateStart, chat, description);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", dateStart=" + dateStart +
                ", chat=" + chat +
                ", description='" + description + '\'' +
                '}';
    }
}
