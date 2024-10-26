package com.example.spaceshipapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Spaceship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String media;

    
    /** 
     * @return Long
     */
    // Getters y setters
    public Long getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return String
     */

    public String getMedia() {
        return media;
    }

    /**
     * 
     * @param media
     */

    public void setMedia(String media) {
        this.media = media;
    }
}