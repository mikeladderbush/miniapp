package com.ladderbush.miniapp.Services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Repositories.ImageRepository;
import com.ladderbush.miniapp.Repositories.MiniatureRepository;
import com.ladderbush.miniapp.Security.Role;
import com.ladderbush.miniapp.Security.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/userapi")
@RequiredArgsConstructor
public class UserRepositoryService {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addroletouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/miniatures")
    public List<Miniature> getAllMiniatures() {
        return miniatureRepository.findAll();
    }

    @PostMapping("/miniatures")
    public Miniature createMiniature(@RequestBody Miniature newMiniature) {
        return miniatureRepository.save(newMiniature);
    }

    @GetMapping("/miniatures/{miniatureId}")
    public Optional<Miniature> getMiniatureById(@PathVariable Long miniatureId) {
        return miniatureRepository.findById(miniatureId);
    }

    @PutMapping("/miniatures/{miniatureId}")
    public Miniature updateMiniature(@RequestBody Miniature newMiniature, @PathVariable Long miniatureId) {
        return miniatureRepository.findById(miniatureId)
                .map(miniature -> {
                    miniature.setName(newMiniature.getName());
                    miniature.setScale(newMiniature.getScale());
                    miniature.setProgress(newMiniature.getProgress());
                    miniature.setPage(newMiniature.getPage());

                    return miniatureRepository.save(miniature);
                })
                .orElseGet(() -> {
                    newMiniature.setMiniatureId(miniatureId);
                    return miniatureRepository.save(newMiniature);
                });
    }

    @DeleteMapping("/miniatures/{miniatureId}")
    public void deleteMiniature(@PathVariable Long miniatureId) {
        miniatureRepository.deleteById(miniatureId);
    }

    @GetMapping("/miniatures/{miniatureId}/images")
    public List<Image> getAllImagesForMiniature(@PathVariable Long miniatureId) {
        Miniature miniature = miniatureRepository.findById(miniatureId)
                .orElseThrow(() -> new RuntimeException("Miniature not found"));

        return miniature.getImages();
    }

    @GetMapping("/miniatures/{miniatureId}/images/{imageId}")
    public Optional<Image> getImageById(@PathVariable Long miniatureId, @PathVariable Long imageId) {
        Miniature miniature = miniatureRepository.findById(miniatureId)
                .orElseThrow(() -> new RuntimeException("Miniature not found"));

        return miniature.getImages().stream()
                .filter(image -> image.getImageId().equals(imageId))
                .findFirst();
    }

    @PostMapping("/miniatures/{miniatureId}/images")
    public Image addImageToMiniature(@PathVariable Long miniatureId, @RequestBody Image newImage) {
        Miniature miniature = miniatureRepository.findById(miniatureId)
                .orElseThrow(() -> new RuntimeException("Miniature not found"));

        newImage.setMiniature(miniature);
        miniature.getImages().add(newImage);
        return imageRepository.save(newImage);
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}