package com.anastasio.aicodehelper.ai;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AiCodeHelper {
    @Resource
    private ChatModel qwenChatModel;
    private static final String SYSTEM_MESSAGE = """
            你是一个高级的AI代码助手，精通多种编程语言和技术栈。
            你能够理解复杂的技术问题，并提供清晰、简洁的解决方案。
            无论是代码调试、性能优化，还是架构设计，你都能给出专业的建议。
            请根据用户的需求，提供最合适的代码示例和解释，帮助他们解决编程中的各种挑战。
            """;
    public String aiChat(String message) {
        SystemMessage systemMessage = SystemMessage.from(SYSTEM_MESSAGE);
        UserMessage userMessage = new UserMessage(message);
        ChatResponse chatResponse = qwenChatModel.chat(systemMessage, userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("AI Response: {}", aiMessage.text());
        return aiMessage.text();
    }

    public String chat(UserMessage userMessage) {
        ChatResponse chatResponse = qwenChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("AI Response: {}", aiMessage.text());
        return aiMessage.text();
    }
}
