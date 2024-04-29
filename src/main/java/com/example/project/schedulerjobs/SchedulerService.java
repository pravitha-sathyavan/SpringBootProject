package com.example.project.schedulerjobs;

import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    public void method1(){
        System.out.println("Hi From Scheduler Job 1");
    }

    public void method2(){
        System.out.println("Hi 1 From Scheduler Job 2");
        System.out.println("Hi 2 From Scheduler Job 2");
        System.out.println("Hi 3 From Scheduler Job 2");
        System.out.println("Hi 4 From Scheduler Job 2");
        System.out.println("Hi 5 From Scheduler Job 2");
        System.out.println("Hi 6 From Scheduler Job 2");
        System.out.println("Hi 7 From Scheduler Job 2");
        System.out.println("Hi 8 From Scheduler Job 2");
        System.out.println("Hi 9 From Scheduler Job 2");
        System.out.println("Hi 10 From Scheduler Job 2");
    }
}
