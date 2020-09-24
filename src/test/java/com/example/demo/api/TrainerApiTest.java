package com.example.demo.api;

import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.repository.TrainerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TrainerApiTest {

    @Autowired
    private TrainerApi trainerApi;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TrainerRepository trainerRepository;


    @BeforeEach
    public void setUp() {
        trainerRepository.deleteAll();
        trainerRepository.save(new TrainerEntity(1L, "old", 0L));
    }

    @AfterEach
    public void tearDown() {
        trainerRepository.deleteAll();
    }

    @Nested
    class happyPath {

        @Test
        public void should_create_a_trainer_success() throws Exception {
            String postTrainer = "{\"name\":\"trainer\"}";

            mockMvc.perform(post("/trainers").content(postTrainer).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.name", is("trainer")))
                    .andExpect(status().isCreated());
        }

        @Test
        public void should_get_trainers_success() throws Exception {
            mockMvc.perform(post("/trainers/?grouped=false"))
                    .andExpect(jsonPath("$[0].name", is("trainer")))
                    .andExpect(status().isCreated());
        }
    }

    @Nested
    class sadPath {

        @Test
        public void should_create_failed_when_trainer_name_not_exists() throws Exception {
            String postTrainer = "{\"name\":\"\"}";

            mockMvc.perform(post("/trainers").content(postTrainer).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        }
    }
}