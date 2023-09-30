package dev.IESFranciscodelosRios.Interface;

import dev.IESFranciscodelosRios.Domain.Model.Room;

import java.util.Set;

public interface IRoomDAO {
   public Room NewRoom();
    public boolean deleteRoom(String id);
   public Room searchRoom(String id);
   public boolean Save(Room room);
   public Set<Room> SearchAllRoom();

}
