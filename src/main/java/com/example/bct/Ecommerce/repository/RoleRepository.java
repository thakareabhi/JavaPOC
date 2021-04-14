package com.example.bct.Ecommerce.repository;

import com.example.bct.Ecommerce.entity.ERole;
import com.example.bct.Ecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(ERole name);
}
