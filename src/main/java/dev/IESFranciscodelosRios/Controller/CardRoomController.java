package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.io.IOException;

public class CardRoomController {
    @FXML
    private Text text_RoomName;

    private Room room;

    public void SetData(Room room){
        this.room=room;
        text_RoomName.setText(room.getRoomName());
    }

    /**
     * Construira una Card de la room por tantas rooms como existan
     */
    @FXML
    public void loadRoom(){
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Controller/Room.fxml"));
        Node node = null;
        try {
            node = loader.load();
            RoomController roomController= loader.getController();
            App.setRoomController(roomController);
            roomController.SetData(room);

            App.getHubController().getPane_Room().getChildren().add(node);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
