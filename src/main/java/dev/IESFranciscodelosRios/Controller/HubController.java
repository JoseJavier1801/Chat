package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.DAO.RoomDAO;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import dev.IESFranciscodelosRios.Domain.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HubController {

    // Crear una lista para almacenar objetos uno.xml
    private List<Room> roomList = new ArrayList<>();
    public User userLogged;
    @FXML
    private VBox RoomsContainer;
    @FXML
    private Pane pane_Room;

    public void addToRoomList(Room room) {
        roomList.add(room);
    }

    // Un método para obtener la lista roomList
    public List<Room> getRoomList() {
        return roomList;
    }

    @FXML
    private void Exit() {
        App.setUserLogin(null);
        App.setRoot("Login");
    }

    @FXML
    public void initialize() {
        loadRoomCard();
    }

    @FXML
    public void createRoom() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Controller/createRoom.fxml"));
            App.newStage(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void loadRoomCard() {
        RoomsContainer.getChildren().clear();
        try {
            Set<Room> collection;
            if ((collection = RoomDAO.get_instance().SearchAllRoom())!=null) {
                for (Room aux : collection) {

                    if (aux != null) {
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("Controller/CardRoom.fxml"));
                        Node node = loader.load();
                        CardRoomController cardRoomController = loader.getController();
                        cardRoomController.SetData(aux);
                        RoomsContainer.getChildren().add(node);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Pane getPane_Room() {
        return pane_Room;
    }

    public void setPane_Room(Pane pane_Room) {
        this.pane_Room = pane_Room;
    }
}
