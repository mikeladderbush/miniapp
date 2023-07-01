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

    @PostMapping("/miniature/addminiaturetouser")
    public ResponseEntity<?> addMiniatureToUser(@RequestBody MiniatureToUserForm form) {
        userService.addMiniatureToUser(form.getUsername(), form.getMiniatureName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/miniature/addimagetominiature")
    public ResponseEntity<?> addImageToMiniature(@RequestBody ImageToMiniatureForm form) {
        userService.addImageToMiniature(form.getMiniatureName(), form.getUrl());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/miniatures")
    public ResponseEntity<List<Miniature>> getAllMiniatures() {
        return ResponseEntity.ok().body(userService.getMiniatures());
    }

    @PostMapping("/user/miniatures")
    public ResponseEntity<Miniature> createMiniature(@RequestBody Miniature miniature) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/miniature/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveMiniature(miniature));
    }

    @PostMapping("/user/miniature/images")
    public ResponseEntity<Image> createImage(@RequestBody Image image) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/miniature/image/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.saveImage(image));
    }

}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}

@Data
class MiniatureToUserForm {
    private String username;
    private String miniatureName;
}

@Data
class ImageToMiniatureForm {
    private String miniatureName;
    private String url;
}