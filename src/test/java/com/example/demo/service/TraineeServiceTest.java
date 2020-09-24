package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.repository.TraineeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TraineeServiceTest {

    @Mock
    private TraineeRepository traineeRepository;

    @InjectMocks
    private TraineeService traineeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    class happyPath {

        @Test
        public void should_create_a_trainee_success() {
            Trainee trainee = Trainee.builder()
                    .name("test")
                    .email("e")
                    .github("g")
                    .zoomId("z")
                    .office("o")
                    .build();
            TraineeEntity toSaveTraineeEntity = TraineeEntity.builder()
                    .name("test")
                    .email("e")
                    .github("g")
                    .zoomId("z")
                    .office("o")
                    .build();

            TraineeEntity toReturnTraineeEntity = TraineeEntity.builder()
                    .id(1L)
                    .name("test")
                    .email("e")
                    .github("g")
                    .zoomId("z")
                    .office("o")
                    .groupId(0L)
                    .build();
            Trainee expectTrainee = Trainee.builder()
                    .id(1L)
                    .name("test")
                    .email("e")
                    .github("g")
                    .zoomId("z")
                    .office("o")
                    .groupId(0L)
                    .build();

            when(traineeRepository.save(toSaveTraineeEntity)).thenReturn(toReturnTraineeEntity);

            Trainee result = traineeService.saveTrainee(trainee);

            assertEquals(expectTrainee, result);

        }

        @Test
        public void should_get_trainee_success() {
            TraineeEntity toReturnTraineeEntity = TraineeEntity.builder()
                    .id(1L)
                    .name("test")
                    .email("e")
                    .github("g")
                    .zoomId("z")
                    .office("o")
                    .groupId(0L)
                    .build();

            Trainee expectTrainee = Trainee.builder()
                    .id(1L)
                    .name("test")
                    .email("e")
                    .github("g")
                    .zoomId("z")
                    .office("o")
                    .groupId(0L)
                    .build();

            when(traineeRepository.findByGroupId(0L)).thenReturn(Arrays.asList(toReturnTraineeEntity));

            List<Trainee> result = traineeService.getTrainees(false, 0L);

            assertEquals(Arrays.asList(expectTrainee), result);
        }
    }

}