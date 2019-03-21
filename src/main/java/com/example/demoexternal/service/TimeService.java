package com.example.demoexternal.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    private int counter = 0;

//    @Scheduled(fixedRateString = "3000")
    public void start() throws InterruptedException {

        System.out.println("STARTED " + counter);
        counter++;
//        Thread.sleep(6000);
        System.out.println("AFTER SLEEP");
    }
}
