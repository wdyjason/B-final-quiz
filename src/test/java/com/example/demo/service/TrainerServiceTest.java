package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.exception.NotSupportOperationException;
import com.example.demo.repository.TrainerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
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

            Trainer result = trainerService.saveTrainer(trainer);

            assertEquals(expectTrainer, result);

        }

        @Test
        public void should_get_trainers_success() throws NotSupportOperationException {
            TrainerEntity toReturnTrainerEntity = TrainerEntity.builder().id(1L).name("trainer").build();

            Trainer expectTrainer = Trainer.builder().id(1L).name("trainer").build();

            when(trainerRepository.findByGroupId(0L)).thenReturn(Arrays.asList(toReturnTrainerEntity));

            List<Trainer> result = trainerService.getTrainers(false);

            assertEquals(Arrays.asList(expectTrainer), result);
        }

        @Test
        public void should_get_All_trainers_success() throws NotSupportOperationException {
            TrainerEntity toReturnTrainerEntity = TrainerEntity.builder().id(1L).name("trainer").build();

            Trainer expectTrainer = Trainer.builder().id(1L).name("trainer").build();

            when(trainerRepository.findAll()).thenReturn(Arrays.asList(toReturnTrainerEntity));

            List<Trainer> result = trainerService.getAllTrainers();

            assertEquals(Arrays.asList(expectTrainer), result);
        }
    }

    @Nested
    class sadPath {

        @Test
        public void should_throw_not_support_operation_exception_when_grouped_is_true() {
            assertThrows(NotSupportOperationException.class, () -> {trainerService.getTrainers(true);}); //
        }

        @Test
        public void should_throw_null_pointer_operation_exception_when_grouped_is_null() {
            assertThrows(NullPointerException.class, () -> {trainerService.getTrainers(null);}); //
        }
    }
}