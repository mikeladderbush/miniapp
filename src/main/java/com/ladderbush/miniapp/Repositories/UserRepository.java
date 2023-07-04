package com.ladderbush.miniapp.Repositories;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladderbush.miniapp.Entities.UserProfile;


@ComponentScan
@Repository
public interface UserRepository extends JpaRepository<UserProfile,Long> {
    UserProfile findByUsername(String username);
}