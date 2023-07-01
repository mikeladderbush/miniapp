package com.ladderbush.miniapp.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Repositories.ImageRepository;
import com.ladderbush.miniapp.Repositories.MiniatureRepository;
import com.ladderbush.miniapp.Repositories.RoleRepository;
import com.ladderbush.miniapp.Repositories.UserRepository;
import com.ladderbush.miniapp.Security.Role;
import com.ladderbush.miniapp.Security.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MiniatureRepository miniatureRepository;
    private final ImageRepository imageRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Miniature saveMiniature(Miniature miniature) {
        return miniatureRepository.save(miniature);
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public void addMiniatureToUser(String username, String miniatureName) {
        User user = userRepository.findByUsername(username);
        Miniature miniature = miniatureRepository.findByMiniatureName(miniatureName);
        user.getMiniatures().add(miniature);
    }

    @Override
    public void addImageToMiniature(String miniatureName, String url) {
        Miniature miniature = miniatureRepository.findByMiniatureName(miniatureName);
        Image image = imageRepository.findByImageUrl(url);
        miniature.getImages().add(image);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Miniature getMiniature(String miniatureName) {
        return miniatureRepository.findByMiniatureName(miniatureName);
    }

    @Override
    public List<Miniature> getMiniatures() {
        return miniatureRepository.findAll();
    }

    @Override
    public Image getImage(String url) {
        return imageRepository.findByImageUrl(url);
    }

    @Override
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

}
