package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.Model.Chat;
import dev.IESFranciscodelosRios.Domain.Model.Message;
import dev.IESFranciscodelosRios.Domain.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

public class ChatController {
    private Chat chat;
    private Thread threadUpdate;
    @FXML
    private TextField TextField_SendMessage;
    @FXML
    private Button Button_Send;
    @FXML
    private ScrollPane ScrollPane_Chat;
    public ChatController(){

    }
    public ChatController(Chat chat) {
        this.chat = chat;
    }

    /**
     * Este metodo creara un mensaje nuevo para posteriormente agregarlo al chat de la uno.xml .
     * Luego sobreescribira el archivo XML de la ROOM 
     */
    public void SendMessage(){
        User user=App.getUserLogin();
        Message message=new Message(TextField_SendMessage.getText(),user);

        //App.roomController
        chat.getMessages().add(message);

        UpdateChat();
    }
    public void UpdateChat(){

    }

}
