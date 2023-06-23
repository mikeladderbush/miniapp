package com.ladderbush.miniapp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Repositories.MiniatureRepository;
import com.ladderbush.miniapp.Repositories.ImageRepository;

@RestController
@Service
public class MiniatureRepositoryService {

    private final MiniatureRepository miniatureRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public MiniatureRepositoryService(MiniatureRepository miniatureRepository, ImageRepository imageRepository) {
        this.miniatureRepository = miniatureRepository;
        this.imageRepository = imageRepository;
    }

    @GetMapping("/miniatures")
    public List<Miniature> getAllMiniatures() {
        return miniatureRepository.findAll();
    }

    @PostMapping("/miniatures")
    public Miniature createMiniature(@RequestBody Miniature newMiniature) {
        return miniatureRepository.save(newMiniature);
    }

    @GetMapping("/miniatures/{Id}")
    public Optional<Miniature> getMiniatureById(@PathVariable Long Id) {
        return miniatureRepository.findById(Id);
    }

    @PutMapping("/miniatures/{Id}")
    public Miniature updateMiniature(@RequestBody Miniature newMiniature, @PathVariable Long Id) {
        return miniatureRepository.findById(Id)
                .map(miniature -> {
                    miniature.setName(newMiniature.getName());
                    miniature.setScale(newMiniature.getScale());
                    miniature.setProgress(newMiniature.getProgress());
                    miniature.setPage(newMiniature.getPage());

                    return miniatureRepository.save(miniature);
                })
                .orElseGet(() -> {
                    newMiniature.setId(Id);
                    return miniatureRepository.save(newMiniature);
                });
    }

    @DeleteMapping("/miniatures/{Id}")
    public void deleteMiniature(@PathVariable Long Id) {
        miniatureRepository.deleteById(Id);
    }

    @GetMapping("/miniatures/{id}/images")
    public List<Image> getAllImagesForMiniature(@PathVariable Long id) {
        Miniature miniature = miniatureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Miniature not found"));

        return miniature.getImages();
    }

    @GetMapping("/miniatures/{Id}/images/{imageId}")
    public Optional<Image> getImageById(@PathVariable Long Id, @PathVariable Long imageId) {
        Miniature miniature = miniatureRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Miniature not found"));

        return miniature.getImages().stream()
                .filter(image -> image.getImageId().equals(imageId))
                .findFirst();
    }

    @PostMapping("/miniatures/{id}/images")
    public Image addImageToMiniature(@PathVariable Long id, @RequestBody Image newImage) {
        Miniature miniature = miniatureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Miniature not found"));

        newImage.setMiniature(miniature);
        miniature.getImages().add(newImage);
        return imageRepository.save(newImage);
    }
}
