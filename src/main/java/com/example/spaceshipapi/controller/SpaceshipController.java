package com.example.spaceshipapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spaceshipapi.entity.Spaceship;
import com.example.spaceshipapi.service.SpaceshipService;

@RestController
@RequestMapping("/api/spaceships")
public class SpaceshipController {
    @Autowired
    private SpaceshipService service;

    @GetMapping
    public Page<Spaceship> getAllSpaceships(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return service.getAllSpaceships(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spaceship> getSpaceshipById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSpaceshipById(id));
    }

    @GetMapping("/search")
    public List<Spaceship> getSpaceshipsByName(@RequestParam String name) {
        return service.getSpaceshipsByName(name);
    }

    @PostMapping
    public Spaceship createSpaceship(@RequestBody Spaceship spaceship) {
        return service.createSpaceship(spaceship);
    }

    @PutMapping("/{id}")
    public Spaceship updateSpaceship(@PathVariable Long id, @RequestBody Spaceship spaceship) {
        spaceship.setId(id);
        return service.updateSpaceship(spaceship);
    }

    @DeleteMapping("/{id}")
    public void deleteSpaceship(@PathVariable Long id) {
        service.deleteSpaceship(id);
    }
}