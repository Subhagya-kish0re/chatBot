package com.example.ChatBot.controller;

import com.example.ChatBot.model.ChatRequest;
import com.example.ChatBot.model.ChatResponse;
import com.example.ChatBot.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse getChatResponse(@RequestBody ChatRequest chatRequest) {
        return chatService.getChatResponse(chatRequest);
    }
}
