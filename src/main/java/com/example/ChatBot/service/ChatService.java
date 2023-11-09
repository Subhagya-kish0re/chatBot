package com.example.ChatBot.service;

import com.example.ChatBot.model.ChatRequest;
import com.example.ChatBot.model.ChatResponse;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {
//    @Value("${openai.api.key}")
    private String apiKey="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";
    private final RestTemplate restTemplate = new RestTemplate();

    public ChatResponse getChatResponse(ChatRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<ChatRequest> request = new HttpEntity<>(chatRequest, headers);

        ResponseEntity<ChatResponse> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/engines/" + chatRequest.getModel() + "/completions",
                request,
                ChatResponse.class
        );

        return response.getBody();
    }
}
