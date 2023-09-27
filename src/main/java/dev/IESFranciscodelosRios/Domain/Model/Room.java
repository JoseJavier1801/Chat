package dev.IESFranciscodelosRios.Domain.Model;

import java.time.LocalTime;
import java.util.Objects;

public class Room {
    private int id;
    private  String roomName;
    private LocalTime dateStart;
    private Chat chat;

    public Room(int id, String roomName, LocalTime dateStart, Chat chat) {
        this.id = id;
        this.roomName = roomName;
        this.dateStart = dateStart;
        this.chat = chat;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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



    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", dateStart=" + dateStart +
                ", chat=" + chat +
                '}';
    }
}
