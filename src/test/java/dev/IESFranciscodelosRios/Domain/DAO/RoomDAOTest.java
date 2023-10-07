package dev.IESFranciscodelosRios.Domain.DAO;

import dev.IESFranciscodelosRios.Domain.Model.Chat;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import junit.framework.TestCase;

public class RoomDAOTest extends TestCase {
    private RoomDAO dao=RoomDAO.get_instance();

    public void testNewRoom() {
        System.out.println(dao.NewRoom(new Room("Prueba",new Chat(),"sdfvgfh")));
    }

    public void testDeleteRoom() {
        System.out.println(dao.deleteRoom("Prueba"));
    }

    public void testSearchRoom() {
        System.out.println(dao.searchRoom("Prueba"));
    }

    public void testSearchAllRoom() {
        for (Room aux:dao.SearchAllRoom()) {
            System.out.println(aux);
        }
    }
}