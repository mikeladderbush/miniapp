package com.ladderbush.miniapp.Services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Repositories.ImageRepository;
import com.ladderbush.miniapp.Repositories.MiniatureRepository;

@Component
public class Initializer implements CommandLineRunner {

    private final MiniatureRepository miniatureRepository;
    private final ImageRepository imageRepository;
    
    public Initializer(MiniatureRepository miniatureRepository, ImageRepository imageRepository) {
        this.miniatureRepository = miniatureRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (miniatureRepository.count() == 0) {
            Miniature defaultMiniature = new Miniature();
            defaultMiniature.setName("default");
            defaultMiniature.setPage("default");
            defaultMiniature.setProgress("default");
            defaultMiniature.setScale(0);
            miniatureRepository.save(defaultMiniature);
        }

        if (imageRepository.count() == 0) {
            Image defaultImage = new Image();
            defaultImage.setImage("default");
            defaultImage.setMiniatureId(0L);
            imageRepository.save(defaultImage);
        }
    }
}