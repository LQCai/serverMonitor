package com.luoqincai.job;

import com.luoqincai.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;

public class CollectCPUJob extends TimerTask {
    @Autowired
    private CollectService collectService;

    @Override
    public void run() {
        collectService.CPU();
    }
}
