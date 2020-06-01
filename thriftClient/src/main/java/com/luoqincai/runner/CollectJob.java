package com.luoqincai.runner;

import com.luoqincai.job.CollectCPUJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Timer;

@Component
public class CollectJob implements CommandLineRunner {
    @Autowired
    private CollectCPUJob collectCPUJob;

    @Override
    public void run(String... args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(collectCPUJob, 0, 3000);
    }
}
