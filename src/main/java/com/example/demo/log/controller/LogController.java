package com.example.demo.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.log.service.LogService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
public class LogController {

    private final LogService logService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/log")
    public void log() {
        logService.log();
        logger.trace("Trace Level 테스트"); 
        logger.debug("DEBUG Level 테스트"); 
        logger.info("INFO Level 테스트"); 
        logger.warn("Warn Level 테스트");
        logger.error("Error Level 테스트");

    }
}