package com.ladderbush.miniapp.Repositories;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladderbush.miniapp.Entities.Role;


@ComponentScan
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByRoleName(String roleName);
}