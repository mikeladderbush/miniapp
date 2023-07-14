package com.ladderbush.miniapp.Services;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRepositoryService {

    private final UserService userService;

    @GetMapping("/miniatures")
    public ResponseEntity<List<Miniature>> getAllMiniatures() {
        return ResponseEntity.ok().body(userService.getMiniatures());
    }

    @GetMapping("/miniature/images")
    public ResponseEntity<List<Image>> getAllImages() {
        return ResponseEntity.ok().body(userService.getImages());
    }

    @PostMapping("/miniature/save")
    public ResponseEntity<Miniature> saveMiniature(@RequestBody Miniature miniature) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/miniature/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveMiniature(miniature));
    }

    @PostMapping("/miniature/image/save")
    public ResponseEntity<Image> saveImage(@RequestBody Image image) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/miniature/image/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.saveImage(image));
    }


    @PostMapping("/image/addimagetominiature")
    public ResponseEntity<?> addImageToMiniature(@RequestBody ImageToMiniatureForm form) {
        userService.addImageToMiniature(form.getMiniatureName(), form.getUrl());
        return ResponseEntity.ok().build();
    }

}

@Data
class ImageToMiniatureForm {
    private String miniatureName;
    private String url;
}