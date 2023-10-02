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
    static File FileRootRoom= new File(App.FileRootRoom+"\\Rooms");
    public static RoomDAO _instance;
    @Override
    public Room NewRoom(Room room) {

        if(room!=null && searchRoom(room.getRoomName())==null){
            System.out.println(FileRootRoom.getAbsolutePath());
            if(XMLManager.writeXML(room,room.getRoomName(),FileRootRoom.getAbsolutePath())){
                return searchRoom(room.getRoomName());
            }

        }
        return null;
    }

    /**
     * Dentro del directorio Room se buscara el fichero con el nombre introducido por parametro. y se eliminara
     * en caso de encontrarse
     * @param RoomName Nombre
     * @return
     */
    @Override
    public boolean deleteRoom(String RoomName) {
        File file= new File(RoomName+".xml");
        if(file.exists() && file.isFile()){
            file.delete();
        }
        return !file.exists();
    }

    @Override
    public Room searchRoom(String RoomName) {
        Set<Room> allRooms=SearchAllRoom();

        /*v1
        for (uno.xml r:aux) { //buscaremos la uno.xml con el mismo nombre que RoomName
            if(r.getRoomName().equals(RoomName)){
                return r;
            }
        }*/


        //v2
        Optional<Room>result = allRooms.stream().filter(s->s.getRoomName().equals(RoomName)).findFirst();


        return result.orElse(null); //se devolvera result . y si no hay nada entonces null
    }


    /**
     * Probablemente no sirve
    @Override
    public uno.xml Load(uno.xml room) {

    }*/

    @Override
    public boolean Save(Room room) {
        return room!=null?XMLManager.writeXML(room,room.getRoomName(),"Rooms"):false;
    }

    /**

     * Devolvera una lista completa de todos los rooms
     * @return
     *
     */

    @Override
    public Set<Room> SearchAllRoom() {
        File[] aux=FileRootRoom.listFiles();
        Set<Room> result= new HashSet<>();

        for (File f:aux) {
            System.out.println(f.getName());
            if(Utils.isXMLFile(f.getName())){//Verificaremos que sea un archivo XML
                Room room = XMLManager.readXML(new Room(),f.getName()); // Instancia deserializada
                result.add(room);
            }
        }
        return !result.isEmpty()?result:null;//si result no esta vacio. devolvemos result. Si no null
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
