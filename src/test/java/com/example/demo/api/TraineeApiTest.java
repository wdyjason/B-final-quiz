package com.example.demo.api;

import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.repository.TraineeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TraineeApiTest {

    @Autowired
    private TraineeApi traineeApi;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TraineeRepository traineeRepository;

    @BeforeEach
    public void setUp() {
        traineeRepository.deleteAll();
        traineeRepository.save(new TraineeEntity(1L, "n", "o", "e@qq.com", "g", "z",0L));
    }

    @AfterEach
    public void tearDown() {
        traineeRepository.deleteAll();
    }

    @Nested
    class happyPath {


        @Test
        public void should_create_a_trainee_success() throws Exception {
            String postTrainee = "{\"name\":\"trainee\", \"office\":\"o\", \"email\":\"e@qq.com\", \"github\":\"g\", \"zoomId\":\"z\"}";

            mockMvc.perform(post("/trainees").content(postTrainee).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.name", is("trainee")))
                    .andExpect(jsonPath("$.office", is("o")))
                    .andExpect(jsonPath("$.email", is("e@qq.com")))
                    .andExpect(jsonPath("$.github", is("g")))
                    .andExpect(jsonPath("$.zoomId", is("z")))
                    .andExpect(status().isCreated());
        }

        @Test
        public void should_get_trainees_success() throws Exception {
            mockMvc.perform(get("/trainees/?grouped=false"))
                    .andExpect(jsonPath("$[0].name", is("n")))
                    .andExpect(jsonPath("$[0].office", is("o")))
                    .andExpect(jsonPath("$[0].email", is("e@qq.com")))
                    .andExpect(jsonPath("$[0].github", is("g")))
                    .andExpect(jsonPath("$[0].zoomId", is("z")))
                    .andExpect(status().isOk());
        }
    }

    @Nested
    class sadPath {

        @Test
        public void should_create_failed_when_trainees_validate_fail() throws Exception {
            String postTrainee = "{\"name\":\"\"}";

            mockMvc.perform(post("/trainees").content(postTrainee).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        }

        @Test
        public void should_create_failed_when_email_validate_fail() throws Exception {
            String postTrainee = "{\"name\":\"trainee\", \"office\":\"o\", \"email\":\"ee\", \"github\":\"g\", \"zoomId\":\"z\"}";

            mockMvc.perform(post("/trainees").content(postTrainee).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        }
    }

}