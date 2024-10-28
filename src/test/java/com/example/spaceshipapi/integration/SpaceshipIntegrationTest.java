package com.example.spaceshipapi.integration;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@Tag("integration")
public class SpaceshipIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "adminpassword";
    @Test
    public void testGetAllSpaceships() throws Exception {
        mockMvc.perform(get("/api/spaceships")
                .contentType(MediaType.APPLICATION_JSON)
                .with(httpBasic(USERNAME, PASSWORD)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(5)); // Verifica que hay 5 elementos en el campo content
    }
}