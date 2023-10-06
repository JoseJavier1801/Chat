package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.Model.Message;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class MessageController {
    @FXML
    private TextArea TextArea_Text;
    @FXML
    private Text text_UserName;
    @FXML
    private Text text_Date;

    private Message message;

    public void SetData(Message message){
        this.message=message;
        TextArea_Text.setText(message.getText());
        text_UserName.setText(App.getUserLogin().getNickname());
    }
}
