package dev.IESFranciscodelosRios.Domain.DAO;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import dev.IESFranciscodelosRios.Interface.IRoomDAO;
import dev.IESFranciscodelosRios.Utils.Utils;
import dev.IESFranciscodelosRios.Utils.XMLManager;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class RoomDAO implements IRoomDAO {
    static File FileRootRoom= new File(App.FileRootRoom+"\\Rooms");
    public static RoomDAO _instance;

    @Override
    public Room NewRoom() {
        return null;
    }

    @Override
    public boolean deleteRoom(String id) {
        return false;
    }

    @Override
    public Room searchRoom(String id) {
        return null;
    }

    @Override
    public Room Load(Room room) {
        return null;
    }

    @Override
    public boolean Save(Room room) {
        return false;
    }

    @Override
    public Set<Room> SearchAllRoom() {
        File[] aux=FileRootRoom.listFiles();
        Set<Room> result= new HashSet<>();

        for (File f:aux) {
            if(Utils.isXMLFile(f.getName())){//Verificaremos que sea un archivo XML
                Room room = XMLManager.readXML(new Room(),f.getName()); // Instancia deserializada
                result.add(room);
            }
        }
        return null;
    }
    private RoomDAO() {
    }

    public static RoomDAO get_instance() {
        if(_instance==null){
            _instance=new RoomDAO();
        }
        return _instance;
    }
}
