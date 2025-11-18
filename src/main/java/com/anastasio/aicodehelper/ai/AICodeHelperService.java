package com.anastasio.aicodehelper.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

public interface AICodeHelperService {
    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String userMessage);
}
