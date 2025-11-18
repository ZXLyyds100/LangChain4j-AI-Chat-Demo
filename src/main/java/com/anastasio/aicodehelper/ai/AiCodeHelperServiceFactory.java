package com.anastasio.aicodehelper.ai;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCodeHelperServiceFactory {
    @Resource
    private ChatModel chatModel;
    @Bean
    public AICodeHelperService aiCodeHelperService() {
        return AiServices.create(AICodeHelperService.class, chatModel);
    }
}
