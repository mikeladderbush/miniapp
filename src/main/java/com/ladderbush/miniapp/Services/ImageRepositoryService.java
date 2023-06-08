package com.ladderbush.miniapp.Services;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Service
public class ImageRepositoryService {

    private final ImageRepository repository;

    @Autowired
    public ImageRepositoryService(ImageRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/images")
    public List<Image> getAllImages() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/images/{id}")
    public Optional<Image> getImageById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/images")
    public Image createImage(@RequestBody Image newImage) {
        return repository.save(newImage);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/images/{id}")
    public Image updateImage(@RequestBody Image updatedImage, @PathVariable Long id) {
        return repository.findById(id)
                .map(image -> {
                    image.setImage(updatedImage.getImage());
                    image.setMiniatureId(updatedImage.getMiniatureId());
                    return repository.save(image);
                })
                .orElseGet(() -> {
                    updatedImage.setId(id);
                    return repository.save(updatedImage);
                });
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/images/{id}")
    public void deleteImage(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
