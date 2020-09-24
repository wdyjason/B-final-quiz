package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.repository.TrainerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TrainerServiceTest {

    @Mock
    private TrainerRepository trainerRepository;

    @InjectMocks
    private TrainerService trainerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    class happyPath {

        @Test
        public void should_create_a_trainer_success() {
            Trainer trainer = Trainer.builder().name("trainer").build();
            TrainerEntity toSaveTrainerEntity = TrainerEntity.builder().name("trainer").build();
            TrainerEntity toReturnTrainerEntity = TrainerEntity.builder().id(1L).name("trainer").build();
            Trainer expectTrainer = Trainer.builder().id(1L).name("trainer").build();

            when(trainerRepository.save(toSaveTrainerEntity)).thenReturn(toReturnTrainerEntity);

            Trainer result = trainerService.createTrainer(trainer);

            assertEquals(expectTrainer, result);

        }
    }
}