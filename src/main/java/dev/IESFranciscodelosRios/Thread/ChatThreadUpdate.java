package dev.IESFranciscodelosRios.Thread;

import dev.IESFranciscodelosRios.App;
import dev.IESFranciscodelosRios.Controller.ChatController;

import java.io.File;

public class ChatThreadUpdate extends Thread{
    private ChatController controller;
    private File fileRootRoom;
    public ChatThreadUpdate(ChatController controller){
        this.controller=controller;
        //fileRootRoom= new File(App.FileRootRoom+"\\Rooms\\"+App.roomController.+".xml");
    }
    public void run(){
        try {
            while (true){
                //FileRootRoom.
                Thread.sleep(3000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
