package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.Domain.DAO.UserDAO;
import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class LoginController {

    @FXML
    private TextField nickname_input;

    @FXML
    private Button loginBTN;

    private UserDAO UDAO =UserDAO.getInstance();
    /**
     * Este método se llama cuando se hace clic en el botón de inicio de sesión.
     * Realiza la lógica de inicio de sesión y gestiona las acciones correspondientes.
     *
     * @throws IOException   Si ocurre un error de entrada/salida.
     * @throws JAXBException Si ocurre un error de serialización/deserialización XML.
     */
    @FXML
    private void login() throws IOException, JAXBException {
        String username = nickname_input.getText().trim(); // Obtén el nombre introducido y quita espacios en blanco

        if (username.isEmpty()) {
            showAlert("Invalid Nickname");
            return; // Salir del método si el campo está vacío
        }

        User existingUser = UDAO.getUserByNickname(username);

        if (existingUser != null) {
            App.setUserLogin(existingUser);
            App.setRoot("Hub");
        } else {
            // El usuario no existe, muestra un diálogo de confirmación.
            boolean createNewUser = showConfirmationDialog("The user does not exist. Do you want to create it?");

            if (createNewUser) {
                User newUser = new User(username);
                UDAO.addUser(newUser);
                App.setUserLogin(UDAO.getUserByNickname(username));
                showAlert("User created successfully");
            }
        }
    }

    /**
     * Muestra un cuadro de diálogo de confirmación con un mensaje y opciones "Sí" y "No".
     *
     * @param message El mensaje que se mostrará en el cuadro de diálogo.
     * @return true si se selecciona "Sí", false si se selecciona "No".
     */
    private boolean showConfirmationDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == yesButton;
    }

    /**
     * Muestra una ventana emergente de alerta con un mensaje.
     *
     * @param message El mensaje que se mostrará en la ventana emergente.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
