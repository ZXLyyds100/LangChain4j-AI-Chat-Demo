package com.anastasio.aicodehelper.ai;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AICodeHelperServiceTest {
    @Resource
    private AICodeHelperService aiCodeHelperService;

    @Test
    void test() {
        System.out.println(aiCodeHelperService.chat("说中文，说一下华南农业大学"));
    }

    @Test
    void test2() {
        String request = "你好，我是程序员阿亮，学习编程第二年，帮我制定学习报告";
        System.out.println(aiCodeHelperService.chatForReport(request));
    }

}