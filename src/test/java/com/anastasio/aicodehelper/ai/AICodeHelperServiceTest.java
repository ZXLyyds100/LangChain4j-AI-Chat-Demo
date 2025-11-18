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

}