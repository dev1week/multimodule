package dev.be.moduleapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {


    @Async("defaultTaskExecutor")
    public void sendMail(){
        System.out.println("sendMail :: "+Thread.currentThread().getName());
    }

    @Async("messagingTaskExecutor")
    public void sendMailWithCustomThreadPool(){
        System.out.println("messagingExecutor :: "+ Thread.currentThread().getName());
    }
}
