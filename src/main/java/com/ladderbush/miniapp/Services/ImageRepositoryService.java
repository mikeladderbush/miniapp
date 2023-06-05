package com.ladderbush.miniapp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Repositories.ImageRepository;


@RestController
@Service
public class ImageRepositoryService {

    @Autowired
    private final ImageRepository repository;

    ImageRepositoryService(ImageRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/images")
    List<Image> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/images")
    Image newImage(@RequestBody Image newImage) {

        return repository.save(newImage);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/images/{id}")
    Optional<Image> one(@PathVariable Long id) {

        return repository.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/images/{id}")
    Image replaceImage(@RequestBody Image newImage, @PathVariable Long id) {

        return repository.findById(id)
                .map(Image -> {
                    Image.setImage(newImage.getImage());
                    return repository.save(Image);
                })
                .orElseGet(() -> {
                    newImage.setId(id);
                    return repository.save(newImage);
                });
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/images/{id}")
    void deleteImage(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
