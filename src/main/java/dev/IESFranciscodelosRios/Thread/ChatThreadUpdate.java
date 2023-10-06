package dev.IESFranciscodelosRios.Thread;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Controller.ChatController;

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
    public ChatThreadUpdate(ChatController controller){
        this.controller=controller;
        this.ruta=App.FileRootRoom+"\\Rooms\\"+App.roomController.getRoom().getRoomName()+".xml";
        fileRootRoom= new File(ruta);
    }
    public void run(){
        try {
            while (fileRootRoom.exists()){
                BasicFileAttributes atributos = Files.readAttributes(Paths.get(ruta), BasicFileAttributes.class);
                fileRootRoom.lastModified();
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
