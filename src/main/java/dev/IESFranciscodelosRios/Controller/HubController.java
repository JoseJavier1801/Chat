package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.Domain.Model.Room;
import dev.IESFranciscodelosRios.Domain.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HubController {
    @FXML
    private TextField roomNameField;
    @FXML
    private TextArea descriptionRoom;
    @FXML
    private Button create;

    // Crear una lista para almacenar objetos Room
    private List<Room> roomList = new ArrayList<>();

    public User userLogged;

    public void addToRoomList(Room room) {
        roomList.add(room);
    }

    // Un método para obtener la lista roomList
    public List<Room> getRoomList() {
        return roomList;
    }

    @FXML
    private void ButtonExit() throws IOException {
        createRoom();
    }

    @FXML
    public void createRoom() {
        // Obtener los valores del formulario
        String roomName = roomNameField.getText();
        String description = descriptionRoom.getText();

        // Generar el ID automáticamente (puedes usar un contador, por ejemplo)
        int roomId = generateRoomId();

        // Obtener la fecha actual
        LocalTime currentDate = LocalTime.now();

        // Crear una nueva instancia de Room
        Room newRoom = new Room(roomName, currentDate, null, description);

        // Agregar la nueva sala a la lista
        addToRoomList(newRoom);

        // Limpiar los campos del formulario
        roomNameField.clear();
        descriptionRoom.clear();
    }

    // Método para generar un ID de sala automático (puedes implementarlo según tus necesidades)
    private int generateRoomId() {
        // Implementa la lógica para generar un ID único
        // Por ejemplo, puedes utilizar un contador o alguna estrategia de generación de IDs
        return 0;
    }
}
