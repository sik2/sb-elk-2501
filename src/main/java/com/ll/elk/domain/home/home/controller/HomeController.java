package com.ll.elk.domain.home.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class HomeController {

        @GetMapping("/")
        public String home() {
            LocalDateTime localDateTime = LocalDateTime.now();
            log.info("Home " + localDateTime);
            return "Hello, World!";
        }

    @GetMapping("/logs")
    public String Logs() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("Logs " + localDateTime);
        return "Logs page";
    }

    @GetMapping("/warn")
    public String Warn() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.warn("Warn" + localDateTime);
        return "Warn page";
    }


    @GetMapping("/err")
    public String Error() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.error("Error " + localDateTime);
        return "Error page";
    }
}
