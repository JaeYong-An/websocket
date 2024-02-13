package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatMessageRepository messageRepository;

    @Autowired
    public ChatService(ChatMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<ChatMessage> getAllMessages() {
        return messageRepository.findAll();
    }

    public ChatMessage saveMessage(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }
}