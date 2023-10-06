package dev.IESFranciscodelosRios.Thread;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Controller.ChatController;
import dev.IESFranciscodelosRios.Domain.DAO.RoomDAO;
import dev.IESFranciscodelosRios.Domain.Model.Room;
import javafx.application.Platform;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ChatThreadUpdate extends Thread{
    private ChatController controller;
    public File fileRootRoom;
    String ruta;
    private long lastModified;
    private String roomname;
    public ChatThreadUpdate(ChatController controller){
        this.controller=controller;
        this.roomname=App.roomController.getRoom().getRoomName();
        this.ruta=App.FileRootRoom+"\\Rooms\\"+App.roomController.getRoom().getRoomName()+".xml";
        fileRootRoom= new File(ruta);
    }
    public void run(){
        try {
            while (fileRootRoom.exists()){
                BasicFileAttributes atributos = Files.readAttributes(Paths.get(ruta), BasicFileAttributes.class);
                if(fileRootRoom.lastModified()!=lastModified){
                    lastModified=fileRootRoom.lastModified();
                    Platform.runLater(() -> {
                        controller.UpdateChat();
                    });
                }
                Thread.sleep(3000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFileRootRoom() {
        return fileRootRoom;
    }

    public void setFileRootRoom(File fileRootRoom) {
        this.fileRootRoom = fileRootRoom;
    }
}
