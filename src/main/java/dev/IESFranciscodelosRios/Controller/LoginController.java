package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.Domain.DAO.UserDAO;
import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.bind.*;
import java.io.File;

public class LoginController {

    @FXML
    private TextField nickname_input;

    @FXML
    private Button loginBTN;

    private UserDAO UDAO =UserDAO.getInstance();

    @FXML
    private void login() {
        String username = nickname_input.getText(); // Obtiene el nombre introducido

    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
