package dev.be.moduleapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {
    private final EmailService emailService;
    public void asyncCall_1(){
        System.out.println("call1 :: "+Thread.currentThread().getName());
        //스레드가 서로 다른 이름으로 찍힌다 -> 정상적인 비동기
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();


        //비동기 사용시 스프링에 등록해놓은 빈을 사용해야만 한다.
    }


    public void asyncCall_2(){
        System.out.println("call2 :: "+Thread.currentThread().getName());
        EmailService emailService = new EmailService();
        //서로 다른 스레드명이 찍혀야 하지만 동일한 스레드가 찍힌다.
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }


    public void asyncCall_3(){
        System.out.println("call3 :: "+Thread.currentThread().getName());
        //서로 다른 스레드명이 찍혀야 하지만 동일한 스레드가 찍힌다.
        sendMail();
    }


    @Async
    public void sendMail(){
        System.out.println("senMail :: "+ Thread.currentThread().getName());
    }

}
