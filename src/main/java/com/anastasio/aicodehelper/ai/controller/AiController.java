package com.anastasio.aicodehelper.ai.controller;

import com.anastasio.aicodehelper.ai.AICodeHelperService;
import jakarta.annotation.Resource;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AiController {
    @Resource
    private AICodeHelperService aiCodeHelperService;
    @GetMapping("/chat")
    public Flux<ServerSentEvent<String>> chat(int memoryId, String userMessage) {
        return aiCodeHelperService.streamChat(memoryId, userMessage)
                .map(content -> ServerSentEvent.<String>builder().data(content).build());
    }
}
