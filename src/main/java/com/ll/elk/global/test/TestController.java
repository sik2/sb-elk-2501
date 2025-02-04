package com.ll.elk.global.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test/log")
    public String testLog() {
        log.info("This is a test log message");
        log.error("This is a test error message");
        return "Logs generated!";
    }
} 