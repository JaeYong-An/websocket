package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@Controller
@Slf4j
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
    	log.info(""+chatMessage);
        return chatService.saveMessage(chatMessage);
    }

    @MessageMapping("/getAllMessages")
    @SendTo("/topic/public")
    public List<ChatMessage> getAllMessages() {
        return chatService.getAllMessages();
    }
}