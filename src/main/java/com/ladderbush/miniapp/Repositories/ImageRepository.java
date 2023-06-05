package com.ladderbush.miniapp.Repositories;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladderbush.miniapp.Entities.Image;

@ComponentScan
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}

