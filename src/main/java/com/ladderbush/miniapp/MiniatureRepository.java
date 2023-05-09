package com.ladderbush.miniapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ComponentScan
@Repository
public interface MiniatureRepository extends JpaRepository<Miniature, Long> {
    
}
