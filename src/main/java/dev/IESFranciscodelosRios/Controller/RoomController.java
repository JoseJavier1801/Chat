package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.DAO.RoomDAO;
import dev.IESFranciscodelosRios.Domain.DAO.UserDAO;
import dev.IESFranciscodelosRios.Domain.Model.Chat;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.Utils.XMLManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class RoomController {

    private Room room;
    private ChatController chatController;
    @FXML
    private Text text_RoomName;
    @FXML
    private Text text_members;
    @FXML
    private Pane pane_ChatContainer;
    /**
     * funcion para volver atras al hub
     */

    @FXML
    public void back() {
        App.setRoot("Hub");
    }
    /**
     * esta funcion se encarga de cargar los datos de las salas cuando nos metemos
     * @param room
     */

    public void SetData(Room room) {
        this.room = room;
        this.text_RoomName.setText(room.getRoomName());
        this.text_members.setText(getAllNameUsers());
        showChat();
    }
    /**
     * esta funcion es par buscar todos los nombres de los usuarios en el grupo
     * @return result que son todos los nombres de los usuarios
     */
    private String getAllNameUsers(){
        List<User> users= UserDAO.getInstance().getAllUsers();
        String result="";
        for (User aux:users) {
            result+=aux.getNickname()+", ";
        }
        return result;
    }
    /**
     * esta funcion cargara la ventana de chat de la sala con todos los mensajes que tenga ese chat
     */
    public void showChat() {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Controller/Chat.fxml"));
        Node node=null;
        try {
            node = loader.load();
            chatController = loader.getController();
            chatController.SetData();

            pane_ChatContainer.getChildren().add(node);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * esta funcion se en carga de guardar los datos de la sala de chat
     */
    public void save() {
        RoomController roomController=App.roomController;
        String pathAbsolute= App.FileRootRoom+"\\Rooms\\";
        // Llamar al método XMLMarshaller y marcar la instancia de room
        XMLManager.writeXML(roomController.room,this.room.getRoomName(),pathAbsolute);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ChatController getChatController() {
        return chatController;
    }

    public void setChatController(ChatController chatController) {
        this.chatController = chatController;
    }
}