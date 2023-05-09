package com.ladderbush.miniapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class MiniatureLoader implements CommandLineRunner { 

    private final MiniatureRepository repository;

    @Autowired
    public MiniatureLoader(MiniatureRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Miniature("Ultramarine", 28, Progress.NOTSTARTED));
    }
}