package com.anastasio.aicodehelper.ai;

import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperTest {
    @Resource
    private AiCodeHelper aiCodeHelper;
    @Resource
    private AICodeHelperService aiCodeHelperService;
    @Test
    void aiCodeHelperTest() {
        String response = aiCodeHelper.aiChat("说中文，说一下华南农业大学的校科联");
        System.out.println("AI Response: " + response);
    }

    @Test
    void chatWithUserMessage() {
        UserMessage userMessage = UserMessage.from(
                TextContent.from("描述一下这个照片是什么"),
                ImageContent.from("https://www.google.com.hk/imgres?q=Springjava&imgurl=https%3A%2F%2Fwww.okoone.com%2Fwp-content%2Fuploads%2F2024%2F09%2Fjava-spring-big-logo.png&imgrefurl=https%3A%2F%2Fwww.okoone.com%2Ftechnologies%2Fweb%2Fjava-spring%2F&docid=_IZB_L2KmgKb8M&tbnid=gFN3qpEFwbGmTM&vet=12ahUKEwjy9J6ujvmQAxXEsVYBHQr-C8oQM3oECBwQAA..i&w=800&h=490&hcb=2&ved=2ahUKEwjy9J6ujvmQAxXEsVYBHQr-C8oQM3oECBwQAA")
        );
        System.out.println("AI Response: " + aiCodeHelper.chat(userMessage));
    }
    @Test
    void chatWithRag() {
        System.out.println(aiCodeHelperService.chat("说中文，说一下agrife") );
    }
}
