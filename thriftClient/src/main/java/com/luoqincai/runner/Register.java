package com.luoqincai.runner;

import com.luoqincai.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Register implements CommandLineRunner {
    @Autowired
    private RegisterService registerService;

    @Override
    public void run(String... args) throws Exception {
        registerService.register();
    }
}
