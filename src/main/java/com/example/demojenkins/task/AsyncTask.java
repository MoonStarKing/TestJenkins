package com.example.demojenkins.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async
public class AsyncTask {
    public static void main(String[] args) {
        System.out.println(123333);
    }
}
