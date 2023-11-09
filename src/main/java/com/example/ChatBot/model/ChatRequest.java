package com.example.ChatBot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRequest {
    private String prompt;
    private String model;
    private int maxTokens;

}


