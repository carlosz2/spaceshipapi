package com.example.spaceshipapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spaceshipapi.entity.Spaceship;

public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
    List<Spaceship> findByNameContainingIgnoreCase(String name);
}