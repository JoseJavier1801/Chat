package dev.IESFranciscodelosRios;

import dev.IESFranciscodelosRios.Domain.DAO.RoomDAO;
import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.Utils.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class App extends Application {
    private static User UserLogin;
    private static Scene scene;
    public static String FileRootRoom=System.getProperty("user.dir");
    public static String IpServer;

    public static void main(String[] args) {
        RoomDAO.get_instance().SearchAllRoom();
        //Extraeremos la Ip pasada por argumento. En caso de haber un argumento con las reglas gramaticales de una ip
        IpServer=Utils.IpAddress(args);
        launch(args);
    }



    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"), 800, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Controller/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static User getUserLogin() {
        return UserLogin;
    }

    public static void setUserLogin(User userLogin) {
        UserLogin = userLogin;
    }
}