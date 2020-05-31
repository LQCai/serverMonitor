package com.luoqincai.runner;

import com.luoqincai.job.CollectCPUJob;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Timer;

@Component
public class CollectJob implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new CollectCPUJob(), 0, 1000);
    }
}
