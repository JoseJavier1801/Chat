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
    }

    public void testSearchRoom() {
    }

    public void testSave() {
    }

    public void testSearchAllRoom() {
    }
}