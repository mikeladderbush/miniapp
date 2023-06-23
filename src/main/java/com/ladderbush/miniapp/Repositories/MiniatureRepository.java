package com.ladderbush.miniapp.Repositories;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;

@ComponentScan
@Repository
public interface MiniatureRepository extends JpaRepository<Miniature, Long> {
    List<Miniature> findByImages(Image image);
}