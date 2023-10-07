package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.DAO.RoomDAO;
import dev.IESFranciscodelosRios.Domain.DAO.UserDAO;
import dev.IESFranciscodelosRios.Domain.Model.Chat;
import dev.IESFranciscodelosRios.Domain.Model.Message;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.Thread.ChatThreadUpdate;
import dev.IESFranciscodelosRios.Utils.XMLManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChatController {
    private ChatThreadUpdate threadUpdate;
    @FXML
    private TextField TextField_SendMessage;
    @FXML
    private VBox Vbox_ChatContainer;
    private String roomname;

    public ChatController() {

    }

    public void SetData() {
        this.roomname=App.getRoomController().getRoom().getRoomName();
        threadUpdate=new ChatThreadUpdate(this);
        threadUpdate.start();
        UpdateChat();
    }


    /**
     * Este metodo creara un mensaje nuevo para posteriormente agregarlo al chat de la uno.xml .
     * Luego sobreescribira el archivo XML de la ROOM
     */
    public void SendMessage() {
        User user = App.getUserLogin();
        Message message = new Message(TextField_SendMessage.getText(), user);

        App.getRoomController().getRoom().getChat().getMessages().add(message);//chat.getMessages().add(message)
        App.roomController.save(); //Serializamos el XML con el nuevo mensaje
        UpdateChat();
    }

    public void UpdateChat() {
        Vbox_ChatContainer.getChildren().clear();
        if (!RoomDAO.get_instance().searchRoom(roomname).getChat().getMessages().isEmpty()) {
            try {
                Room room = XMLManager.readXML(new Room(), App.roomController.getRoom().getRoomName(), App.FileRootRoom + "\\Rooms\\");
                for (Message aux : RoomDAO.get_instance().searchRoom(roomname).getChat().getMessages()) {
                    FXMLLoader loader = new FXMLLoader(App.class.getResource("Controller/Message.fxml"));
                    if (aux != null) {
                        Node node = loader.load();
                        MessageController messageController = loader.getController();
                        messageController.SetData(aux);

                        Vbox_ChatContainer.getChildren().add(node);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Thread getThreadUpdate() {
        return threadUpdate;
    }

    public void setThreadUpdate(ChatThreadUpdate threadUpdate) {
        this.threadUpdate = threadUpdate;
    }
}
