package com.anastasio.aicodehelper.ai;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCodeHelperServiceFactory {
    @Resource
    private ChatModel chatModel;

    @Resource
    private ContentRetriever contentRetriever;
    @Bean
    public AICodeHelperService aiCodeHelperService() {
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        AICodeHelperService aiCodeHelperService = AiServices.builder(AICodeHelperService.class)
                .chatMemory(chatMemory)
                .chatModel(chatModel)
                .contentRetriever(contentRetriever)
                .build();
        return aiCodeHelperService;
    }
}
