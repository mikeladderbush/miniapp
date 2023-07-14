package com.ladderbush.miniapp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Repositories.ImageRepository;
import com.ladderbush.miniapp.Repositories.MiniatureRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService {

    private final MiniatureRepository miniatureRepository;
    private final ImageRepository imageRepository;


    @Override
    public Miniature saveMiniature(Miniature miniature) {
        log.info("Saving new miniature {} to the database", miniature.getMiniatureName());
        return miniatureRepository.save(miniature);
    }

    @Override
    public Image saveImage(Image image) {
        log.info("Saving new image to the database");
        return imageRepository.save(image);
    }


    @Override
    public void addImageToMiniature(String miniatureName, String imageUrl) {
        log.info("Adding image to miniature {}", miniatureName);
        Miniature miniature = miniatureRepository.findByMiniatureName(miniatureName);
        Image image = imageRepository.findByImageUrl(imageUrl);
        miniature.getImages().add(image);
    }

    @Override
    public Miniature getMiniature(String miniatureName) {
        log.info("Fetching miniature {}", miniatureName);
        return miniatureRepository.findByMiniatureName(miniatureName);
    }

    @Override
    public List<Miniature> getMiniatures() {
        log.info("Fetching all miniatures");
        return miniatureRepository.findAll();
    }

    @Override
    public Image getImage(String imageUrl) {
        log.info("Fetching image");
        return imageRepository.findByImageUrl(imageUrl);
    }

    @Override
    public List<Image> getImages() {
        log.info("Fetching all images");
        return imageRepository.findAll();
    }

}