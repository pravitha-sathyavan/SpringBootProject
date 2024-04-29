package com.example.project.schedulerjobs;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerComponent {

    private SchedulerService schedulerService;

    public SchedulerComponent(SchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    @Scheduled(cron = "0 * * * * *") // used to schedule job every minute
    public void execute1(){
     //   schedulerService.method1();
    }

    @Scheduled(fixedRate = 1) // used to schedule job at a fixed rate of 10 milliseconds
    public void execute2(){
       //schedulerService.method2();
    }

    @Scheduled(cron = "0 0 * * * ?") // used  to schedule job every hour
    public void execute3(){
      //  schedulerService.method2();
    }

    @Scheduled(fixedRate = 5000) // used  to schedule job every hour
    public void execute4(){
        // schedulerService.method2();
    }

    @Scheduled(fixedRate = 1) // used to schedule job at a fixed rate of 10 milliseconds
    @Async
    public void execute5(){
        schedulerService.method2();
    }
}
