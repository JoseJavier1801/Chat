package dev.IESFranciscodelosRios;

import dev.IESFranciscodelosRios.Controller.HubController;
import dev.IESFranciscodelosRios.Controller.RoomController;
import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.Utils.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static User UserLogin;
    private static Scene scene;
    public static String FileRootRoom=System.getProperty("user.dir");
    public static String IpServer;
    public static RoomController roomController;//puntero rapido al ocntroller del RoomController
    public static HubController hubController;

    public static void main(String[] args) {
        //Extraeremos la Ip pasada por argumento. En caso de haber un argumento con las reglas gramaticales de una ip
        IpServer=Utils.IpAddress(args);
        launch(args);
    }



    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Controller/" + fxml + ".fxml"));
        Parent root = fxmlLoader.load();

        if("Hub".equals(fxml)){
            hubController=fxmlLoader.getController();
        }

        return root;
    }
    public static void newStage(Parent p) throws IOException {
        Stage stage2=new Stage();
        Scene scene2= new Scene(p);
        stage2.setScene(scene2);
        stage2.show();
    }

    public static User getUserLogin() {
        return UserLogin;
    }

    public static void setUserLogin(User userLogin) {
        UserLogin = userLogin;
    }

    public static RoomController getRoomController() {
        return roomController;
    }

    public static void setRoomController(RoomController roomController) {
        App.roomController = roomController;
    }

    public static HubController getHubController() {
        return hubController;
    }

    public static void setHubController(HubController hubController) {
        App.hubController = hubController;
    }
}