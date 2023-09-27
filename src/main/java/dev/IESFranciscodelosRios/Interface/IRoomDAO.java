package dev.IESFranciscodelosRios.Interface;

import dev.IESFranciscodelosRios.Domain.Model.Room;

public interface IRoomDAO {
   public Room NewRoom();
    public boolean deleteRoom(String id);
   public Room searchChat(String id);

}
