package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import static com.example.demo.utils.Domain2Entity.toEntity;
import static com.example.demo.utils.Entity2Domain.toDomain;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer createTrainer(Trainer trainer) {
        TrainerEntity saved = trainerRepository.save(toEntity(trainer));
        return toDomain(saved);
    }
}
