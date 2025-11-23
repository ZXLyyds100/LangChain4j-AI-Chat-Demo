package com.anastasio.aicodehelper.ai;

import com.anastasio.aicodehelper.ai.mcp.McpConfig;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
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

    @Resource
    private StreamingChatModel qwenStreamingChatModel;
    @Resource
    private McpToolProvider mcpToolProvider;
    @Bean
    public AICodeHelperService aiCodeHelperService() {
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        AICodeHelperService aiCodeHelperService = AiServices.builder(AICodeHelperService.class)
                .chatMemory(chatMemory)
                .chatModel(chatModel)
                .streamingChatModel(qwenStreamingChatModel)
                .chatMemoryProvider(memroyId -> MessageWindowChatMemory.withMaxMessages(10))
                .contentRetriever(contentRetriever)
                .toolProvider(mcpToolProvider)
                .build();
        return aiCodeHelperService;
    }
}
