package dev.IESFranciscodelosRios.Domain.DAO;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import dev.IESFranciscodelosRios.Interface.IRoomDAO;
import dev.IESFranciscodelosRios.Utils.Utils;
import dev.IESFranciscodelosRios.Utils.XMLManager;

import java.io.File;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RoomDAO implements IRoomDAO {
    static File FileRootRoom = new File(App.FileRootRoom + "\\Rooms");
    public static RoomDAO _instance;

    @Override
    public Room NewRoom(Room room) {

        if (room != null && searchRoom(room.getRoomName()) == null) {
            if (this.Save(room)) {//if(XMLManager.writeXML(room,room.getRoomName(),FileRootRoom.getAbsolutePath())){
                return searchRoom(room.getRoomName());
            }

        }
        return null;
    }

    /**
     * Dentro del directorio Room se buscara el fichero con el nombre introducido por parametro. y se eliminara
     * en caso de encontrarse
     *
     * @param RoomName Nombre
     * @return
     */
    @Override
    public boolean deleteRoom(String RoomName) {
        File file = new File(FileRootRoom.getAbsolutePath()+"\\"+RoomName + ".xml");
        System.out.println(file.getAbsolutePath());
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        return !file.exists();
    }

    @Override
    public Room searchRoom(String RoomName) {
        Set<Room> allRooms = SearchAllRoom();

        if (allRooms == null) {
            return null;
        }

        Optional<Room> result = allRooms.stream()
                .filter(s -> s.getRoomName().equals(RoomName))
                .findFirst();

        return result.orElse(null);
    }


    /**
     * Probablemente no sirve
     *
     * @Override public uno.xml Load(uno.xml room) {
     * <p>
     * }
     */

    @Override
    public boolean Save(Room room) {
        return room != null ? XMLManager.writeXML(room, room.getRoomName(), FileRootRoom.getAbsolutePath()) : false;
    }

    /**
     * Devolvera una lista completa de todos los rooms
     *
     * @return
     */

    @Override
    public Set<Room> SearchAllRoom() {
        File[] aux = FileRootRoom.listFiles();
        Set<Room> result = new HashSet<>();

        for (File f : aux) {
            if (Utils.isXMLFile(f.getName())) {//Verificaremos que sea un archivo XML
                Room room = XMLManager.readXML(new Room(), f.getName(), FileRootRoom.getAbsolutePath()); // Instancia deserializada
                result.add(room);
            }
        }
        return !result.isEmpty() ? result : null;//si result no esta vacio. devolvemos result. Si no null
    }

    private RoomDAO() {
    }

    public static RoomDAO get_instance() {
        if (_instance == null) {
            _instance = new RoomDAO();
        }
        return _instance;
    }
}
