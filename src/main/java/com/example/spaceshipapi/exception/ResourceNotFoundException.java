package com.example.spaceshipapi.exception;

public class ResourceNotFoundException extends RuntimeException {
    private Long resourceId;

    public ResourceNotFoundException(Long resourceId) {
        super();
        this.resourceId = resourceId;
    }

    public Long getResourceId() {
        return resourceId;
    }
}