/* 
package com.ladderbush.miniapp.Services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Repositories.MiniatureRepository;

@Component
public class Initializer implements CommandLineRunner {

    private final MiniatureRepository miniatureRepository;
    
    public Initializer(MiniatureRepository miniatureRepository) {
        this.miniatureRepository = miniatureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (miniatureRepository.count() == 0) {
            Miniature defaultMiniature = new Miniature();
            defaultMiniature.setMiniatureName("default");
            defaultMiniature.setPage("http://localhost:3000/user/miniatures/1");
            defaultMiniature.setProgress("default");
            defaultMiniature.setScale(0);
            miniatureRepository.save(defaultMiniature);
        }

    }
}

*/