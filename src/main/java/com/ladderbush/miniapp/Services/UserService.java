package com.ladderbush.miniapp.Services;

import java.util.List;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Entities.Role;
import com.ladderbush.miniapp.Entities.UserProfile;

public interface UserService {
    UserProfile saveUserProfile(UserProfile userProfile);

    Role saveRole(Role role);

    Miniature saveMiniature(Miniature miniature);

    Image saveImage(Image image);

    void addRoleToUser(String username, String roleName);

    void addImageToMiniature(String miniatureName, String imageUrl);

    void addMiniatureToUser(String username, String miniatureName);

    UserProfile getUser(String username);

    List<UserProfile> getUsers();

    Miniature getMiniature(String miniatureName);

    List<Miniature> getMiniatures();

    Image getImage(String imageUrl);

    List<Image> getImages();

}