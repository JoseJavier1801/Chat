package dev.IESFranciscodelosRios.Controller;

import dev.IESFranciscodelosRios.Domain.Model.Chat;

public class ChatController {
    private Chat chat;
    private Thread threadUpdate;
    public ChatController(){

    }
    public ChatController(Chat chat) {
        this.chat = chat;
    }

}
