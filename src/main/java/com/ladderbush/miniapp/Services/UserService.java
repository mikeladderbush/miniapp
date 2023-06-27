package com.ladderbush.miniapp.Services;

import java.util.List;

import com.ladderbush.miniapp.Security.Role;
import com.ladderbush.miniapp.Security.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
