package com.ladderbush.miniapp.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MiniatureRepository miniatureRepository;
    private final ImageRepository imageRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getRoleName());
        return roleRepository.save(role);
    }

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
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public void addMiniatureToUser(String username, String miniatureName) {
        log.info("Adding miniature {} to user {}", miniatureName, username);
        User user = userRepository.findByUsername(username);
        Miniature miniature = miniatureRepository.findByMiniatureName(miniatureName);
        user.getMiniatures().add(miniature);
    }

    @Override
    public void addImageToMiniature(String miniatureName, String imageUrl) {
        log.info("Adding image to miniature {}", miniatureName);
        Miniature miniature = miniatureRepository.findByMiniatureName(miniatureName);
        Image image = imageRepository.findByImageUrl(imageUrl);
        miniature.getImages().add(image);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching username: {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
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
