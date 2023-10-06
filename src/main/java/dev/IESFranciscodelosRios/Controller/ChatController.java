package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.App;
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
    private Chat chat;
    private ChatThreadUpdate threadUpdate;
    @FXML
    private TextField TextField_SendMessage;
    @FXML
    private VBox Vbox_ChatContainer;

    public ChatController() {

    }

    public void SetData(Chat chat) {
        this.chat = chat;
        threadUpdate=new ChatThreadUpdate(this);
        threadUpdate.start();
    }

    public ChatController(Chat chat) {
        this.chat = chat;
        UpdateChat();
    }

    /**
     * Este metodo creara un mensaje nuevo para posteriormente agregarlo al chat de la uno.xml .
     * Luego sobreescribira el archivo XML de la ROOM
     */
    public void SendMessage() {
        User user = App.getUserLogin();
        Message message = new Message(TextField_SendMessage.getText(), user);

        chat.getMessages().add(message);
        App.roomController.save(); //Serializamos el XML con el nuevo mensaje
        UpdateChat(); //Actualizamos el Nodo Chat
    }

    public void UpdateChat() {
        if (!chat.getMessages().isEmpty()) {
            try {
                Room room = XMLManager.readXML(new Room(), App.roomController.getRoom().getRoomName(), App.FileRootRoom + "\\Rooms\\");
                for (Message aux : room.getChat().getMessages()) {
                    FXMLLoader loader = FXMLLoader.load(getClass().getResource("Message.fxml"));
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

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Thread getThreadUpdate() {
        return threadUpdate;
    }

    public void setThreadUpdate(ChatThreadUpdate threadUpdate) {
        this.threadUpdate = threadUpdate;
    }
}
