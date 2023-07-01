package com.ladderbush.miniapp.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;
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

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
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
    public Miniature saveMiniature(Miniature miniature) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveMiniature'");
    }

    @Override
    public Image saveImage(Image image) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveImage'");
    }

    @Override
    public void addImageToMiniature(String miniatureName, String url) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addImageToMiniature'");
    }

    @Override
    public void addMiniatureToUser(String username, String miniatureName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMiniatureToUser'");
    }

    @Override
    public Miniature getMiniature(String miniatureName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMiniature'");
    }

    @Override
    public List<Miniature> getMiniatures() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMiniatures'");
    }

    @Override
    public Image getImage(String url) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getImage'");
    }

    @Override
    public List<Image> getImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getImages'");
    }

}
