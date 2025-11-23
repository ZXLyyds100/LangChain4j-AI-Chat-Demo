package com.anastasio.aicodehelper.ai;

import com.anastasio.aicodehelper.ai.guardrail.SafeInputGuardrail;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.guardrail.InputGuardrails;
import reactor.core.publisher.Flux;

import java.util.List;
@InputGuardrails({SafeInputGuardrail.class})

public interface AICodeHelperService {
    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String userMessage);
    @SystemMessage(fromResource = "system-prompt.txt")
    Report chatForReport(String userMessage);
    @SystemMessage(fromResource = "system-prompt.txt")
    Result<String> chatWithRag(String userMessage);
    record Report(String name, List<String> suggestionList) {}
    @SystemMessage(fromResource = "system-prompt.txt")
    Flux<String> streamChat(@MemoryId int memoryId, @UserMessage String userMessage);
}
