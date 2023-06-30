package com.ladderbush.miniapp.Services;

import java.util.List;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;
import com.ladderbush.miniapp.Security.Role;
import com.ladderbush.miniapp.Security.User;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    Miniature saveMiniature(Miniature miniature);

    Image saveImage(Image image);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
