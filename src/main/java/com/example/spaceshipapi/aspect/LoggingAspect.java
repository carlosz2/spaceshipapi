package com.example.spaceshipapi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    
    /** 
     * @param id
     */
    @Pointcut("execution(* com.example.spaceshipapi.service.SpaceshipService.getSpaceshipById(..)) && args(id)")
    public void getSpaceshipById(Long id) {}

    
    /** 
     * @param id
     */
    @Before("getSpaceshipById(id)")
    public void logIfNegativeId(Long id) {
        if (id < 0) {
            logger.warn("Requested spaceship with negative id: " + id);
    
        }
    }
}
