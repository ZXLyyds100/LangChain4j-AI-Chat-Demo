package com.anastasio.aicodehelper.ai;

import dev.langchain4j.service.SystemMessage;

import java.util.List;

public interface AICodeHelperService {
    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String userMessage);
    @SystemMessage(fromResource = "system-prompt.txt")
    Report chatForReport(String userMessage);

    record Report(String name, List<String> suggestionList) {}
}
