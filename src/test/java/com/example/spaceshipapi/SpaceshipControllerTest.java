package com.example.spaceshipapi;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.spaceshipapi.entity.Spaceship;
import com.example.spaceshipapi.service.SpaceshipService;

@SpringBootTest
@AutoConfigureMockMvc
public class SpaceshipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpaceshipService service;

    
    /** 
     * @throws Exception
     */
    @Test
    public void testGetAllSpaceships() throws Exception {
        Spaceship spaceship1 = new Spaceship();
        spaceship1.setId(1L);
        spaceship1.setName("X-Wing");
        spaceship1.setMedia("Star Wars");

        Spaceship spaceship2 = new Spaceship();
        spaceship2.setId(2L);
        spaceship2.setName("Enterprise");
        spaceship2.setMedia("Star Trek");

        Pageable pageable = PageRequest.of(0, 5);
        Page<Spaceship> spaceshipPage = new PageImpl<>(Arrays.asList(spaceship1, spaceship2), pageable, 2);

        when(service.getAllSpaceships(pageable)).thenReturn(spaceshipPage);

        mockMvc.perform(get("/api/spaceships?page=0")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("X-Wing"))
                .andExpect(jsonPath("$.content[1].name").value("Enterprise"));
    }

    
    /** 
     * @throws Exception
     */
    @Test
    public void testGetSpaceshipById() throws Exception {
        Spaceship spaceship = new Spaceship();
        spaceship.setId(1L);
        spaceship.setName("X-Wing");
        spaceship.setMedia("Star Wars");

        when(service.getSpaceshipById(1L)).thenReturn(spaceship);

        mockMvc.perform(get("/api/spaceships/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("X-Wing"))
                .andExpect(jsonPath("$.media").value("Star Wars"));
    }

    
    /** 
     * @throws Exception
     */
    @Test
    public void testGetSpaceshipsByName() throws Exception {
        Spaceship spaceship1 = new Spaceship();
        spaceship1.setId(1L);
        spaceship1.setName("X-Wing");
        spaceship1.setMedia("Star Wars");

        Spaceship spaceship2 = new Spaceship();
        spaceship2.setId(2L);
        spaceship2.setName("Enterprise");
        spaceship2.setMedia("Star Trek");

        when(service.getSpaceshipsByName("X")).thenReturn(Arrays.asList(spaceship1));

        mockMvc.perform(get("/api/spaceships/search?name=X")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("X-Wing"));
    }

    @Test
    public void testCreateSpaceship() throws Exception {
        Spaceship spaceship = new Spaceship();
        spaceship.setId(1L);
        spaceship.setName("X-Wing");
        spaceship.setMedia("Star Wars");

        when(service.createSpaceship(any(Spaceship.class))).thenReturn(spaceship);

        mockMvc.perform(post("/api/spaceships")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"X-Wing\", \"media\": \"Star Wars\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("X-Wing"))
                .andExpect(jsonPath("$.media").value("Star Wars"));
    }

    @Test
    public void testUpdateSpaceship() throws Exception {
        Spaceship spaceship = new Spaceship();
        spaceship.setId(1L);
        spaceship.setName("X-Wing");
        spaceship.setMedia("Star Wars");

        when(service.updateSpaceship(any(Spaceship.class))).thenReturn(spaceship);

        mockMvc.perform(put("/api/spaceships/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"X-Wing\", \"media\": \"Star Wars\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("X-Wing"))
                .andExpect(jsonPath("$.media").value("Star Wars"));
    }

    @Test
    public void testDeleteSpaceship() throws Exception {
        doNothing().when(service).deleteSpaceship(1L);

        mockMvc.perform(delete("/api/spaceships/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}