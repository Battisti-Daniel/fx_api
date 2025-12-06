package com.daniel.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.api.entities.ServerEntity;

public interface ServerRepository extends JpaRepository<ServerEntity, Integer> {
    
    Optional<ServerEntity> findByName(String name);

}
