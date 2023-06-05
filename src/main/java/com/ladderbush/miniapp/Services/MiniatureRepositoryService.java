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

import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Repositories.MiniatureRepository;

@RestController
@Service
public class MiniatureRepositoryService {

    @Autowired
    private final MiniatureRepository repository;

    MiniatureRepositoryService(MiniatureRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/miniatures")
    List<Miniature> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/miniatures")
    Miniature newMiniature(@RequestBody Miniature newMiniature) {

        return repository.save(newMiniature);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/miniatures/{id}")
    Optional<Miniature> one(@PathVariable Long id) {

        return repository.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/miniatures/{id}")
    Miniature replaceMiniature(@RequestBody Miniature newMiniature, @PathVariable Long id) {

        return repository.findById(id)
                .map(miniature -> {
                    miniature.setName(newMiniature.getName());
                    miniature.setScale(newMiniature.getScale());
                    miniature.setProgress(newMiniature.getProgress());
                    miniature.setPage(newMiniature.getPage());

                    return repository.save(miniature);
                })
                .orElseGet(() -> {
                    newMiniature.setId(id);
                    return repository.save(newMiniature);
                });
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/miniatures/{id}")
    void deleteMiniature(@PathVariable Long id) {
        repository.deleteById(id);
    }

}