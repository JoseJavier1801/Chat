package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Domain.DAO.RoomDAO;
import dev.IESFranciscodelosRios.Domain.Model.Chat;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalTime;

public class CreateRoomController {
    @FXML
    private TextField roomNameField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Button create;

    @FXML
    private boolean areFieldsFilled() {
        String description="";
        String roomName = roomNameField.getText();
        if(descriptionArea!=null){
            description = descriptionArea.getText();
        }
        // Verificar si ambos campos están rellenos
        return !roomName.isEmpty() && !description.isEmpty();
    }

    @FXML
    public void createRoom() {
        // Verificar si los campos están rellenos antes de crear una nueva sala
        if (areFieldsFilled()) {
            // Obtener los valores del formulario
            String roomName = roomNameField.getText();
            String description = descriptionArea.getText();

            // Crear una nueva instancia de Room
            Room newRoom = new Room(roomName, new Chat(), description);
            if (RoomDAO.get_instance().NewRoom(newRoom) == null) {
                System.out.println("Error. No se pudo crear la nueva room");
            }

            // Limpiar los campos del formulario
            roomNameField.clear();
            descriptionArea.clear();

            // Mostrar un mensaje de éxito
            showAlert("Éxito", "Sala creada con éxito.");
            App.hubController.loadRoomCard();
        } else {
            // Mostrar un mensaje de error
            showAlert("Error", "Por favor, rellena todos los campos antes de crear una sala.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}