package com.test.microservice.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestTask {

    @Scheduled(cron = "0 15 19 * * *", zone = "America/Lima")
    public void logPrint() {
        log.info("Se ejecutó la tarea!!!!");
    }
}
