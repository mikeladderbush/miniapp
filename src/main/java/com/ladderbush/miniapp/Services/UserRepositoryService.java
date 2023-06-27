package com.ladderbush.miniapp.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladderbush.miniapp.Security.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/userapi")
@RequiredArgsConstructor
public class UserRepositoryService {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
