package com.example.spaceshipapi.exception;

public class ResourceNotFoundException extends RuntimeException {
    private Long resourceId;
        /**
         * 
         * @param resourceId
         */
    public ResourceNotFoundException(Long resourceId) {
        super();
        this.resourceId = resourceId;
    }

    
    /** 
     * @return Long
     */
    public Long getResourceId() {
        return resourceId;
    }
}